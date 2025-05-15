package com.vertafore.jdbcapp.dao;

import com.vertafore.jdbcapp.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJdbcDAO implements  DAO<Course> {

    private static final Logger LOG = LoggerFactory.getLogger(CourseJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    RowMapper<Course> rowMapper = (rs, rowNum) -> {
        Course course = new Course();
        course.setCourseId(rs.getInt("course_id"));
        course.setTitle(rs.getString("title"));
        course.setDescription(rs.getString("description"));
        course.setLink(rs.getString("link"));
        return course;
    };

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> list() {
        String sql = "SELECT course_id, title, description, link FROM course";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void create(Course course) {
        String sql = "INSERT INTO course (title, description, link) VALUES (?,?,?)";
        jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink());
    }

    @Override
    public Optional<Course> get(int id) {
        String sql = "SELECT course_id, title, description, link FROM course WHERE course_id = ?";
        Course course = null;

        try {
            course = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (DataAccessException dae) {
            LOG.info("Course not found for id [{}]", id);
        }

        return Optional.ofNullable(course);
    }

    @Override
    public void update(Course course, int id) {
        String sql = "UPDATE course SET title = ?, description = ?, link = ? WHERE course_id = ?";
        jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM course WHERE course_id = ?";
        jdbcTemplate.update(sql, id);
    }
}

package com.vertafore.jdbcapp;

import com.vertafore.jdbcapp.dao.DAO;
import com.vertafore.jdbcapp.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcAppApplication {

    private static DAO<Course> dao;

    public JdbcAppApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcAppApplication.class, args);

        System.out.println("\nAll Courses ------------------------------------");
        dao.list().forEach(System.out::println);

        System.out.println("\nOne Course ------------------------------------");
        System.out.println(dao.get(1));

        System.out.println("\nCreated Course ------------------------------------");
        Course createdCourse = new Course("Course Title", "A description of a new course", "A good link");
        dao.create(createdCourse);
        System.out.println(dao.get(6));

        System.out.println("\nUpdated Course ------------------------------------");
        Course updatedCourse = new Course("Changed", "Changed", "Changed");
        dao.update(updatedCourse, 2);
        System.out.println(dao.get(2));

        System.out.println("\nDeleted Course ------------------------------------");
        dao.delete(3);
        System.out.println(dao.get(3));
    }

}

// https://www.youtube.com/watch?v=0uLqdBpYAVA
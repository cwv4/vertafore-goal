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
    }

}

// https://www.youtube.com/watch?v=0uLqdBpYAVA
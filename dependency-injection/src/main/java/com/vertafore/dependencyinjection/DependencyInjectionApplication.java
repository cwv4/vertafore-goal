package com.vertafore.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);

        // Dependency injection using application context. Good in main, but more difficult elsewhere
        Dog dog = context.getBean(Dog.class);
        dog.bark();
        dog.playWithToy();
    }

}

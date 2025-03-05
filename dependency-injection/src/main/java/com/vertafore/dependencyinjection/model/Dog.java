package com.vertafore.dependencyinjection.model;

import org.springframework.stereotype.Component;

// @Component tells Spring to create an instance of this class inside IoC Container
@Component
public class Dog {

    ToyBox toyBox;

    // Constructor dependency injection, best practice for DI
    Dog(ToyBox toyBox) {
        this.toyBox = toyBox;
    }

    public void bark() {
        System.out.println("Bark!");
    }

    public void playWithToy() {
        toyBox.getToy().play();
    }

}

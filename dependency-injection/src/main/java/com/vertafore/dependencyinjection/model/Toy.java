package com.vertafore.dependencyinjection.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Toy {

    // Field injection, works but not recommended
    @Autowired
    ToyMessage toyMessage;

    public void play() {
        System.out.println(toyMessage.getMessage());
    }
}

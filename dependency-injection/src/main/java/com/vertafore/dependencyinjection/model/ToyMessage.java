package com.vertafore.dependencyinjection.model;

import org.springframework.stereotype.Component;

@Component
public class ToyMessage {

    String message = "Playing with the toy";

    public String getMessage() {
        return message;
    }

}

package com.vertafore.dependencyinjection.service;

public class MessageService {

    private String message;

    public MessageService(String message) {
        this.message = message;
    }

    public void sendMessage() {
        System.out.println(message);
    }

}

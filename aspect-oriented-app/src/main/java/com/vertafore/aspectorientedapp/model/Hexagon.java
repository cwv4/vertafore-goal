package com.vertafore.aspectorientedapp.model;

import org.springframework.stereotype.Component;

@Component
public class Hexagon {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "name='" + name + '\'' +
                '}';
    }
}

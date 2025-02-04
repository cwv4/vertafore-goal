package com.vertafore.aspectorientedapp.model;

import org.springframework.stereotype.Component;

@Component
public class Triangle {

    private String name;

    public Triangle() {
        this.name = "George";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                '}';
    }
}

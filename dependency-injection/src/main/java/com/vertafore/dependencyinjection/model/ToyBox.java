package com.vertafore.dependencyinjection.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToyBox {

    Toy toy;

    // Setter injection, a good alternative to constructor injection
    @Autowired
    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public Toy getToy() {
        return toy;
    }

}

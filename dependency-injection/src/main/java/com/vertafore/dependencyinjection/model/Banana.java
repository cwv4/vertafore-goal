package com.vertafore.dependencyinjection.model;

public class Banana {

    private String eatString;

    public Banana(String eatString) {
        this.eatString = eatString;
    }

    public void eatBanana() {
        System.out.println(eatString);
    }

    public void setEatString(String eatString) {
        this.eatString = eatString;
    }
}

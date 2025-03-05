package com.vertafore.dependencyinjection.model;

public class Apple {

    private String eatString;

    public Apple(String eatString) {
        this.eatString = eatString;
    }

    public void eatApple() {
        System.out.println(eatString);
    }

    public void setEatString(String eatString) {
        this.eatString = eatString;
    }
}

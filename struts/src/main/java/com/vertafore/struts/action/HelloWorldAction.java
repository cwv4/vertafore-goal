package com.vertafore.struts.action;

public class HelloWorldAction {

    private static final String SUCCESS = "SUCCESS";

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String execute() {
        System.out.println("Value of firstname is: " + firstName);
        return SUCCESS;
    }
}

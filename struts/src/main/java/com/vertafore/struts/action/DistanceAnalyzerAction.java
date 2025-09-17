package com.vertafore.struts.action;

import com.vertafore.struts.model.DistanceOption;

public class DistanceAnalyzerAction {

    private static final String SUCCESS = "SUCCESS";

    private Integer meters;
    private String response;

    public Integer getMeters() {
        return meters;
    }

    public void setMeters(Integer meters) {
        this.meters = meters;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String execute() {
        System.out.println("Given distance in meters is: " + meters);

        DistanceOption option = DistanceOption.getRandomOption();

        double calculatedDistance = meters * DistanceOption.getOptionFactor(option);

        response = String.format(DistanceOption.getResponseText(option), (int) calculatedDistance, meters);

        return SUCCESS;
    }
}

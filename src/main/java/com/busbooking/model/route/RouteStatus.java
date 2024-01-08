package com.busbooking.model.route;

public class RouteStatus {
    private int statusCode;
    private String statusMessage;
    private Route route;

    public RouteStatus(int statusCode, String statusMessage, Route route) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.route = route;
    }

    public RouteStatus() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "RouteStatus{" +
                "statusCode=" + statusCode +
                ", statusMessage='" + statusMessage + '\'' +
                ", route=" + route +
                '}';
    }
}

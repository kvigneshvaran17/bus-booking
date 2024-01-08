package com.busbooking.model.busroutemapping;

public class BusRouteStatus {
    private int statusCode;
    private String statusMessage;
    private BusRoute busRoute;

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

    public BusRoute getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    public BusRouteStatus() {
    }

    public BusRouteStatus(int statusCode, String statusMessage, BusRoute busRoute) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.busRoute = busRoute;
    }

    @Override
    public String toString() {
        return "BusRouteStatus{" +
                "statusCode=" + statusCode +
                ", statusMessage='" + statusMessage + '\'' +
                ", busRoute=" + busRoute +
                '}';
    }
}

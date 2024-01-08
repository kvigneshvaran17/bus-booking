package com.busbooking.model.bus;

public class BusStatus {
    private int status;
    private String statusMessage;
    private Bus bus;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public BusStatus(int status, String statusMessage, Bus bus) {
        this.status = status;
        this.statusMessage = statusMessage;
        this.bus = bus;
    }

    public BusStatus() {
    }

    @Override
    public String toString() {
        return "BusStatus{" +
                "status=" + status +
                ", statusMessage='" + statusMessage + '\'' +
                ", bus=" + bus +
                '}';
    }
}

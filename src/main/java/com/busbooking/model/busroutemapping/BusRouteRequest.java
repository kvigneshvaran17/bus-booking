package com.busbooking.model.busroutemapping;

public class BusRouteRequest {
    private int id;
    private int bus_id;
    private int route_id;
    private String startTime;
    private String endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBus_id() {
        return bus_id;
    }

    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BusRouteRequest() {
    }

    public BusRouteRequest(int bus_id, int route_id, String startTime, String endTime) {
        this.bus_id = bus_id;
        this.route_id = route_id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BusRouteRequest{" +
                "bus_id=" + bus_id +
                ", route_id=" + route_id +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}

package com.busbooking.model.busroutemapping;

import com.busbooking.model.bus.Bus;
import com.busbooking.model.route.Route;
import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "bus_route_mappings")
public class BusRoute {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private String startTime;

    private String endTime;

    public BusRoute() {
    }

    public BusRoute(int id, Bus bus, Route route, String startTime, String endTime) {
        this.id = id;
        this.bus = bus;
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public BusRoute(Bus bus, Route route, String startTime, String endTime) {
        this.bus = bus;
        this.route = route;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
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

    @Override
    public String toString() {
        return "BusRoute{" +
                "id=" + id +
                ", bus=" + bus +
                ", route=" + route +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

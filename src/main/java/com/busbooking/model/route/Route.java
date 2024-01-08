package com.busbooking.model.route;

import com.busbooking.model.bus.BusType;
import com.busbooking.model.busroutemapping.BusRoute;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="routes")
public class Route {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("routeName")
    private String routeName;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<BusRoute> busRoutes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Route(String routeName) {
        this.routeName = routeName;
    }

    public Route() {
    }
}

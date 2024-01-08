package com.busbooking.model.bus;

import com.busbooking.model.busroutemapping.BusRoute;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="buses")
public class Bus {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("regNumber")
    private String regNumber;
    @JsonProperty("busType")
    private BusType busType;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<BusRoute> busRoutes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", regNumber='" + regNumber + '\'' +
                ", busType=" + busType +
                '}';
    }

    public Bus(int id, String regNumber, BusType busType) {
        this.id = id;
        this.regNumber = regNumber;
        this.busType = busType;
    }

    public Bus() {
    }
}

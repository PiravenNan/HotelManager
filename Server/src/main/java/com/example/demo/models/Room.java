package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private int doorNumber;
    private int capacity;
    private int dayRate;
    private Boolean isAvailable;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnoreProperties({"rooms"})
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "building_id")
    @JsonIgnore
    private Building building;

    public Room(int doorNumber, int capacity, int dayRate) {
        this.users = new ArrayList<>();
        this.doorNumber = doorNumber;
        this.capacity = capacity;
        this.dayRate = dayRate;
        this.isAvailable = true;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDayRate() {
        return dayRate;
    }

    public void setDayRate(int dayRate) {
        this.dayRate = dayRate;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}



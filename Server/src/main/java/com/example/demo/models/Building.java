package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfFloors;
    private int roomsPerFloor;

    @OneToMany(mappedBy = "building")
    @Column
    @JsonIgnoreProperties({"building"})
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonIgnore
    private Manager manager;

    public Building() {
    }

    public Building(int numberOfFloors, int roomsPerFloor, Manager manager) {
        this.numberOfFloors = numberOfFloors;
        this.roomsPerFloor = roomsPerFloor;
        this.rooms = new ArrayList<>();
        this.manager = manager;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getRoomsPerFloor() {
        return roomsPerFloor;
    }

    public void setRoomsPerFloor(int roomsPerFloor) {
        this.roomsPerFloor = roomsPerFloor;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Room addRoomToBuilding(Room room) {
        this.rooms.add(room);
        return room;
    }

    public Room removeRoomFromBuilding( Room room) {
        this.rooms.remove(room);
        return room;
    }

}

package com.example.demo.DTOs;

public class AddBuildingDTO {

    private int numberOfFloors;
    private int roomsPerFloor;
    private int capacity;
    private int dayRate;

    public AddBuildingDTO() {
    }

    public AddBuildingDTO(int numberOfFloors, int roomsPerFloor, int capacity, int dayRate) {
        this.numberOfFloors = numberOfFloors;
        this.roomsPerFloor = roomsPerFloor;
        this.capacity = capacity;
        this.dayRate = dayRate;
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
}

package com.example.demo.DTOs;

public class AddBuildingDTO {

    private int numberOfFloors;
    private int roomsPerFloor;
    private int capacityPerRoom;
    private int dayRate;

    public AddBuildingDTO() {
    }

    public AddBuildingDTO(int numberOfFloors, int roomsPerFloor, int capacityPerRoom, int dayRate) {
        this.numberOfFloors = numberOfFloors;
        this.roomsPerFloor = roomsPerFloor;
        this.capacityPerRoom = capacityPerRoom;
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

    public int getDayRate() {
        return dayRate;
    }

    public void setDayRate(int dayRate) {
        this.dayRate = dayRate;
    }

    public int getCapacityPerRoom() {
        return capacityPerRoom;
    }

    public void setCapacityPerRoom(int capacityPerRoom) {
        this.capacityPerRoom = capacityPerRoom;
    }
}

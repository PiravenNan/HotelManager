package com.example.demo.DTOs;

public class UpdateRoomDTO {
    private int capacity;
    private int dayRate;

    public UpdateRoomDTO(int capacity, int dayRate) {
        this.capacity = capacity;
        this.dayRate = dayRate;
    }

    public UpdateRoomDTO() {
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

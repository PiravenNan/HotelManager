package com.example.demo.services;

import com.example.demo.DTOs.UpdateRoomDTO;
import com.example.demo.models.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Room getRoomById(Long roomId) {
        Optional<Room> optionalRoom = roomRepository.findById(roomId);

        if(optionalRoom.isPresent()){
            return optionalRoom.get();
        }

        return null;
    }

    public Room updateRoom(Long roomId, UpdateRoomDTO updateRoomDTO) {

        Optional<Room> optionalRoom = roomRepository.findById(roomId);

        if(optionalRoom.isPresent()){
            Room room = optionalRoom.get();
            if(updateRoomDTO.getCapacity() != 0){
                room.setCapacity(updateRoomDTO.getCapacity());
            }
            if(updateRoomDTO.getDayRate() != 0){
                room.setDayRate(updateRoomDTO.getDayRate());
            }
        }

        return null;
    }

    public Room getRoomByDoorNumber(Long buildingId, int doorNumber) {
        return roomRepository.findAllByBuildingIdAndDoorNumber(buildingId,doorNumber);
    }
}

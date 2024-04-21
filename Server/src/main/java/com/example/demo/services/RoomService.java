package com.example.demo.services;

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
}

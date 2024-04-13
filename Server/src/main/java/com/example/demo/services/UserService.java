package com.example.demo.services;

import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;

    @Transactional
    public Room bookUserToRoom(Long userId, Long roomId) {

        if (userRepository.existsById(userId) && roomRepository.existsById(roomId)){

            User user = userRepository.findById(userId).get();
            Room room = roomRepository.findById(roomId).get();

            user.bookUserToRoom(room);
            userRepository.save(user);
        }

        return null;

    }
}

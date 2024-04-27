package com.example.demo.services;

import com.example.demo.DTOs.AddUserDTO;
import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoomRepository roomRepository;

    @Transactional
    public Room bookUserToRoom(Long userId, Long roomId) {

        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Room> optionalRoom = roomRepository.findById(roomId);
        //adds only one user per room for now, but should check by date in future
        if (optionalUser.isPresent() && optionalRoom.isPresent()  && optionalRoom.get().getAvailable()){

            User user = optionalUser.get();
            Room room = optionalRoom.get();

            user.bookUserToRoom(room);
            room.setAvailable(false);
            userRepository.save(user);
        }

        return null;

    }

    @Transactional
    public Room removeUserFromRoom(Long userId, Long roomId) {

        if (userRepository.existsById(userId) && roomRepository.existsById(roomId)){

            User user = userRepository.findById(userId).get();
            Room room = roomRepository.findById(roomId).get();

            user.removeUserFromRoom(room);
            room.setAvailable(true);
            userRepository.save(user);

            return room;
        }
        return null;
    }

    public User findUserById(Long userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findById(userId).get();
        }
        return null;
    }

    public User addNewUser(AddUserDTO addUserDTO) {
        try{
            if (!userRepository.existsByUsername(addUserDTO.getUsername())) {
                User user = new User(addUserDTO.getUsername(), addUserDTO.getPassword(), addUserDTO.getName());
                userRepository.save(user);
                return user;
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public User updateUser(Long userId, AddUserDTO addUserDTO) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if(!addUserDTO.getPassword().isEmpty()){
                user.setPassword(addUserDTO.getPassword());
            }

            if (!addUserDTO.getName().isEmpty()){
                user.setName(addUserDTO.getName());
            }

            userRepository.save(user);
            return user;
        }
        return null;
    }
}

package com.example.demo.controllers;

import com.example.demo.DTOs.AddUserDTO;
import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/booking/{userId}/{roomId}")
    public ResponseEntity<Room> bookUserToRoom(
            @PathVariable Long userId,
            @PathVariable Long roomId)
    {
        try{
            return new ResponseEntity<>(userService.bookUserToRoom(userId,roomId),HttpStatus.OK);
        }  catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/booking/{userId}/{roomId}")
    public ResponseEntity<Room> removeUserFromRoom(
            @PathVariable Long userId,
            @PathVariable Long roomId)
    {
        try{
            return new ResponseEntity<>(userService.removeUserFromRoom(userId,roomId),HttpStatus.OK);
        }  catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId){
        try{
            return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
        }  catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addNewUser(@RequestBody AddUserDTO addUserDTO){
        try{
            return new ResponseEntity<>(userService.addNewUser(addUserDTO),HttpStatus.OK);
        }  catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

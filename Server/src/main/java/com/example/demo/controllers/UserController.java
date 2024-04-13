package com.example.demo.controllers;

import com.example.demo.models.Room;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

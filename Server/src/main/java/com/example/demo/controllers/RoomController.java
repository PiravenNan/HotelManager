package com.example.demo.controllers;

import com.example.demo.DTOs.UpdateRoomDTO;
import com.example.demo.models.Room;
import com.example.demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping(value = "/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long roomId){
        try{
            return new ResponseEntity<>(roomService.getRoomById(roomId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/updateRoom/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId, @RequestBody UpdateRoomDTO updateRoomDTO){
        try{
            return new ResponseEntity<>(roomService.updateRoom(roomId,updateRoomDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

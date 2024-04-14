package com.example.demo.controllers;

import com.example.demo.DTOs.AddManagerDTO;
import com.example.demo.models.Manager;
import com.example.demo.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @PostMapping(value = "/addManager")
    public ResponseEntity<Manager> addNewManager(@RequestBody AddManagerDTO addManagerDTO){
        try{
            return new ResponseEntity<>(managerService.addNewManager(addManagerDTO), HttpStatus.CREATED);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

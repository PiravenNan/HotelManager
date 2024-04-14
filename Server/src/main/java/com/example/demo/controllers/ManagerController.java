package com.example.demo.controllers;

import com.example.demo.DTOs.AddBuildingDTO;
import com.example.demo.DTOs.AddManagerDTO;
import com.example.demo.models.Building;
import com.example.demo.models.Manager;
import com.example.demo.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "addNewBuilding/{managerId}")
    public ResponseEntity<Building> addNewBuilding(@PathVariable Long managerId, @RequestBody AddBuildingDTO addBuildingDTO){
        try {
            return new ResponseEntity<>(managerService.addNewBuilding(managerId, addBuildingDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}

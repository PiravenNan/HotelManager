package com.example.demo.controllers;

import com.example.demo.models.Building;
import com.example.demo.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @GetMapping(value = "/{buildingId}")
    public ResponseEntity<Building> getBuildingById(@PathVariable Long buildingId){
        try{
            return new ResponseEntity<>(buildingService.getBuildingById(buildingId),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

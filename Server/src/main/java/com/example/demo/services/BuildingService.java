package com.example.demo.services;

import com.example.demo.models.Building;
import com.example.demo.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    public Building getBuildingById(Long buildingId) {
        Optional<Building> optionalBuilding = buildingRepository.findById(buildingId);
        if (optionalBuilding.isPresent()){
            return optionalBuilding.get();
        }

        return null;
    }
}

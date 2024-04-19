package com.example.demo.services;


import com.example.demo.DTOs.AddBuildingDTO;
import com.example.demo.DTOs.AddManagerDTO;
import com.example.demo.models.Building;
import com.example.demo.models.Manager;
import com.example.demo.models.Room;
import com.example.demo.repositories.BuildingRepository;
import com.example.demo.repositories.ManagerRepository;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    RoomRepository roomRepository;

    public Manager addNewManager(AddManagerDTO addManagerDTO) {
        try {
            if (!managerRepository.existsByUsername(addManagerDTO.getUsername())) {
                Manager manager = new Manager(addManagerDTO.getUsername(), addManagerDTO.getPassword(), addManagerDTO.getName());
                managerRepository.save(manager);
                return manager;
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public Building addNewBuilding(Long mangerId, AddBuildingDTO addBuildingDTO) {

        Optional<Manager> optionalManager = managerRepository.findById(mangerId);

        if (optionalManager.isPresent()){
            Manager manager = optionalManager.get();

            Building building = new Building(addBuildingDTO.getNumberOfFloors(),addBuildingDTO.getRoomsPerFloor(),manager);
            buildingRepository.save(building);

            for (int i = 0; i<addBuildingDTO.getNumberOfFloors()*addBuildingDTO.getRoomsPerFloor();i++){
                Room room = new Room(i+1, addBuildingDTO.getCapacityPerRoom(),addBuildingDTO.getDayRate());
                room.setBuilding(building);
                building.addRoomToBuilding(room);
                roomRepository.save(room);
            }

            manager.addBuilding(building);
            managerRepository.save(manager);

            return building;
        }

        return null;
    }

    public Manager getManagerById(Long managerId) {
        Optional<Manager> optionalManager = managerRepository.findById(managerId);
        if(optionalManager.isPresent()){
            return optionalManager.get();
        }
        return null;
    }

    public List<Building> getAllBuildingsByManagerId(Long managerId) {
        List<Building> buildingList = buildingRepository.findAllByManagerId(managerId);

        if (!buildingList.isEmpty()){
            return buildingList;
        }

        return null;
    }
}

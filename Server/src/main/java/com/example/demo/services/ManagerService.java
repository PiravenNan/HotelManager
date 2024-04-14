package com.example.demo.services;


import com.example.demo.DTOs.AddManagerDTO;
import com.example.demo.models.Manager;
import com.example.demo.repositories.BuildingRepository;
import com.example.demo.repositories.ManagerRepository;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    RoomRepository roomRepository;

    public Manager addNewManager(AddManagerDTO addManagerDTO) {
        if (!managerRepository.existsByUsername(addManagerDTO.getUsername())){
            Manager manager = new Manager(addManagerDTO.getUsername(), addManagerDTO.getPassword(), addManagerDTO.getName());
            managerRepository.save(manager);
            return manager;
        }
        return null;
    }
}

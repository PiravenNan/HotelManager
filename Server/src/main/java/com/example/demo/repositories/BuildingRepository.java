package com.example.demo.repositories;

import com.example.demo.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {
    List<Building> findAllByManagerId(Long managerId);
}

package com.example.demo.repositories;

import com.example.demo.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
    boolean existsByUsername(String username);
}

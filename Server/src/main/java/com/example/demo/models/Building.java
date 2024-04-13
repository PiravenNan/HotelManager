package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfFloors;
    private int roomsPerFloor;

    @OneToMany(mappedBy = "building")
    @Column
    @JsonIgnoreProperties({ "building" })
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}

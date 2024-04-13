package com.example.demo.components;

import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) throws Exception {

        System.out.println("Data loader running");

        User user1 = new User("John", "Pass123");
        userRepository.save(user1);

        Room room1 = new Room(1, 10);
        roomRepository.save(room1);

        System.out.println("Data loader completed");


    }
}

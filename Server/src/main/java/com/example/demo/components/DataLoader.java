package com.example.demo.components;

import com.example.demo.models.Room;
import com.example.demo.models.User;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
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

    @Autowired
    UserService userService;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) throws Exception {


        User user1 = new User("John", "Pass123");
        userRepository.save(user1);

        User user2 = new User("Sally", "Pass123");
        userRepository.save(user2);

        Room room1 = new Room(1, 10);
        roomRepository.save(room1);

        userService.bookUserToRoom(user1.getId(), room1.getId());
        userService.bookUserToRoom(user2.getId(), room1.getId());
        userService.removeUserFromRoom(user2.getId(), room1.getId());
        userService.removeUserFromRoom(user1.getId(), room1.getId());
    }
}

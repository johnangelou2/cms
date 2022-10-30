package com.example.cms.controller;

import com.example.cms.controller.exceptions.StudentNotFoundException;
import com.example.cms.model.entity.Room;
import com.example.cms.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private final RoomRepository repository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }


    @DeleteMapping("/rooms/{id}")
    void deleteRoom(@PathVariable("id") Long roomNum) {
        repository.deleteById(roomNum);
    }

    @GetMapping("/rooms")
    List<Room> retrieveAllRooms() {
        return repository.findAll();
    }

    @PostMapping("/rooms")
    Room createRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    }

    @GetMapping("/students/{id}")
    Room retrieveRoom(@PathVariable("id") Long roomID) {
        return repository.findById(roomID)
                .orElseThrow(() -> new StudentNotFoundException(roomID));
    }
}
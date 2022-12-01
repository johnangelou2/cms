package com.example.cms.controller;

import com.example.cms.controller.dto.RoomDto;
import com.example.cms.controller.exceptions.ResidenceNotFoundException;
import com.example.cms.controller.exceptions.RoomNotFoundException;
import com.example.cms.model.entity.Room;
import com.example.cms.model.entity.RoomKey;
import com.example.cms.model.repository.ResidenceRepository;
import com.example.cms.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoomController {
    @Autowired
    private final RoomRepository repository;

    @Autowired
    private ResidenceRepository residenceRepository;

    public RoomController(RoomRepository repository) {
        this.repository = repository;
    }


    @DeleteMapping("/rooms/{roomN}/{residenceId}")
    void deleteRoom(@PathVariable("roomN") Integer roomN, @PathVariable("residenceId") Long residenceId) {
        repository.deleteById(new RoomKey(roomN, residenceId));
    }

    @GetMapping("/rooms")
    List<Room> retrieveAllRooms() {
        return repository.findAll();
    }

    /**
    @PostMapping("/rooms")
    Room createRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    } **/

    @PostMapping("/rooms")
    Room createRoom(@RequestBody RoomDto roomDto){
        Room newRoom = new Room();
        newRoom.setRoomKey(new RoomKey(roomDto.getRoomN(), roomDto.getResidenceId()));
        newRoom.setRoomType(roomDto.getRoomType());
        newRoom.setCapacity(roomDto.getRoomCap());
        newRoom.setResidenceId(residenceRepository.findById(roomDto.getResidenceId()).orElseThrow(() -> new ResidenceNotFoundException(roomDto.getResidenceId())));
        newRoom.setRoomN(roomDto.getRoomN());
        return repository.save(newRoom);
    }

    @GetMapping("/rooms/{roomN}/{residenceId}")
    Room retrieveRoom(@PathVariable("roomN") Integer roomN, @PathVariable("residenceId") Long residenceId) {
        return repository.findById(new RoomKey(roomN, residenceId))
                .orElseThrow(() -> new RoomNotFoundException(roomN));
    }

    /**
    @PutMapping("/rooms/{id}")
    Room updateRooms(@RequestBody Room newRoom, @PathVariable("id") Long roomN) {
        return repository.findById(roomN)
                .map(room -> {
                    room.setRoomType(newRoom.getRoomType());
                    return repository.save(room);
                })
                .orElseGet(() -> {
                    newRoom.setRoomN(roomN);
                    return repository.save(newRoom);
                });
    } **/

    @PutMapping("/rooms/{roomNumber}/{resId}")
    Room updateRooms(@RequestBody RoomDto roomDto, @PathVariable("roomNumber") Integer roomNumber, @PathVariable("resId") Long resId) {
        RoomKey roomKey = new RoomKey(roomNumber, resId);
        Room temp = repository.findById(roomKey).orElseThrow();
            return repository.findById(roomKey).map(room -> {
                if (roomDto.getRoomCap() == 0)
                    room.setCapacity(temp.getCapacity());
                else
                    room.setCapacity(roomDto.getRoomCap());
                if (roomDto.getRoomType() == null)
                    room.setRoomType(temp.getRoomType());
                else
                    room.setRoomType(roomDto.getRoomType());
                room.setRoomType(roomDto.getRoomType());
                return repository.save(room);
            }).orElseGet(() -> {
                return this.createRoom(roomDto);
            });
        }
    }

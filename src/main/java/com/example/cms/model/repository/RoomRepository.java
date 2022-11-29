package com.example.cms.model.repository;

import com.example.cms.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cms.model.entity.RoomKey;

public interface RoomRepository extends JpaRepository<Room, RoomKey> {
}

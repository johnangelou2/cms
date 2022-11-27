package com.example.cms.model.repository;

import com.example.cms.model.entity.Room;
import com.example.cms.model.entity.RoomKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, RoomKey> {
}

package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDto {
    Long residenceId;
    Long roomNum;
    String roomType;
    int roomCap;
}

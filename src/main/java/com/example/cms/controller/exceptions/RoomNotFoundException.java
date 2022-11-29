package com.example.cms.controller.exceptions;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(Integer id) {
        super("Could not find room " + id);
    }
}

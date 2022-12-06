package com.example.cms.controller.exceptions;

public class StudentNotFoundException extends RuntimeException{
    Long id;

    public StudentNotFoundException(Long id) {
        super("Could not find student " + id);
        this.id = id;
    }
    @Override
    public String toString() {
        return "Could not find student " + id;
    }
}

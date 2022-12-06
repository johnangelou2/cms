package com.example.cms.controller.exceptions;

public class ResidenceNotFoundException extends RuntimeException{
    Long id;
    public ResidenceNotFoundException(Long id) {
        super("Could not find residence " + id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Could not find residence " + id;
    }
}

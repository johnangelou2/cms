package com.example.cms.controller.exceptions;

public class ResidenceNotFoundException extends RuntimeException{
    public ResidenceNotFoundException(Long id) {
        super("Could not find residence " + id);
    }
}

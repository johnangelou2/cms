package com.example.cms.controller.exceptions;

public class AdminNotFoundException extends RuntimeException{
    Long id;
    public AdminNotFoundException(Long id) {
        super("Could not find admin " + id);
        this.id = id;
    }

    @Override
    public String toString(){
        return "Could not find admin " + id;
    }
}

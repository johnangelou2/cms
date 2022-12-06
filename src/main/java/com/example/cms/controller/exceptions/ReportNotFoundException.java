package com.example.cms.controller.exceptions;

public class ReportNotFoundException extends RuntimeException{
    Long id;
    public ReportNotFoundException(Long id) {
        super("Could not find report " + id);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Could not find report " + id;
    }

}

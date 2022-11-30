package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.cms.model.entity.Admin;

import java.sql.Time;

@Getter
@Setter
public class ReportDto {
    //date, time, desc, type, status, admin
    String date;
    long reportId;
    @DateTimeFormat
    Time time;
    String description;
    String type;
    String status;
    Admin author;

}

package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admins")
public class Admin {

    private String role;

    @DateTimeFormat
    private Date contractStart;

    @DateTimeFormat
    private Date contractEnd;

    //1 2 3 or 4 level
    private int privilegeLevel;
}

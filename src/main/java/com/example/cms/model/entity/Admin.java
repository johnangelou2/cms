package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admins")
public class Admin extends Person {

    private String role;

    @DateTimeFormat
    private Date contractStart;

    @DateTimeFormat
    private Date contractEnd;

    //1 2 3 or 4 level
    private int privilegeLevel;

    @OneToOne
    @JoinColumn(name = "name")
    private Residence residence;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Report> reports = new ArrayList<>();

}

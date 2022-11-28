package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "residenceIndences")
public class Residence {

    @Id
    private long residenceId;

    @NotEmpty
    private String address;

    @NotEmpty
    private String name;

    
    @OneToMany(mappedBy = "residenceId")
    private List<Room> rooms = new ArrayList<>();

    //@OneToMany(mappedBy = "reports")
    //@Nullable
    //private List<Report> resReports = new ArrayList<>();

    //@OneToMany(mappedBy = "Employee")
    //private List<Admin> employees = new ArrayList<>();
}

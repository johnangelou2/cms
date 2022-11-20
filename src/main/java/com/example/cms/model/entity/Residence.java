package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "residences")
public class Residence {

    @Id
    private long resId;

    @NotEmpty
    private String address;

    @NotEmpty
    private String name;

    //Honestly I dont think this attribute needs to exist but for now its here
    @OneToMany(mappedBy = "roomNum")
    @Nullable
    private List<Room> rooms = new ArrayList<>();

    @OneToMany (mappedBy = "reportId")
    @Nullable
    private List<Report> reports = new ArrayList<>();

    public Residence(long resId, String name, List<Room> rooms, List<Report> reports){
        this.resId = resId;
        this.name = name;
        this.rooms = rooms;
        this.reports = reports;
    }
}

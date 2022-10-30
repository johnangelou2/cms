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
    private Long id;

    @NotEmpty
    private String address;

    @NotEmpty
    private String name;

    //Honestly I dont think this attribute needs to exist but for now its here
    @OneToMany (mappedBy = "residence")
    @Nullable
    private List<Room> rooms = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id")
    @Nullable
    private List<Report> reports = new ArrayList<>();


}

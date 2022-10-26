package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "residences")
public class Residence {

    @Id
    private String address;

    @NotEmpty
    private String name;

    @OneToMany (mappedBy = "residenceName")
    @Nullable
    private List<Room> rooms = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id")
    @Nullable
    private List<Report> reports = new ArrayList<>();


}

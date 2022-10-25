package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

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

    //@OneToMany (mappedBy = "residence")
    //private ArrayList<Room> rooms;
}

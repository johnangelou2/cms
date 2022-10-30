package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rooms")
public class Room {

    @ManyToOne
    @JoinColumn(name = "id")
    private Residence residence;

    @Id
    private long roomNum;

    @NotEmpty
    private String roomType;

    private int capacity;

}

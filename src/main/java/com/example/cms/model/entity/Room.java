package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @EmbeddedId
    private RoomKey roomKey;

    @ManyToOne
    @MapsId("resId")
    @JoinColumn(name = "resId")
    @JsonIgnoreProperties({"residence"})
    private Residence residence;

    //@OneToOne(targetEntity = RoomKey.class)
    @MapsId("roomNumber")
    @JoinColumn(name = "roomNumber")
    private Long roomN;

    @NotEmpty
    private String roomType;

    private int capacity;

}

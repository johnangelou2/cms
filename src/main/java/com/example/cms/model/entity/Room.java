package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rooms")
public class Room {

    @EmbeddedId
    private RoomKey roomKey;

    @ManyToOne
    @MapsId("residenceId")
    @JoinColumn(name = "residenceId")
    @JsonIgnoreProperties({"rooms"})
    private Residence residenceId;

    //@ManyToOne
    @MapsId("roomN")
    @JoinColumn(name = "roomN")
    @JsonIgnoreProperties({"rooms"})
    private Long roomN;

    @NotEmpty
    private String roomType;

    private int capacity;

}

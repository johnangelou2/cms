package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

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
    @MapsId("resId")
    @JoinColumn(name = "resId")
    @JsonIgnoreProperties({"rooms"})
    private Residence residenceId;

    //@OneToOne(targetEntity = RoomKey.class)
    @Nullable
    @MapsId("roomNumber")
    @JoinColumn(name = "roomNumber")
    private Integer roomN;

    @NotEmpty
    private String roomType;

    private Integer capacity;
}

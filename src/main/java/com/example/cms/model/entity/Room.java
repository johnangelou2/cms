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
@Table(name = "rooms")
public class Room {

    @EmbeddedId
    private RoomKey roomKey;

    @ManyToOne
    @MapsId("resId")
    @JoinColumn(name = "resId")
    private Residence residence;

    //@OneToOne(targetEntity = RoomKey.class)
    @MapsId("roomNumber")
    @JoinColumn(name = "roomNumber")
    private Long roomN;

    @NotEmpty
    private String roomType;

    private int capacity;

}

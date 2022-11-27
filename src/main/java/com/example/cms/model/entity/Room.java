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

    @ManyToOne
    @JoinColumn(name = "resId")
    private Residence residence;

    @OneToMany(mappedBy = "location")
    @Nullable
    private List<Report> locations = new ArrayList<>();

    @Id
    private long roomNum;

    @NotEmpty
    private String roomType;

    private int capacity;

    @EmbeddedId
    RoomKey roomId;

}

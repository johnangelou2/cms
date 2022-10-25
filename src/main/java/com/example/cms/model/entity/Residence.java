package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
}

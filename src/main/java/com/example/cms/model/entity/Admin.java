package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admins")
public class Admin extends Person {

    private String role;

    @DateTimeFormat
    private Date contractStart;

    @DateTimeFormat
    private Date contractEnd;

    @ManyToOne
    @JoinColumn(name = "resId")
    private Residence residence;

    /**
    @OneToMany(mappedBy = "reportId")
    private List<Report> reports = new ArrayList<>(); **/
}

package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "admins")
public class Admin extends Person {

    private String role;

    private String contractStart;

    private String contractEnd;

    /**
    @OneToMany(mappedBy = "reportId")
    private List<Report> reports = new ArrayList<>(); **/
}

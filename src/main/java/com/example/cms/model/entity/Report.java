package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reports")
public class Report {
    @Id
    private long id;

    @DateTimeFormat
    private Date date;

    @DateTimeFormat
    private Time time;

    @Nullable
    private String description;

    @Nullable
    private String type;

    @NotEmpty
    private String status;

    @OneToMany
    @JoinColumn(name = "fullName")
    private Admin author;

}

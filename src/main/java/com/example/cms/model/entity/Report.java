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
    private long reportId;

    private String date;

    @DateTimeFormat
    private Time time;

    @Nullable
    private String description;

    @Nullable
    private String type;

    @NotEmpty
    private String status;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "resId", referencedColumnName = "resId"),
            @JoinColumn(name = "roomNumber", referencedColumnName = "roomNumber")
    })
    @Nullable
    private Room room;

}

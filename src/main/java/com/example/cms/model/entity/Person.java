package com.example.cms.model.entity;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Person {

    @NotNull
    @Column(unique = true)
    @Id
    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    //M = man W = woman, N = Non Binary / Choose not to say
    private char gender;

    @DateTimeFormat
    private Date dateOfBirth;

    private long phoneNum;
    
    @Nullable
    private String password; 

    @OneToOne
    @JoinColumn(name = "name")
    @Nullable
    private Residence residence;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "residence", referencedColumnName = "resId"),
            @JoinColumn(name = "roomN", referencedColumnName = "roomNumber")
    })
    @Nullable
    private Room room;

    @Email
    private String email;

    //Emergancy Contact Attributes


    @Nullable
    private Long emgPhoneNum;

    @Nullable
    private String emgFullName;

    @Nullable
    private String emgRelationship;

}

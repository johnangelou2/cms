package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Person {

    @Id
    private long id;

    @NotEmpty
    private String fullName;

    //M = man W = woman, N = Non Binary / Choose not to say
    private char gender;

    @DateTimeFormat
    private Date dateOfBirth;

    private long phoneNum;

    /**
    @Nullable
    private String password; **/


    @OneToOne
    @JoinColumn(name = "name")
    @Nullable
    private Residence residence;

    @ManyToOne
    @JoinColumn(name = "roomNum")
    @Nullable
    private Room room;

    @Email
    private String email;

    //Emergancy Contact Attributes


    @Nullable
    private long emgPhoneNum;

    private String emgFullName;

    private String emgRelationship;

}

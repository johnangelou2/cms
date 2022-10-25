package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    private char gender;

    @DateTimeFormat
    @NotEmpty
    private String dateOfBirth;

    @NotEmpty
    private long phoneNum;

    @Email
    @NotEmpty
    private String email;

    //Emergancy Contact Attributes
    @NotEmpty
    private long emgPhoneNum;

    @NotEmpty
    private String emgFullName;

    @Nullable
    private String emgRelationship;

}

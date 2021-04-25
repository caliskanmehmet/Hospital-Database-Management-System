package com.group25.ebnisina.managelaboratorians.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Laboratorian {
    @Id
    private int laboratorian_id;

    private String password;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String gender;

    private LocalDate birth_date;

    private String specialization;

    private int clinicId;

    public Laboratorian() {

    }
}


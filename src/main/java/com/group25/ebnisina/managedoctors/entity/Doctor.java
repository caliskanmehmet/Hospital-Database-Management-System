package com.group25.ebnisina.managedoctors.entity;

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
public class Doctor {
    @Id
    private int doctor_id;

    private String password;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String gender;

    private LocalDate birth_date;

    private String specialization;

    private int clinicId;

    private transient Integer rating;

    public Doctor() {

    }
}

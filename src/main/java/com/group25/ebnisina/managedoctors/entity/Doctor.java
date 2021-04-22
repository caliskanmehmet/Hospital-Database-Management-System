package com.group25.ebnisina.managedoctors.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.group25.ebnisina.manageclinics.entity.Clinic;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Doctor {
    @Id
    private int id;

    private String password;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String gender;

    private Date birth_date;

    private String specialization;

    @ManyToOne
    @JoinColumn(name="clinic_id")
    @JsonBackReference
    private Clinic clinic;

    public Doctor() {

    }
}

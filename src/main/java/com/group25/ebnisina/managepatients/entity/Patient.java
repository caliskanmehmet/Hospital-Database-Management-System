package com.group25.ebnisina.managepatients.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Patient {
    @Id
    private int id;

    private String password;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String gender;
    private String ssn;
    private String blood_type;

    private LocalDate birth_date;

    private int weight;
    private int height;
}

package com.group25.ebnisina.manageappointments.entity;

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
public class Appointment {
    @Id
    private int app_id;

    private transient int app_count;

    private String app_status;

    private LocalDate app_date;

    private int patient_id;

    private int doctor_id;

    private String first_name;

    private String middle_name;

    private String last_name;

    private String name; // clinic_name
}

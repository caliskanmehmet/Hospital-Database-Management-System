package com.group25.ebnisina.manageappointments.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
public class Appointment {
    @Id
    private int app_id;

    private String app_status;

    private Date app_date;

    private Time app_time;

    private int patient_id;

    private int doctor_id;
}

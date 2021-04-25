package com.group25.ebnisina.managedoctors.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AppointmentRequest {
    int clinic_id;
    LocalDate date;
}

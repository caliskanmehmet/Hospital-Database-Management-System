package com.group25.ebnisina.manageoffdays.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
public class OffDayId implements Serializable {
    private int doctor_id;

    private LocalDate off_date;

    public OffDayId() {

    }

    public OffDayId(int doctor_id, LocalDate off_date) {
        this.doctor_id = doctor_id;
        this.off_date = off_date;
    }
}

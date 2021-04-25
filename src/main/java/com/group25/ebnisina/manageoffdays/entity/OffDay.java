package com.group25.ebnisina.manageoffdays.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@IdClass(OffDayId.class)
public class OffDay {
    @Id
    private int doctor_id;

    @Id
    private LocalDate off_date;
}

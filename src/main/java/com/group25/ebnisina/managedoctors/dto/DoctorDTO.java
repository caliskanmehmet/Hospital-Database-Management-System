package com.group25.ebnisina.managedoctors.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DoctorDTO {

    private int doctor_id;

    private String first_name;

    private String middle_name;

    private String last_name;

    private BigDecimal rating;
}

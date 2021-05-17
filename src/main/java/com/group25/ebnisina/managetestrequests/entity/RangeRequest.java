package com.group25.ebnisina.managetestrequests.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RangeRequest {
    int patient_id;
    LocalDate startingDate;
    LocalDate endingDate;
}

package com.group25.ebnisina.managetestrequests.entity;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AllRequest {
    int patient_id;
    String testType;
    LocalDate startingDate;
    LocalDate endingDate;
}

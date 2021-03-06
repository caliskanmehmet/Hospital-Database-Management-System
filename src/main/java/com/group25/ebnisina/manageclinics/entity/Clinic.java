package com.group25.ebnisina.manageclinics.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Clinic {
    @Id
    private int clinic_id;

    private String name;
}


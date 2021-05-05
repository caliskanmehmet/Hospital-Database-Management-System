package com.group25.ebnisina.managediagnoses.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@Setter
@IdClass(DiagnoseId.class) // Composite key
public class Diagnose {
    @Id
    private int app_id;

    @Id
    private int disease_id;

    private String name;

}

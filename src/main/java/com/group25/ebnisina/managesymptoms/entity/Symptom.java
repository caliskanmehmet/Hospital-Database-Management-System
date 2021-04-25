package com.group25.ebnisina.managesymptoms.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Symptom {
    @Id
    private int symptom_id;

    private String name;
}

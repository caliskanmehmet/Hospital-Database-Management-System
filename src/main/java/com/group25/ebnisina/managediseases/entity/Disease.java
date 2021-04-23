package com.group25.ebnisina.managediseases.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Disease {
    @Id
    private int disease_id;

    private String name;
}

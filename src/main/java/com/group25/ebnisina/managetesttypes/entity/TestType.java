package com.group25.ebnisina.managetesttypes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class TestType {
    @Id
    private int type_id;

    private String name;
}

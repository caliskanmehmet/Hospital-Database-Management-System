package com.group25.ebnisina.manageevaluations.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@ToString
public class Evaluation {
    @Id
    private int app_id;

    private String comment;

    private int rating;

    transient Integer min;
    transient Integer max;
}

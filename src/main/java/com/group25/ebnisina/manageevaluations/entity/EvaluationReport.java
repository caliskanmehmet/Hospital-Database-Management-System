package com.group25.ebnisina.manageevaluations.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
public class EvaluationReport {
    @Id
    String first_name;
    String middle_name;
    String last_name;

    Integer min;
    Integer max;
    BigDecimal average;
}

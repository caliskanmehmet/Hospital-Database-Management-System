package com.group25.ebnisina.manageresults.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
public class ReportResult {
    @Id
    String parameter_name;

    BigDecimal min;
    BigDecimal max;
}

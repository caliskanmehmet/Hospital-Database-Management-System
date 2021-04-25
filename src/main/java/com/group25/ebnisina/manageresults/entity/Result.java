package com.group25.ebnisina.manageresults.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@IdClass(ResultId.class)
public class Result {
    @Id
    private int test_type_id;

    @Id
    private String parameter_name;

    @Id
    private int request_id;

    private BigDecimal score;

    private BigDecimal min_value;
    private BigDecimal max_value;

    private String unit;

    private LocalDateTime request_date_time;
}

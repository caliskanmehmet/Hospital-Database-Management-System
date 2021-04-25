package com.group25.ebnisina.managetestcomponents.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@IdClass(TestComponentId.class) // Composite key
public class TestComponent {
    @Id
    private String parameter_name;

    @Id
    private int test_type_id;

    private BigDecimal min_value;
    private BigDecimal max_value;

    private String unit;
}

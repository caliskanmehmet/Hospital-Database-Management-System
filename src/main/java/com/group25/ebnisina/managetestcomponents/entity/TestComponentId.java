package com.group25.ebnisina.managetestcomponents.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class TestComponentId implements Serializable {
    private String parameter_name;

    private int test_type_id;

    public TestComponentId() {

    }

    public TestComponentId(int test_type_id, String parameter_name) {
        this.test_type_id = test_type_id;
        this.parameter_name = parameter_name;
    }

}

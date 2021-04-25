package com.group25.ebnisina.manageresults.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class ResultId implements Serializable {
    private int test_type_id;

    private String parameter_name;

    private int request_id;

    public ResultId() {

    }

    public ResultId(int test_type_id, String parameter_name, int request_id) {
        this.test_type_id = test_type_id;
        this.parameter_name = parameter_name;
        this.request_id = request_id;
    }
}

package com.group25.ebnisina.manageelibiglefor.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class EligibleForId implements Serializable {
    private int test_type;

    private int laboratorian_id;

    public EligibleForId() {

    }

    public EligibleForId(int test_type, int laboratorian_id) {
        this.test_type = test_type;
        this.laboratorian_id = laboratorian_id;
    }
}

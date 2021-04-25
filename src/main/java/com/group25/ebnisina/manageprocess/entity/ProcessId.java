package com.group25.ebnisina.manageprocess.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class ProcessId implements Serializable {
    private int laboratorian_id;

    private int request_id;

    public ProcessId() {

    }

    public ProcessId(int laboratorian_id, int request_id) {
        this.laboratorian_id = laboratorian_id;
        this.request_id = request_id;
    }
}

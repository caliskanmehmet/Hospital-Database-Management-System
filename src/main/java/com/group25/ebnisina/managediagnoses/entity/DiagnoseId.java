package com.group25.ebnisina.managediagnoses.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class DiagnoseId implements Serializable {
    private int app_id;

    private int disease_id;

    public DiagnoseId() {

    }

    public DiagnoseId(int app_id, int disease_id) {
        this.app_id = app_id;
        this.disease_id = disease_id;
    }
}

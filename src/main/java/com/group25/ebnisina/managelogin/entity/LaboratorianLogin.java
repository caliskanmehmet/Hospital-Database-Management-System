package com.group25.ebnisina.managelogin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class LaboratorianLogin {
    @Id
    private int laboratorian_id;
}

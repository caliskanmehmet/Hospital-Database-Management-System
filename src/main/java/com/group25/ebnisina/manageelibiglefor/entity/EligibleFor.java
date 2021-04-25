package com.group25.ebnisina.manageelibiglefor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Getter
@Setter
@IdClass(EligibleForId.class) // Composite key
public class EligibleFor {
    @Id
    private int test_type;

    @Id
    private int laboratorian_id;
}

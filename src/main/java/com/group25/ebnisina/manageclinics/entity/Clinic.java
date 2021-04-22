package com.group25.ebnisina.manageclinics.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group25.ebnisina.managedoctors.entity.Doctor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Clinic {
    @Id
    private int clinic_id;

    private String name;

    @OneToMany
    @JsonManagedReference
    private List<Doctor> doctors;
}


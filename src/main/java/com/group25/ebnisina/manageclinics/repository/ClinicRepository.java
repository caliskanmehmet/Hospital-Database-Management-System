package com.group25.ebnisina.manageclinics.repository;

import com.group25.ebnisina.manageclinics.entity.Clinic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends org.springframework.data.repository.Repository<Clinic, Integer> {

    @Query(value = "SELECT * FROM clinic", nativeQuery = true)
    List<Clinic> getAllClinics();
}

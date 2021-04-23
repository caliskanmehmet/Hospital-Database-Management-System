package com.group25.ebnisina.managelaboratorians.repository;

import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratorianRepository extends org.springframework.data.repository.Repository<Laboratorian, Integer> {
    @Query(value = "SELECT * FROM laboratorian l", nativeQuery = true)
    List<Laboratorian> getAllLaboratorians();

    @Query(value = "SELECT * FROM laboratorian l WHERE l.id = ?1", nativeQuery = true)
    Laboratorian getLaboratorianById(int id);

    @Query(value = "SELECT * FROM laboratorian l Where l.clinic_id = ?1", nativeQuery = true)
    List<Laboratorian> getLaboratoriansByClinicId(int clinic_id);

}

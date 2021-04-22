package com.group25.ebnisina.managepatients.repository;

import com.group25.ebnisina.managepatients.entity.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
public interface PatientRepository extends org.springframework.data.repository.Repository<Patient, Integer> {

    @Query(value = "INSERT INTO Patient (password, first_name, middle_name, last_name, gender, birth_date, ssn," +
            "weight, height, blood_type) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10)", nativeQuery = true)
    @Transactional
    @Modifying
    public void addPatient(String password, String first_name, String middle_name, String last_name,
                           String gender, Date birth_date, String ssn, int weight, int height, String blood_type);

    @Query(value = "SELECT * FROM Patient", nativeQuery = true)
    public List<Patient> getPatients();
}

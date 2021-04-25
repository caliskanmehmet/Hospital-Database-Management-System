package com.group25.ebnisina.managepatients.repository;

import com.group25.ebnisina.managepatients.entity.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends org.springframework.data.repository.Repository<Patient, Integer> {

    @Query(value = "INSERT INTO Person (password, first_name, middle_name, last_name, gender, birth_date) VALUES " +
            "(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    @Transactional
    @Modifying
    void addPerson(String password, String first_name, String middle_name, String last_name,
                    String gender, LocalDate birth_date);

    @Query(value = "INSERT INTO Patient (ssn, person_id, weight, height, blood_type)" +
            " VALUES (?1, (SELECT LAST_INSERT_ID()), ?2, ?3, ?4)", nativeQuery = true)
    @Transactional
    @Modifying
    void addPatient(String ssn, int weight, int height, String blood_type);

    @Query(value = "SELECT * FROM Patient PA INNER JOIN Person PE ON PE.id = PA.person_id", nativeQuery = true)
    List<Patient> getPatients();
}

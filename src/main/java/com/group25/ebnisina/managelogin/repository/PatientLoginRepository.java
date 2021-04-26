package com.group25.ebnisina.managelogin.repository;

import com.group25.ebnisina.managelogin.entity.PatientLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientLoginRepository extends org.springframework.data.repository.Repository<PatientLogin, String> {

    @Query(value = "SELECT * " +
            "FROM Patient PA, Person PE " +
            "WHERE PA.person_id = PE.id AND PA.ssn = ?1 AND PE.password = ?2", nativeQuery = true)
    PatientLogin checkCredentials(String ssn, String password);
}

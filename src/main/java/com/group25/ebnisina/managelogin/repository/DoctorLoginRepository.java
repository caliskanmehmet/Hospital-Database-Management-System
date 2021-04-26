package com.group25.ebnisina.managelogin.repository;

import com.group25.ebnisina.managelogin.entity.DoctorLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorLoginRepository extends org.springframework.data.repository.Repository<DoctorLogin, Integer> {

    @Query(value = "SELECT * " +
            "FROM Doctor D, Person P " +
            "WHERE D.person_id = P.id AND D.doctor_id = ?1 AND P.password = ?2", nativeQuery = true)
    DoctorLogin checkCredentials(int doctor_id, String password);
}

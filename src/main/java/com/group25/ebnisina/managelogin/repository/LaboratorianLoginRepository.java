package com.group25.ebnisina.managelogin.repository;

import com.group25.ebnisina.managelogin.entity.LaboratorianLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratorianLoginRepository extends org.springframework.data.repository.Repository<LaboratorianLogin, Integer> {

    @Query(value = "SELECT * " +
            "FROM Laboratorian D, Person P " +
            "WHERE D.person_id = P.id AND D.laboratorian_id = CONVERT(?1 using utf8mb4) AND P.password = ?2 " +
            "COLLATE utf8mb4_bin", nativeQuery = true)
    LaboratorianLogin checkCredentials(int laboratorian_id, String password);
}

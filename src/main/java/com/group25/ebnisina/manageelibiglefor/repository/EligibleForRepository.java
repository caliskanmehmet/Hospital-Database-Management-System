package com.group25.ebnisina.manageelibiglefor.repository;

import com.group25.ebnisina.manageelibiglefor.entity.EligibleFor;
import com.group25.ebnisina.manageelibiglefor.entity.EligibleForId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EligibleForRepository extends org.springframework.data.repository.Repository<EligibleFor, EligibleForId> {

    @Query(value = "SELECT * FROM Eligible_for", nativeQuery = true)
    List<EligibleFor> getAll();

    @Query(value = "SELECT * FROM Eligible_for E WHERE E.laboratorian_id = ?1", nativeQuery = true)
    List<EligibleFor> getEligibleTestsOfLaboratorian(int laboratorian_id);
}

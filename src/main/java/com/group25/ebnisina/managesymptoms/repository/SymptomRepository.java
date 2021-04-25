package com.group25.ebnisina.managesymptoms.repository;

import com.group25.ebnisina.managesymptoms.entity.Symptom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomRepository extends org.springframework.data.repository.Repository<Symptom, Integer> {

    @Query(value = "SELECT * FROM Symptom", nativeQuery = true)
    List<Symptom> getSymptoms();
}

package com.group25.ebnisina.managediseases.repository;

import com.group25.ebnisina.managediseases.entity.Disease;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DiseaseRepository extends Repository<Disease, Integer> {

    @Query(value = "SELECT * FROM Disease D", nativeQuery = true)
    List<Disease> getAllDiseases();

    @Query(value = "SELECT * FROM Disease D WHERE D.disease_id = ?1", nativeQuery = true)
    Disease getDiseaseById(int disease_id);
}

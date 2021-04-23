package com.group25.ebnisina.managediagnoses.repository;

import com.group25.ebnisina.managediagnoses.entity.Diagnose;
import com.group25.ebnisina.managediagnoses.entity.DiagnoseId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DiagnoseRepository extends org.springframework.data.repository.Repository<Diagnose, DiagnoseId> {

    @Query(value = "SELECT * FROM diagnose d", nativeQuery = true)
    List<Diagnose> getAllDiagnoses();

    @Query(value = "SELECT * FROM diagnose d WHERE d.app_id = ?1", nativeQuery = true)
    List<Diagnose> getDiagnosesOfAppointment(int app_id);

    @Query(value = "INSERT INTO Diagnose (explanation, app_id, disease_id) VALUES" +
            "(?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addDiagnose(String explanation, int app_id, int disease_id);
}

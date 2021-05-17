package com.group25.ebnisina.manageevaluations.repository;

import com.group25.ebnisina.manageevaluations.entity.EvaluationReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationReportRepository extends org.springframework.data.repository.Repository<EvaluationReport, String> {

    @Query(value = "SELECT P.first_name, P.middle_name, P.last_name, MIN(E.rating) as min, MAX(E.rating) as max, AVG(E.rating) as average " +
            "FROM Evaluation E, Appointment A, Doctor D, Person P " +
            "WHERE E.app_id = A.app_id AND A.doctor_id = D.doctor_id AND D.person_id = P.id " +
            "GROUP BY A.doctor_id", nativeQuery = true)
    List<EvaluationReport> getReports();
}

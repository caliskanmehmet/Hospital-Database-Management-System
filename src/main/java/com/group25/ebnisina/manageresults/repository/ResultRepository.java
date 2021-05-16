package com.group25.ebnisina.manageresults.repository;

import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.entity.ResultId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ResultRepository extends org.springframework.data.repository.Repository<Result, ResultId> {

    @Query(value = "SELECT * " +
            "FROM Result_of R, Test_component TC, Test_request TR " +
            "WHERE R.request_id = ?1 AND R.test_type_id = TC.test_type_id " +
            "AND R.parameter_name = TC.parameter_name AND TR.request_id = ?1", nativeQuery = true)
    List<Result> getResultsOfTest(int test_request_id);

    @Query(value = "SELECT * " +
            "FROM Test_Request TR, Result_of R, Test_component TC, Appointment A  WHERE" +
            "?2 = TC.parameter_name AND ?1 = TC.test_type_id AND TC.parameter_name = R.parameter_name AND " +
            "TC.test_type_id = R.test_type_id AND R.request_id = TR.request_id AND TR.app_id = A.app_id AND " +
            "A.patient_id = ?3 " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<Result> getPastResultsOfParameter(int test_type_id, String parameter_name, int patient_id);

    @Query(value = "REPLACE INTO Result_of (score, test_type_id, parameter_name, request_id) VALUES" +
            " (?1, ?2, ?3, ?4) ", nativeQuery = true)
    @Modifying
    @Transactional
    void addResultToTestRequest(BigDecimal score, int test_type_id, String parameter_name, int request_id);

    @Query(value = "SELECT COUNT(*) " +
            "FROM Result_of " +
            "WHERE request_id = ?1", nativeQuery = true)
    int getResultCountOfTestRequest(int request_id);
}

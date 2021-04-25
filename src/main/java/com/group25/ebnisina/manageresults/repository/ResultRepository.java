package com.group25.ebnisina.manageresults.repository;

import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.entity.ResultId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
            "A.patient_id = ?3", nativeQuery = true)
    List<Result> getPastResultsOfParameter(int test_type_id, String parameter_name, int patient_id);
}

package com.group25.ebnisina.manageresults.repository;

import com.group25.ebnisina.manageresults.entity.ReportResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends org.springframework.data.repository.Repository<ReportResult, String>{
    @Query(value = "SELECT R.parameter_name, MIN(R.score) as min, MAX(R.score) as max " +
            "FROM Result_of R, Test_request TR, Process P " +
            "WHERE P.laboratorian_id = ?1 AND P.request_id = TR.request_id AND TR.request_id = R.request_id " +
            "GROUP BY R.parameter_name", nativeQuery = true)
    List<ReportResult> getMinAndMaxResultsOfParameters(int laboratorian_id);
}

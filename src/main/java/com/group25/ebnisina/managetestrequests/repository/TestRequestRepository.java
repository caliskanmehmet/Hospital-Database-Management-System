package com.group25.ebnisina.managetestrequests.repository;

import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TestRequestRepository extends org.springframework.data.repository.Repository<TestRequest, Integer> {

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = A.app_id AND A.patient_id = ?1 AND TR.test_type_id = TT.type_id " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfPatient(int patient_id);

    @Query(value = "INSERT INTO Test_request (status, request_date_time, app_id, test_type_id) VALUES" +
            "('Pending', ?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addTestRequest(LocalDateTime request_date_time, int app_id, int test_type_id);
}

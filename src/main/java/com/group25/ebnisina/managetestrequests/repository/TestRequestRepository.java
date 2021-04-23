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

    @Query(value = "SELECT * FROM Test_request", nativeQuery = true)
    List<TestRequest> getAllTestRequests();

    @Query(value = "SELECT * FROM Test_request T WHERE T.app_id = ?1", nativeQuery = true)
    List<TestRequest> getTestRequestsOfAppointment(int app_id);

    @Query(value = "INSERT INTO Test_request (status, request_date_time, app_id, test_type_id) VALUES" +
            "('Pending', ?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addTestRequest(LocalDateTime request_date_time, int app_id, int test_type_id);
}

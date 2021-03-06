package com.group25.ebnisina.managetestrequests.repository;

import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TestRequestRepository extends org.springframework.data.repository.Repository<TestRequest, Integer> {

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = A.app_id AND A.patient_id = ?1 AND TR.test_type_id = TT.type_id " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfPatient(int patient_id);

    @Query(value = "SELECT COUNT(*) " +
            "FROM Test_request TR, Process P " +
            "WHERE TR.test_type_id = ?1 AND TR.request_id = P.request_id AND P.laboratorian_id = ?2", nativeQuery = true)
    Integer getTestCountOfLaboratorian(int test_type_id, int laboratorian_id);

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = A.app_id AND A.patient_id = ?1 AND TR.test_type_id = TT.type_id AND " +
            "TT.name LIKE %?2% " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfPatientWithTestType(int patient_id, String testType);

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = A.app_id AND A.patient_id = ?1 AND TR.test_type_id = TT.type_id AND " +
            "TR.request_date_time between ?2 AND ?3 " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfPatientWithRange(int patient_id, LocalDate startingDate, LocalDate endingDate);

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = A.app_id AND A.patient_id = ?1 AND TR.test_type_id = TT.type_id AND " +
            "TT.name LIKE %?4% AND TR.request_date_time between ?2 AND ?3 " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfPatientWithAll(int patient_id, LocalDate startingDate, LocalDate endingDate, String testType);

    @Query(value = "SELECT DISTINCT TR.*, TT.name " +
            "FROM Test_request TR, Appointment A, Test_type TT " +
            "WHERE TR.app_id = ?1 AND TR.test_type_id = TT.type_id " +
            "ORDER BY TR.request_date_time DESC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfAppointment(int app_id);

    @Query(value = "SELECT TR.*, TT.name " +
            "FROM Test_request TR, Test_type TT, Process P " +
            "WHERE TR.request_id = P.request_id AND TR.test_type_id = TT.type_id AND P.laboratorian_id = ?1 " +
            "ORDER BY FIELD(P.status, 'Assigned', 'Preparing', 'Finalized'), TR.request_date_time ASC", nativeQuery = true)
    List<TestRequest> getTestRequestsOfLaboratorian(int laboratorian_id);

    @Query(value = "INSERT INTO Test_request (status, request_date_time, app_id, test_type_id) VALUES" +
            "('Assigned', ?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addTestRequest(LocalDateTime request_date_time, int app_id, int test_type_id);

    @Query(value = "SELECT * " +
            "FROM Test_request TR, Test_type TT " +
            "WHERE TR.app_id = ?1 AND TR.test_type_id = ?2 AND TR.test_type_id = TT.type_id", nativeQuery = true)
    TestRequest getTestRequestWithAppId(int app_id, int test_type_id);

    @Query(value = "SELECT * " +
            "FROM Test_request TR, Test_type TT " +
            "WHERE TR.request_id = ?1 AND TR.test_type_id = TT.type_id", nativeQuery = true)
    TestRequest getTestRequestWithRequestId(int request_id);

    @Query(value = "SELECT * " +
            "FROM Test_request TR, Test_type TT " +
            "WHERE TR.request_id = (SELECT LAST_INSERT_ID()) AND TR.test_type_id = TT.type_id", nativeQuery = true)
    TestRequest getLastTestRequest();

    @Query(value = "UPDATE Test_request " +
            "SET status = 'Preparing' " +
            "WHERE request_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateTestStatusToPreparing(int request_id);

    @Query(value = "UPDATE Test_request " +
            "SET status = 'Finalized' " +
            "WHERE request_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateTestStatusToFinalized(int request_id);
}

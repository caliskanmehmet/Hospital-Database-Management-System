package com.group25.ebnisina.managetestrequests.service;

import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.repository.LaboratorianRepository;
import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TestRequestService {

    private final TestRequestRepository testRequestRepository;
    private final ProcessRepository processRepository;
    private final LaboratorianRepository laboratorianRepository;
    private final AppointmentRepository appointmentRepository;

    public List<TestRequest> getTestRequestsOfPatient(int patient_id) {
        return testRequestRepository.getTestRequestsOfPatient(patient_id);
    }

    public List<TestRequest> getTestRequestsOfPatientWithRange(int patient_id, LocalDate startingDate, LocalDate endingDate) {
        return testRequestRepository.getTestRequestsOfPatientWithRange(patient_id, startingDate, endingDate);
    }

    public List<TestRequest> getTestRequestsOfPatientWithAll(int patient_id, LocalDate startingDate, LocalDate endingDate, String testType) {
        return testRequestRepository.getTestRequestsOfPatientWithAll(patient_id, startingDate, endingDate, testType);
    }

    public List<TestRequest> getTestRequestsOfPatientWithTestType(int patient_id, String testType) {
        return testRequestRepository.getTestRequestsOfPatientWithTestType(patient_id, testType);
    }

    public List<TestRequest> getTestRequestsOfAppointment(int app_id) {
        return testRequestRepository.getTestRequestsOfAppointment(app_id);
    }

    public TestRequest getTestRequestWithRequestId(int request_id) {
        return testRequestRepository.getTestRequestWithRequestId(request_id);
    }

    public List<TestRequest> getTestRequestsOfLaboratorian(int laboratorian_id) {
        return testRequestRepository.getTestRequestsOfLaboratorian(laboratorian_id);
    }

    public void updateTestStatusToFinalized(int request_id) {
        testRequestRepository.updateTestStatusToFinalized(request_id);

        // Update appointment status to "Tests Finished" if all requested tests are finished
        TestRequest changedTestRequest = testRequestRepository.getTestRequestWithRequestId(request_id);

        // Fetch all tests of the appointment
        List<TestRequest> testsOfAppointment = testRequestRepository.getTestRequestsOfAppointment(changedTestRequest.getApp_id());

        // Traverse and if all tests are finished, update app status to "Tests Finished"
        for (TestRequest testRequest : testsOfAppointment) {
            if (testRequest.getStatus().equals("Preparing") || testRequest.getStatus().equals("Assigned")) {
                return;
            }
        }

        appointmentRepository.updateAppointmentToTestFinished(changedTestRequest.getApp_id());
    }

    @Transactional
    public void addTestRequest(int app_id, List<Integer> testTypes) {
        testTypes.forEach(test_type_id -> {
            // Add test request
            testRequestRepository.addTestRequest(LocalDateTime.now(),
                    app_id, test_type_id);

            // Choose random laboratorian
            List<Laboratorian> eligibleLaboratorians = laboratorianRepository.getLaboratoriansForTest(test_type_id);
            Random rand = new Random();
            Laboratorian laboratorian = eligibleLaboratorians.get(rand.nextInt(eligibleLaboratorians.size()));

            // Assign the test request to the laboratorian
            TestRequest testRequest1 = testRequestRepository.getLastTestRequest();
            processRepository.addProcess(LocalDate.now(), laboratorian.getLaboratorian_id(), testRequest1.getRequest_id());
        });
        appointmentRepository.updateAppointmentToTestRequested(app_id);
    }
}

package com.group25.ebnisina.managetestrequests.service;

import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.repository.LaboratorianRepository;
import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public List<TestRequest> getTestRequestsOfPatient(int patient_id) {
        return testRequestRepository.getTestRequestsOfPatient(patient_id);
    }

    public List<TestRequest> getTestRequestsOfAppointment(int app_id) {
        return testRequestRepository.getTestRequestsOfAppointment(app_id);
    }

    public TestRequest getTestRequestWithRequestId(int request_id) {
        return testRequestRepository.getTestRequestWithRequestId(request_id);
    }

    public void addTestRequest(TestRequest testRequest) {
        List<Laboratorian> eligibleLaboratorians = laboratorianRepository.getLaboratoriansForTest(testRequest.getTest_type_id());
        testRequestRepository.addTestRequest(LocalDateTime.now(),
                testRequest.getApp_id(), testRequest.getTest_type_id());

        // Choose random laboratorian
        TestRequest testRequest1 = testRequestRepository.getTestRequestWithAppId( testRequest.getApp_id(), testRequest.getTest_type_id());
        Random rand = new Random();
        Laboratorian laboratorian = eligibleLaboratorians.get(rand.nextInt(eligibleLaboratorians.size()));
        processRepository.addProcess(LocalDate.now(), laboratorian.getLaboratorian_id(), testRequest1.getRequest_id());
    }
}

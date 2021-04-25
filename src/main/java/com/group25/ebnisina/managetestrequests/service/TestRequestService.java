package com.group25.ebnisina.managetestrequests.service;

import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestRequestService {

    private final TestRequestRepository testRequestRepository;

    public List<TestRequest> getTestRequestsOfPatient(int patient_id) {
        return testRequestRepository.getTestRequestsOfPatient(patient_id);
    }

    public void addTestRequest(TestRequest testRequest) {
        testRequestRepository.addTestRequest(LocalDateTime.now(),
                testRequest.getApp_id(), testRequest.getTest_type_id());
    }
}

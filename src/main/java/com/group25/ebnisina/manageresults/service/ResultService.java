package com.group25.ebnisina.manageresults.service;

import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.repository.ResultRepository;
import com.group25.ebnisina.managetestcomponents.service.TestComponentService;
import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final ProcessRepository processRepository;
    private final TestRequestRepository testRequestRepository;
    private final TestComponentService testComponentService;

    public List<Result> getResultsOfTest(int test_request_id) {
        return resultRepository.getResultsOfTest(test_request_id);
    }

    public List<Result> getPastResultsOfParameter(int test_type_id, String parameter_name, int patient_id) {
        return resultRepository.getPastResultsOfParameter(test_type_id, parameter_name, patient_id);
    }

    public void addResultToTestRequest(Result result) {
        int testRequestId = result.getRequest_id();

        TestRequest testRequest = testRequestRepository.getTestRequestWithRequestId(testRequestId);
        int countOfParameters = testComponentService.getComponentCountOfTestType(result.getTest_type_id());

        resultRepository.addResultToTestRequest(result.getScore(), result.getTest_type_id(), result.getParameter_name(),
                testRequestId);

        int countOfResults = resultRepository.getResultCountOfTestRequest(testRequestId);

        if (countOfResults == 1) {
            // Set test status and process's status to preparing
            processRepository.updateTestStatusToPreparing(testRequestId);
            testRequestRepository.updateTestStatusToPreparing(testRequestId);
        }
        else if (countOfResults >= countOfParameters) {
            // Set test status to finalized
            processRepository.updateTestStatusToFinalized(testRequestId);
            testRequestRepository.updateTestStatusToFinalized(testRequestId);
        }
    }
}

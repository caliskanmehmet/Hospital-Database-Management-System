package com.group25.ebnisina.manageresults.service;

import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.repository.ResultRepository;
import com.group25.ebnisina.managetestcomponents.service.TestComponentService;
import com.group25.ebnisina.managetestrequests.repository.TestRequestRepository;
import com.group25.ebnisina.managetestrequests.service.TestRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;
    private final ProcessRepository processRepository;
    private final TestRequestService testRequestService;
    private final TestRequestRepository testRequestRepository;
    private final TestComponentService testComponentService;

    public List<Result> getResultsOfTest(int test_request_id) {
        return resultRepository.getResultsOfTest(test_request_id);
    }

    public List<Result> getPastResultsOfParameter(int test_type_id, String parameter_name, int patient_id) {
        return resultRepository.getPastResultsOfParameter(test_type_id, parameter_name, patient_id);
    }

    public void addResultToTestRequest(List<Result> result) {
        int testRequestId = result.get(0).getRequest_id();

        int countOfParameters = testComponentService.getComponentCountOfTestType(result.get(0).getTest_type_id());

        result.forEach(row -> {
            resultRepository.addResultToTestRequest(row.getScore(), row.getTest_type_id(), row.getParameter_name(),
                    testRequestId);
        });

        int countOfResults = resultRepository.getResultCountOfTestRequest(testRequestId);

        if (countOfResults >= countOfParameters) {
            // Set test status to finalized
            processRepository.updateTestStatusToFinalized(testRequestId);
            testRequestService.updateTestStatusToFinalized(testRequestId);
        }
        else if (countOfResults == result.size()) {
            // countOfResults were 0 before the insertion
            // Set test status and process's status to preparing
            processRepository.updateTestStatusToPreparing(testRequestId);
            testRequestRepository.updateTestStatusToPreparing(testRequestId);
        }

    }
}

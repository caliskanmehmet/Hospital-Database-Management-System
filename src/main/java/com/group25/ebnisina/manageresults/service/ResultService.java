package com.group25.ebnisina.manageresults.service;

import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public List<Result> getResultsOfTest(int test_request_id) {
        return resultRepository.getResultsOfTest(test_request_id);
    }

    public List<Result> getPastResultsOfParameter(int test_type_id, String parameter_name, int patient_id) {
        return resultRepository.getPastResultsOfParameter(test_type_id, parameter_name, patient_id);
    }
}

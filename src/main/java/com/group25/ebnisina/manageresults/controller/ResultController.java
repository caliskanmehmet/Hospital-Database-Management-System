package com.group25.ebnisina.manageresults.controller;

import com.group25.ebnisina.manageresults.entity.Result;
import com.group25.ebnisina.manageresults.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/result")
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    private final ResultService resultService;

    @GetMapping("/getByTest/{test_request_id}")
    public List<Result> getResultsOfTest(@PathVariable("test_request_id") int test_request_id) {
        return resultService.getResultsOfTest(test_request_id);
    }

    @GetMapping("/getByParameter")
    public List<Result> getPastResultsOfParameter(@RequestParam int test_type_id, @RequestParam String parameter_name,
                                                  @RequestParam int patient_id) {
        return resultService.getPastResultsOfParameter(test_type_id, parameter_name, patient_id);
    }

    @PostMapping("/add")
    public void addResultToTestRequest(@RequestBody Result result) {
        resultService.addResultToTestRequest(result);
    }
}

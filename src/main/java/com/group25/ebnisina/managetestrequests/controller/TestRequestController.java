package com.group25.ebnisina.managetestrequests.controller;

import com.group25.ebnisina.managetestrequests.entity.TestRequest;
import com.group25.ebnisina.managetestrequests.service.TestRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testRequest")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TestRequestController {

    private final TestRequestService testRequestService;

    @GetMapping("/getAll")
    public List<TestRequest> getAllTestRequests() {
        return testRequestService.getAllTestRequests();
    }

    @GetMapping("/get/{app_id}")
    public List<TestRequest> getTestRequestsOfAppointment(@PathVariable("app_id") int app_id) {
        return testRequestService.getTestRequestsOfAppointment(app_id);
    }

    @PostMapping("/add")
    public void addTestRequest(@RequestBody TestRequest testRequest) {
        testRequestService.addTestRequest(testRequest);
    }
}

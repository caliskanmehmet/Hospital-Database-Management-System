package com.group25.ebnisina.managetesttypes.controller;

import com.group25.ebnisina.managetesttypes.entity.TestType;
import com.group25.ebnisina.managetesttypes.service.TestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/testType")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TestTypeController {

    private final TestTypeService testTypeService;

    @GetMapping("/getAll")
    public List<TestType> getTestTypes() {
        return testTypeService.getTestTypes();
    }
}

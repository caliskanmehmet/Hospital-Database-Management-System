package com.group25.ebnisina.managetestcomponents.controller;

import com.group25.ebnisina.managetestcomponents.entity.TestComponent;
import com.group25.ebnisina.managetestcomponents.service.TestComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/testComponent")
@CrossOrigin(origins = "http://localhost:3000")
public class TestComponentController {

    private final TestComponentService testComponentService;

    @GetMapping("/getAll")
    public List<TestComponent> getAllTestComponents() {
        return testComponentService.getAllTestComponents();
    }

    @GetMapping("/get/{test_type_id}")
    public List<TestComponent> getTestComponentsOfTestType(@PathVariable("test_type_id") int test_type_id) {
        return testComponentService.getTestComponentsOfTestType(test_type_id);
    }
}

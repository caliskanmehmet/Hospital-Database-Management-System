package com.group25.ebnisina.managetestcomponents.service;

import com.group25.ebnisina.managetestcomponents.entity.TestComponent;
import com.group25.ebnisina.managetestcomponents.repository.TestComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestComponentService {

    private final TestComponentRepository testComponentRepository;

    public List<TestComponent> getAllTestComponents() {
        return testComponentRepository.getAllTestComponents();
    }

    public List<TestComponent> getTestComponentsOfTestType(int test_type_id) {
        return testComponentRepository.getTestComponentsOfTestType(test_type_id);
    }
}

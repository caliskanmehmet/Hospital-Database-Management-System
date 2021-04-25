package com.group25.ebnisina.managetesttypes.service;

import com.group25.ebnisina.managetesttypes.entity.TestType;
import com.group25.ebnisina.managetesttypes.repository.TestTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestTypeService {

    private final TestTypeRepository testTypeRepository;

    public List<TestType> getTestTypes() {
        return testTypeRepository.getTestTypes();
    }
}

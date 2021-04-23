package com.group25.ebnisina.managediseases.service;

import com.group25.ebnisina.managediseases.entity.Disease;
import com.group25.ebnisina.managediseases.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;

    public List<Disease> getAllDiseases() {
        return diseaseRepository.getAllDiseases();
    }

    public Disease getDiseaseById(int disease_id) {
        return diseaseRepository.getDiseaseById(disease_id);
    }
}

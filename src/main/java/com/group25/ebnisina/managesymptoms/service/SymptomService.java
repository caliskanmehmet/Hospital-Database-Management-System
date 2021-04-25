package com.group25.ebnisina.managesymptoms.service;

import com.group25.ebnisina.managesymptoms.entity.Symptom;
import com.group25.ebnisina.managesymptoms.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomService {

    private final SymptomRepository symptomRepository;

    public List<Symptom> getSymptoms() {
        return symptomRepository.getSymptoms();
    }

    public List<Symptom> getSymptomsOfAppointment(int app_id) {
        return symptomRepository.getSymptomsOfAppointment(app_id);
    }
}

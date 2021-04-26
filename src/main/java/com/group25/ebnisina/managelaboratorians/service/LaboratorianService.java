package com.group25.ebnisina.managelaboratorians.service;

import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.repository.LaboratorianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaboratorianService {

    private final LaboratorianRepository laboratorianRepository;

    public List<Laboratorian> getAllLaboratorians() {
        return laboratorianRepository.getAllLaboratorians();
    }

    public List<Laboratorian> getLaboratoriansForTest(int test_type_id) {
        return laboratorianRepository.getLaboratoriansForTest(test_type_id);
    }

    public Laboratorian getLaboratorianById(int id) {
        return laboratorianRepository.getLaboratorianById(id);
    }

    public List<Laboratorian> getLaboratoriansByClinicId(int clinic_id) {
        return laboratorianRepository.getLaboratoriansByClinicId(clinic_id);
    }
}

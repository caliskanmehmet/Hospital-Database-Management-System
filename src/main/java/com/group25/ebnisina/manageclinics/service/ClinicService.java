package com.group25.ebnisina.manageclinics.service;

import com.group25.ebnisina.manageclinics.entity.Clinic;
import com.group25.ebnisina.manageclinics.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.getAllClinics();
    }
}

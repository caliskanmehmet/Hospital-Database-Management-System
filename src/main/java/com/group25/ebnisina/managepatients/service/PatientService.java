package com.group25.ebnisina.managepatients.service;

import com.group25.ebnisina.managepatients.entity.Patient;
import com.group25.ebnisina.managepatients.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public void addPatient(Patient patient) {
        patientRepository.addPerson(patient.getPassword(), patient.getFirst_name(), patient.getMiddle_name(),
                patient.getLast_name(), patient.getGender(), patient.getBirth_date());
        patientRepository.addPatient(patient.getSsn(), patient.getWeight(), patient.getHeight(), patient.getBlood_type());
    }

    public List<Patient> getPatients() {
        return patientRepository.getPatients();
    }

    public Patient getWithSsn(String ssn) {
        return patientRepository.getWithSsn(ssn);
    }
}

package com.group25.ebnisina.managelogin.service;

import com.group25.ebnisina.managelogin.entity.DoctorLogin;
import com.group25.ebnisina.managelogin.entity.LaboratorianLogin;
import com.group25.ebnisina.managelogin.entity.PatientLogin;
import com.group25.ebnisina.managelogin.repository.DoctorLoginRepository;
import com.group25.ebnisina.managelogin.repository.LaboratorianLoginRepository;
import com.group25.ebnisina.managelogin.repository.PatientLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final PatientLoginRepository patientLoginRepository;
    private final DoctorLoginRepository doctorLoginRepository;
    private final LaboratorianLoginRepository laboratorianLoginRepository;

    public PatientLogin checkPatientCredentials(String ssn, String password) {
        return patientLoginRepository.checkCredentials(ssn, password);
    }

    public DoctorLogin checkDoctorCredentials(int doctor_id, String password) {
        return doctorLoginRepository.checkCredentials(doctor_id, password);
    }

    public LaboratorianLogin checkLaboratorianCredentials(int laboratorian_id, String password) {
        return laboratorianLoginRepository.checkCredentials(laboratorian_id, password);
    }
}

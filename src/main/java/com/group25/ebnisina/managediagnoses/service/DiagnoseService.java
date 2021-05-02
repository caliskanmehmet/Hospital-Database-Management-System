package com.group25.ebnisina.managediagnoses.service;

import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import com.group25.ebnisina.managediagnoses.entity.Diagnose;
import com.group25.ebnisina.managediagnoses.repository.DiagnoseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnoseService {

    private final DiagnoseRepository diagnoseRepository;
    private final AppointmentRepository appointmentRepository;

    public List<Diagnose> getDiagnosesOfAppointment(int app_id) {
        return diagnoseRepository.getDiagnosesOfAppointment(app_id);
    }

    @Transactional
    public void addDiagnose(Diagnose diagnose) {
        diagnoseRepository.addDiagnose(diagnose.getExplanation(), diagnose.getApp_id(), diagnose.getDisease_id());
        appointmentRepository.updateAppointmentToFinalized(diagnose.getApp_id());
    }

    // TODO: Add multiple diagnoses
}

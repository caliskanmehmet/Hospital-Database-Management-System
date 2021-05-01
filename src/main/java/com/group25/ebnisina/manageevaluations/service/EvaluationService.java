package com.group25.ebnisina.manageevaluations.service;

import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import com.group25.ebnisina.manageevaluations.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final AppointmentRepository appointmentRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.getAllEvaluations();
    }

    public void addEvaluationToAppointment(Evaluation evaluation) {
        evaluationRepository.addEvaluationToAppointment(evaluation.getComment(), evaluation.getRating(), evaluation.getApp_id());
        appointmentRepository.updateAppointmentToEvaluated(evaluation.getApp_id());
    }

    public Integer getRatingOfDoctor(int doctor_id) {
        return evaluationRepository.getRatingOfDoctor(doctor_id);
    }

    public List<Evaluation> getEvaluationsOfDoctor(int doctor_id) {
        return evaluationRepository.getEvaluationsOfDoctor(doctor_id);
    }
}

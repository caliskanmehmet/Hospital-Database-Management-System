package com.group25.ebnisina.manageevaluations.service;

import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import com.group25.ebnisina.manageevaluations.entity.EvaluationReport;
import com.group25.ebnisina.manageevaluations.repository.EvaluationReportRepository;
import com.group25.ebnisina.manageevaluations.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final AppointmentRepository appointmentRepository;
    private final EvaluationReportRepository evaluationReportRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.getAllEvaluations();
    }

    public void addEvaluationToAppointment(Evaluation evaluation) {
        evaluationRepository.addEvaluationToAppointment(evaluation.getComment(), evaluation.getRating(), evaluation.getApp_id());
        appointmentRepository.updateAppointmentToEvaluated(evaluation.getApp_id());
    }

    public List<EvaluationReport> getReports() {
        return evaluationReportRepository.getReports();
    }

    public BigDecimal getRatingOfDoctor(int doctor_id) {
        return evaluationRepository.getRatingOfDoctor(doctor_id);
    }

    public List<Evaluation> getEvaluationsOfDoctor(int doctor_id) {
        List<Evaluation> evaluationList = evaluationRepository.getEvaluationsOfDoctor(doctor_id);
        evaluationList.get(0).setMax(evaluationRepository.getMaximumRatingOfDoctor(doctor_id));
        evaluationList.get(0).setMin(evaluationRepository.getMinimumRatingOfDoctor(doctor_id));
        return evaluationList;
    }
}

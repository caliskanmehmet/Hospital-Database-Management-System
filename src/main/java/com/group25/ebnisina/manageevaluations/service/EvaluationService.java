package com.group25.ebnisina.manageevaluations.service;

import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import com.group25.ebnisina.manageevaluations.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.getAllEvaluations();
    }

    public void addEvaluationToAppointment(Evaluation evaluation) {
        evaluationRepository.addEvaluationToAppointment(evaluation.getComment(), evaluation.getRating(), evaluation.getApp_id());
    }
}

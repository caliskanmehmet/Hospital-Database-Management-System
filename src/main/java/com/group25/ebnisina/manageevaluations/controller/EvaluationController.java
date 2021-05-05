package com.group25.ebnisina.manageevaluations.controller;

import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import com.group25.ebnisina.manageevaluations.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/evaluation")
@CrossOrigin(origins = "http://localhost:3000")
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping("/getAll")
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    @PostMapping("/add")
    public void addEvaluationToAppointment(@RequestBody Evaluation evaluation) {
        evaluationService.addEvaluationToAppointment(evaluation);
    }

    @GetMapping("/getRating/{doctor_id}")
    public BigDecimal getRatingOfDoctor(@PathVariable("doctor_id") int doctor_id) {
        return evaluationService.getRatingOfDoctor(doctor_id);
    }

    @GetMapping("/get/{doctor_id}")
    public List<Evaluation> getEvaluationsOfDoctor(@PathVariable("doctor_id") int doctor_id) {
        return evaluationService.getEvaluationsOfDoctor(doctor_id);
    }
}

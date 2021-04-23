package com.group25.ebnisina.manageevaluations.controller;

import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import com.group25.ebnisina.manageevaluations.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}

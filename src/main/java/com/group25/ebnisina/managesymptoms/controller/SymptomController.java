package com.group25.ebnisina.managesymptoms.controller;

import com.group25.ebnisina.managesymptoms.entity.Symptom;
import com.group25.ebnisina.managesymptoms.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/symptom")
@CrossOrigin(origins = "http://localhost:3000")
public class SymptomController {

    private final SymptomService symptomService;

    @GetMapping("/getAll")
    public List<Symptom> getSymptoms() {
        return symptomService.getSymptoms();
    }

    @GetMapping("/get/{app_id}")
    public List<Symptom> getSymptomsOfAppointment(@PathVariable("app_id") int app_id) {
        return symptomService.getSymptomsOfAppointment(app_id);
    }
}

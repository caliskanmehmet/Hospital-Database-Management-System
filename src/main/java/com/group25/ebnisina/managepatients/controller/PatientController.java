package com.group25.ebnisina.managepatients.controller;

import com.group25.ebnisina.managepatients.entity.Patient;
import com.group25.ebnisina.managepatients.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/getAll")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @PostMapping("/add")
    @Transactional
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }
}

package com.group25.ebnisina.managelaboratorians.controller;

import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.service.LaboratorianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laboratorian")
@CrossOrigin(origins = "http://localhost:3000")
public class LaboratorianController {

    private final LaboratorianService laboratorianService;

    @GetMapping("/getAll")
    public List<Laboratorian> getAllLaboratorians() {
        return laboratorianService.getAllLaboratorians();
    }

    @GetMapping("/getByTest/{test_type_id}")
    List<Laboratorian> getLaboratoriansForTest(@PathVariable("test_type_id") int test_type_id) {
        return laboratorianService.getLaboratoriansForTest(test_type_id);
    }

    @GetMapping("/get/{id}")
    public Laboratorian getLaboratorianById(@PathVariable("id") int id) {
        return laboratorianService.getLaboratorianById(id);
    }

    @GetMapping("/getByClinic/{clinicId}")
    public List<Laboratorian> getLaboratoriansByClinicId(@PathVariable("clinicId") int clinicId) {
        return laboratorianService.getLaboratoriansByClinicId(clinicId);
    }
}

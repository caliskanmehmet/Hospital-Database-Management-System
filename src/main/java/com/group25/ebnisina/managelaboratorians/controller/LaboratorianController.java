package com.group25.ebnisina.managelaboratorians.controller;

import com.group25.ebnisina.managelaboratorians.entity.Laboratorian;
import com.group25.ebnisina.managelaboratorians.service.LaboratorianService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/laboratorian")
public class LaboratorianController {

    private final LaboratorianService laboratorianService;

    @GetMapping("/getAll")
    public List<Laboratorian> getAllLaboratorians() {
        return laboratorianService.getAllLaboratorians();
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

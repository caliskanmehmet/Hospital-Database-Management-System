package com.group25.ebnisina.manageclinics.controller;

import com.group25.ebnisina.manageclinics.entity.Clinic;
import com.group25.ebnisina.manageclinics.service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clinic")
public class ClinicController {
    private final ClinicService clinicService;

    @GetMapping("/getAll")
    public List<Clinic> gelAllClinics() {
        return clinicService.getAllClinics();
    }
}

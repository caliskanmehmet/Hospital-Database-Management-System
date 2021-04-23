package com.group25.ebnisina.managediseases.controller;

import com.group25.ebnisina.managediseases.entity.Disease;
import com.group25.ebnisina.managediseases.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disease")
@RequiredArgsConstructor
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping("/getAll")
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }
}

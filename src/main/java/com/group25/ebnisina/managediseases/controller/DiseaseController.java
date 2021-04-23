package com.group25.ebnisina.managediseases.controller;

import com.group25.ebnisina.managediseases.entity.Disease;
import com.group25.ebnisina.managediseases.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disease")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping("/getAll")
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    @GetMapping("/get/{disease_id}")
    public Disease getDiseaseById(@PathVariable("disease_id") int disease_id) {
        return diseaseService.getDiseaseById(disease_id);
    }
}

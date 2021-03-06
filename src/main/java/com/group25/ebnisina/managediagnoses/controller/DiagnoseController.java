package com.group25.ebnisina.managediagnoses.controller;

import com.group25.ebnisina.managediagnoses.entity.Diagnose;
import com.group25.ebnisina.managediagnoses.service.DiagnoseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnose")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DiagnoseController {

    private final DiagnoseService diagnoseService;

    @GetMapping("/getByAppointment/{app_id}")
    public List<Diagnose> getDiagnosesOfAppointment(@PathVariable("app_id") int app_id) {
        return diagnoseService.getDiagnosesOfAppointment(app_id);
    }

    @PostMapping("/add/{app_id}")
    public void addDiagnose(@PathVariable("app_id") int app_id, @RequestBody List<Integer> diseases) {
        diagnoseService.addDiagnosesToAppointment(app_id, diseases);
    }
}

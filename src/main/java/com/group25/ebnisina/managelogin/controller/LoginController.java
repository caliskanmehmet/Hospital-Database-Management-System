package com.group25.ebnisina.managelogin.controller;

import com.group25.ebnisina.managelogin.entity.DoctorLogin;
import com.group25.ebnisina.managelogin.entity.LaboratorianLogin;
import com.group25.ebnisina.managelogin.entity.PatientLogin;
import com.group25.ebnisina.managelogin.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/patient")
    public PatientLogin patientLogin(@RequestParam String id, @RequestParam String password) {
        return loginService.checkPatientCredentials(id, password);
    }

    @GetMapping("/doctor")
    public DoctorLogin doctorLogin(@RequestParam int id, @RequestParam String password) {
        return loginService.checkDoctorCredentials(id, password);
    }

    @GetMapping("/laboratorian")
    public LaboratorianLogin laboratorianLogin(@RequestParam int id, @RequestParam String password) {
        return loginService.checkLaboratorianCredentials(id, password);
    }
}

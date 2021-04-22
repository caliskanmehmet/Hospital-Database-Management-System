package com.group25.ebnisina.managedoctors.controller;

import com.group25.ebnisina.managedoctors.entity.Doctor;
import com.group25.ebnisina.managedoctors.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/get/{id}")
    public Doctor getDoctorById(@PathVariable("id") int id) {
        return doctorService.getDoctorById(id);
    }
}

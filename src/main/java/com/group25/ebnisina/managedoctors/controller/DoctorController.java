package com.group25.ebnisina.managedoctors.controller;

import com.group25.ebnisina.managedoctors.dto.DoctorDTO;
import com.group25.ebnisina.managedoctors.entity.AppointmentRequest;
import com.group25.ebnisina.managedoctors.entity.Doctor;
import com.group25.ebnisina.managedoctors.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/doctor")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/getByClinic/{clinicId}")
    public List<Doctor> getDoctorsByClinicId(@PathVariable("clinicId") int clinicId) {
        return doctorService.getDoctorsByClinicId(clinicId);
    }

    @GetMapping("/getFreeDoctors")
    public List<DoctorDTO> getDoctorsWithDateAndClinic(@RequestBody AppointmentRequest appointmentRequest) {
        return doctorService.getDoctorsWithDateAndClinic(appointmentRequest.getClinic_id(), appointmentRequest.getDate());
    }
}

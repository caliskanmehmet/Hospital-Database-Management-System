package com.group25.ebnisina.manageappointments.controller;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import com.group25.ebnisina.manageappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: disease_shows_symptom

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/getByDoctor/{doctorId}")
    public List<Appointment> getAppointmentsOfDoctor(@PathVariable("doctorId") int doctorId) {
        return appointmentService.getAppointmentsOfDoctor(doctorId);
    }

    @GetMapping("/getByPatient/{patientId}")
    public List<Appointment> getAppointmentsOfPatient(@PathVariable("patientId") int patientId) {
        return appointmentService.getAppointmentsOfPatient(patientId);
    }

    @PostMapping("/add")
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @PostMapping("/addSymptom/{app_id}")
    public void addSymptomToAppointment(@PathVariable("app_id") int app_id, @RequestBody List<Integer> symptoms) {
        appointmentService.addSymptomsToAppointment(app_id, symptoms);
    }
}
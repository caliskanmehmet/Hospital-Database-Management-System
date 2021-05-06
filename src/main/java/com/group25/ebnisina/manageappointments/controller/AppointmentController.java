package com.group25.ebnisina.manageappointments.controller;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import com.group25.ebnisina.manageappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/getByDoctor/{doctorId}")
    public List<Appointment> getAppointmentsOfDoctor(@PathVariable("doctorId") int doctorId) {
        return appointmentService.getAppointmentsOfDoctor(doctorId);
    }

    @GetMapping("/getByPatient/{patientId}")
    public List<Appointment> getAppointmentsOfPatient(@PathVariable("patientId") int patientId) {
        return appointmentService.getAppointmentsOfPatient(patientId);
    }

    @PostMapping("/add")
    @Transactional
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }

    @PostMapping("/addSymptom/{app_id}")
    @Transactional
    public void addSymptomToAppointment(@PathVariable("app_id") int app_id, @RequestBody List<Integer> symptoms) {
        appointmentService.addSymptomsToAppointment(app_id, symptoms);
    }
}

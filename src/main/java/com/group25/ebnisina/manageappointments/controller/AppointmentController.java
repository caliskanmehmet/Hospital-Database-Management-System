package com.group25.ebnisina.manageappointments.controller;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import com.group25.ebnisina.manageappointments.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/appointment")
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

    @PostMapping("/add")
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentService.addAppointment(appointment);
    }
}

package com.group25.ebnisina.manageappointments.service;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import com.group25.ebnisina.manageappointments.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAllAppointments();
    }

    public List<Appointment> getAppointmentsOfDoctor(int doctorId) {
        return appointmentRepository.getAppointmentsOfDoctor(doctorId);
    }

    public List<Appointment> getAppointmentsOfPatient(int patient_id) {
        return appointmentRepository.getAppointmentsOfPatient(patient_id);
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment.getApp_date(), appointment.getApp_time(),
                appointment.getPatient_id(), appointment.getDoctor_id());
    }

    public void addSymptomsToAppointment(int app_id, List<Integer> symptoms) {
        symptoms.forEach(symptom_id -> {
            appointmentRepository.addSymptomToAppointment(app_id, symptom_id);
        });
    }
}

package com.group25.ebnisina.manageappointments.repository;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface AppointmentRepository extends org.springframework.data.repository.Repository<Appointment, Integer> {

    @Query(value = "SELECT * FROM Appointment", nativeQuery = true)
    public List<Appointment> getAllAppointments();

    @Query(value = "SELECT * FROM Appointment A WHERE A.doctor_id = ?1 ", nativeQuery = true)
    public List<Appointment> getAppointmentsOfDoctor(int doctorId);

    @Query(value = "SELECT * FROM Appointment A WHERE A.patient_id = ?1", nativeQuery = true)
    public List<Appointment> getAppointmentsOfPatient(int patient_id);

    // TODO: Add getSymptomsOfAppointment(int app_id) method

    @Query(value = "INSERT INTO Appointment (app_status, app_date, app_time, patient_id, doctor_id) VALUES" +
            "('Pending', ?1, ?2, ?3, ?4)", nativeQuery = true)
    @Modifying
    @Transactional
    public void addAppointment(Date app_date, Time app_time, int patient_id, int doctor_id);

    @Query(value = "INSERT INTO Symptoms_during_visit (app_id, symptom_id) VALUES" +
            "(?1, ?2)", nativeQuery = true)
    @Modifying
    @Transactional
    public void addSymptomToAppointment(int app_id, int symptom_id);
}

package com.group25.ebnisina.manageappointments.repository;

import com.group25.ebnisina.manageappointments.entity.Appointment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends org.springframework.data.repository.Repository<Appointment, Integer> {

    @Query(value = "SELECT * " +
            "FROM AppointmentsOfCurrentMonth A, Patient PA, Person PE, Doctor D, Clinic C " +
            "WHERE A.doctor_id = ?1 AND A.patient_id = PA.patient_id AND PA.person_id = PE.id AND " +
            "D.doctor_id = ?1 AND D.clinic_id = C.clinic_id", nativeQuery = true)
    List<Appointment> getAppointmentsOfDoctor(int doctorId);

    @Query(value = "SELECT * " +
            "FROM AppointmentsOfCurrentMonth A, Doctor D, Person P, Clinic C " +
            "WHERE A.patient_id = ?1 AND A.doctor_id = D.doctor_id AND D.person_id = P.id AND " +
            "D.clinic_id = C.clinic_id " +
            "ORDER BY A.app_date DESC", nativeQuery = true)
    List<Appointment> getAppointmentsOfPatient(int patient_id);

    @Query(value = "INSERT INTO Appointment (app_status, app_date, patient_id, doctor_id) VALUES" +
            "('Pending', ?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addAppointment(LocalDate app_date, int patient_id, int doctor_id);

    @Query(value = "INSERT INTO Symptoms_during_visit (app_id, symptom_id) VALUES" +
            "(?1, ?2)", nativeQuery = true)
    @Modifying
    @Transactional
    void addSymptomToAppointment(int app_id, int symptom_id);

    @Query(value = "UPDATE Appointment " +
            "SET app_status = 'Finalized' " +
            "WHERE app_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateAppointmentToFinalized(int app_id);

    @Query(value = "UPDATE Appointment " +
            "SET app_status = 'Evaluated' " +
            "WHERE app_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateAppointmentToEvaluated(int app_id);

    @Query(value = "UPDATE Appointment " +
            "SET app_status = 'Tests Requested' " +
            "WHERE app_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateAppointmentToTestRequested(int app_id);

    @Query(value = "UPDATE Appointment " +
            "SET app_status = 'Tests Finished' " +
            "WHERE app_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateAppointmentToTestFinished(int app_id);

}

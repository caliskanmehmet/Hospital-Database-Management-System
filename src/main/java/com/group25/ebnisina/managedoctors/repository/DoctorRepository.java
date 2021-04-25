package com.group25.ebnisina.managedoctors.repository;

import com.group25.ebnisina.managedoctors.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DoctorRepository extends org.springframework.data.repository.Repository<Doctor, Integer> {
    @Query(value = "SELECT * FROM doctor d INNER JOIN Person p ON p.id = d.person_id", nativeQuery = true)
    List<Doctor> getAllDoctors();

    @Query(value = "SELECT * " +
            "FROM doctor d " +
            "INNER JOIN Person p ON p.id = d.person_id " +
            "WHERE d.doctor_id = ?1", nativeQuery = true)
    Doctor getDoctorById(int id);

    @Query(value = "SELECT * " +
            "FROM doctor d " +
            "INNER JOIN Person p ON p.id = d.person_id " +
            "WHERE d.clinic_id = ?1", nativeQuery = true)
    List<Doctor> getDoctorsByClinicId(int clinic_id);

    /*
        1-) They shouldn't have appointment at the specified date
        2-) They shouldn't have off day at the specified date
     */
    @Query(value = "SELECT * " +
            "FROM Doctor D, Person P " +
            "WHERE D.clinic_id = ?1 AND D.person_id = P.id AND " +
            "D.doctor_id NOT IN (SELECT D.doctor_id " +
                                "FROM Doctor D, Appointment A " +
                                "WHERE D.clinic_id = ?1 AND D.doctor_id = A.doctor_id AND A.app_date = ?2 UNION " +
                                "SELECT O.doctor_id " +
                                "FROM Off_days_of_doctor O " +
                                "WHERE O.off_date = ?2)", nativeQuery = true)
    List<Doctor> getDoctorsWithDateAndClinic(int clinic_id, LocalDate date);
}

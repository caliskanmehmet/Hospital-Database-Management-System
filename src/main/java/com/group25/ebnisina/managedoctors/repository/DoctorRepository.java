package com.group25.ebnisina.managedoctors.repository;

import com.group25.ebnisina.managedoctors.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends org.springframework.data.repository.Repository<Doctor, Integer> {
    @Query(value = "SELECT * FROM doctor d", nativeQuery = true)
    List<Doctor> getAllDoctors();

    @Query(value = "SELECT * FROM doctor d WHERE d.id = ?1", nativeQuery = true)
    Doctor getDoctorById(int id);

    @Query(value = "SELECT * FROM doctor d Where d.clinic_id = ?1", nativeQuery = true)
    List<Doctor> getDoctorsByClinicId(int clinic_id);
}

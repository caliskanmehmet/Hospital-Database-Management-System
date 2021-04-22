package com.group25.ebnisina.managedoctors.service;

import com.group25.ebnisina.managedoctors.entity.Doctor;
import com.group25.ebnisina.managedoctors.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.getDoctorById(id);
    }
}

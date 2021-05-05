package com.group25.ebnisina.managedoctors.service;

import com.group25.ebnisina.managedoctors.dto.DoctorDTO;
import com.group25.ebnisina.managedoctors.entity.Doctor;
import com.group25.ebnisina.managedoctors.mapper.DoctorMapper;
import com.group25.ebnisina.managedoctors.repository.DoctorRepository;
import com.group25.ebnisina.manageevaluations.service.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final EvaluationService evaluationService;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.getDoctorById(id);
    }

    public List<Doctor> getDoctorsByClinicId(int clinicId) {
        return doctorRepository.getDoctorsByClinicId(clinicId);
    }

    public List<DoctorDTO> getDoctorsWithDateAndClinic(int clinic_id, LocalDate date) {
        List<Doctor> doctorList = doctorRepository.getDoctorsWithDateAndClinic(clinic_id, date);
        doctorList.forEach(doctor -> {
            doctor.setRating(evaluationService.getRatingOfDoctor(doctor.getDoctor_id()));
            System.out.println("Rating: " + evaluationService.getRatingOfDoctor(doctor.getDoctor_id()));
        });
        return doctorMapper.mapToDto(doctorList);
    }
}

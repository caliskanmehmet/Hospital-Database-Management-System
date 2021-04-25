package com.group25.ebnisina.managedoctors.mapper;

import com.group25.ebnisina.managedoctors.dto.DoctorDTO;
import com.group25.ebnisina.managedoctors.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO mapToDto(Doctor doctor);
    Doctor mapToEntity(DoctorDTO doctor);

    List<DoctorDTO> mapToDto(List<Doctor> doctorList);
    List<Doctor> mapToEntity(List<DoctorDTO> doctorDTOList);
}

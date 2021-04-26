package com.group25.ebnisina.manageoffdays.service;

import com.group25.ebnisina.manageoffdays.entity.OffDay;
import com.group25.ebnisina.manageoffdays.repository.OffDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffDayService {

    private final OffDayRepository offDayRepository;

    public List<OffDay> getOffDaysOfDoctor(int doctor_id) {
        return offDayRepository.getOffDaysOfDoctor(doctor_id);
    }

    public void addOffDayToDoctor(LocalDate offDay, int doctor_id) {
        offDayRepository.addOffDayToDoctor(offDay, doctor_id);
    }
}

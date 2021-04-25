package com.group25.ebnisina.manageoffdays.controller;

import com.group25.ebnisina.manageoffdays.entity.OffDay;
import com.group25.ebnisina.manageoffdays.service.OffDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offDay")
@CrossOrigin(origins = "http://localhost:3000")
public class OffDayController {

    private final OffDayService offDayService;

    @GetMapping("/get/{doctor_id}")
    public List<OffDay> getOffDaysOfDoctor(@PathVariable("doctor_id") int doctor_id) {
        return offDayService.getOffDaysOfDoctor(doctor_id);
    }
}

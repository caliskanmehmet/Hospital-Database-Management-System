package com.group25.ebnisina.manageelibiglefor.controller;

import com.group25.ebnisina.manageelibiglefor.entity.EligibleFor;
import com.group25.ebnisina.manageelibiglefor.service.EligibleForService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eligibleFor")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EligibleForController {

    private final EligibleForService eligibleForService;

    @GetMapping("/getAll")
    public List<EligibleFor> getAll() {
        return eligibleForService.getAll();
    }

    @GetMapping("/get/{laboratorian_id}")
    public List<EligibleFor> getEligibleTestsOfLaboratorian(@PathVariable("laboratorian_id") int laboratorian_id) {
        return eligibleForService.getEligibleTestsOfLaboratorian(laboratorian_id);
    }
}

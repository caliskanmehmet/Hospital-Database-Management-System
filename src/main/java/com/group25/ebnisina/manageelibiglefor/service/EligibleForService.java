package com.group25.ebnisina.manageelibiglefor.service;

import com.group25.ebnisina.manageelibiglefor.entity.EligibleFor;
import com.group25.ebnisina.manageelibiglefor.repository.EligibleForRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EligibleForService {

    private final EligibleForRepository eligibleForRepository;

    public List<EligibleFor> getAll() {
        return eligibleForRepository.getAll();
    }

    public List<EligibleFor> getEligibleTestsOfLaboratorian(int laboratorian_id) {
        return eligibleForRepository.getEligibleTestsOfLaboratorian(laboratorian_id);
    }
}

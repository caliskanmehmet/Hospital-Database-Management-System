package com.group25.ebnisina.manageprocess.service;

import com.group25.ebnisina.manageprocess.entity.Process;
import com.group25.ebnisina.manageprocess.repository.ProcessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService {

    private final ProcessRepository processRepository;

    public List<Process> getProcesses() {
        return processRepository.getProcesses();
    }

    public void addProcess(Process process) {
        processRepository.addProcess(LocalDate.now(), process.getComment(),
                process.getLaboratorian_id(), process.getRequest_id());
    }
}

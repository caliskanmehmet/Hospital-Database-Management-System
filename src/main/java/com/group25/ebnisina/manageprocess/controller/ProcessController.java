package com.group25.ebnisina.manageprocess.controller;

import com.group25.ebnisina.manageprocess.entity.Process;
import com.group25.ebnisina.manageprocess.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/process")
@CrossOrigin(origins = "http://localhost:3000")
public class ProcessController {

    private final ProcessService processService;

    @GetMapping("/getAll")
    public List<Process> getProcesses() {
        return processService.getProcesses();
    }

    @GetMapping("/get/{laboratorian_id}")
    public List<Process> getProcessesOfLaboratorian(@PathVariable("laboratorian_id") int laboratorian_id) {
        return processService.getProcessesOfLaboratorian(laboratorian_id);
    }

    @PostMapping("/add")
    @Transactional
    public void addProcess(@RequestBody Process process) {
        processService.addProcess(process);
    }
}

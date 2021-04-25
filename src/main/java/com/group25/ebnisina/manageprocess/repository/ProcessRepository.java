package com.group25.ebnisina.manageprocess.repository;

import com.group25.ebnisina.manageprocess.entity.Process;
import com.group25.ebnisina.manageprocess.entity.ProcessId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProcessRepository extends org.springframework.data.repository.Repository<Process, ProcessId> {

    @Query(value = "SELECT * FROM Process", nativeQuery = true)
    List<Process> getProcesses();

    @Query(value = "INSERT INTO Process (date_time, comment, laboratorian_id, request_id) VALUES" +
            "(?1, ?2, ?3, ?4)", nativeQuery = true)
    @Modifying
    @Transactional
    void addProcess(LocalDate date_time, String comment, int laboratorian_id, int request_id);
}

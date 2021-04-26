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

    @Query(value = "SELECT * FROM Process " +
            "WHERE laboratorian_id = ?1", nativeQuery = true)
    List<Process> getProcessesOfLaboratorian(int laboratorian_id);

    @Query(value = "INSERT INTO Process (date_time, status, comment, laboratorian_id, request_id) VALUES" +
            "(?1, 'Assigned', '', ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addProcess(LocalDate date_time, int laboratorian_id, int request_id);

    @Query(value = "UPDATE Process " +
            "SET status = 'Preparing' " +
            "WHERE request_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateTestStatusToPreparing(int request_id);

    @Query(value = "UPDATE Process " +
            "SET status = 'Finalized' " +
            "WHERE request_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateTestStatusToFinalized(int request_id);

    @Query(value = "UPDATE Process " +
            "SET comment = ?2 " +
            "WHERE request_id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateComment(int request_id, String comment);
}

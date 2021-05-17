package com.group25.ebnisina.manageevaluations.repository;

import com.group25.ebnisina.manageevaluations.entity.Evaluation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EvaluationRepository extends org.springframework.data.repository.Repository<Evaluation, Integer> {

    @Query(value = "SELECT * FROM Evaluation", nativeQuery = true)
    List<Evaluation> getAllEvaluations();

    @Query(value = "CALL RatingOfDoctor(?1)", nativeQuery = true)
    BigDecimal getRatingOfDoctor(int doctor_id);

    @Query(value = "SELECT MAX(E.rating) " +
            "FROM Evaluation E, Appointment A " +
            "WHERE E.app_id = A.app_id AND A.doctor_id = ?1", nativeQuery = true)
    Integer getMaximumRatingOfDoctor(int doctor_id);

    @Query(value = "SELECT MIN(E.rating) " +
            "FROM Evaluation E, Appointment A " +
            "WHERE E.app_id = A.app_id AND A.doctor_id = ?1", nativeQuery = true)
    Integer getMinimumRatingOfDoctor(int doctor_id);

    @Query(value = "SELECT E.* " +
            "FROM Evaluation E, Appointment A " +
            "WHERE E.app_id = A.app_id AND A.doctor_id = ?1 ", nativeQuery = true)
    List<Evaluation> getEvaluationsOfDoctor(int doctor_id);

    @Query(value = "INSERT INTO Evaluation (comment, rating, app_id) VALUES" +
            "(?1, ?2, ?3)", nativeQuery = true)
    @Modifying
    @Transactional
    void addEvaluationToAppointment(String comment, int rating, int app_id);
}

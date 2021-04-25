package com.group25.ebnisina.manageoffdays.repository;

import com.group25.ebnisina.manageoffdays.entity.OffDay;
import com.group25.ebnisina.manageoffdays.entity.OffDayId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffDayRepository extends org.springframework.data.repository.Repository<OffDay, OffDayId> {

    @Query(value = "SELECT * FROM Off_days_of_doctor O WHERE O.doctor_id = ?1", nativeQuery = true)
    List<OffDay> getOffDaysOfDoctor(int doctor_id);
}

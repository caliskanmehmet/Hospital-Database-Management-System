package com.group25.ebnisina.managetesttypes.repository;

import com.group25.ebnisina.managetesttypes.entity.TestType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestTypeRepository extends org.springframework.data.repository.Repository<TestType, Integer> {

    @Query(value = "SELECT * FROM Test_type", nativeQuery = true)
    List<TestType> getTestTypes();
}

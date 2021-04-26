package com.group25.ebnisina.managetestcomponents.repository;

import com.group25.ebnisina.managetestcomponents.entity.TestComponent;
import com.group25.ebnisina.managetestcomponents.entity.TestComponentId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestComponentRepository extends org.springframework.data.repository.Repository<TestComponent, TestComponentId> {

    @Query(value = "SELECT * FROM Test_component", nativeQuery = true)
    List<TestComponent> getAllTestComponents();

    @Query(value = "SELECT * FROM Test_component T WHERE T.test_type_id = ?1", nativeQuery = true)
    List<TestComponent> getTestComponentsOfTestType(int test_type_id);

    @Query(value = "SELECT COUNT(*) " +
            "FROM Test_component T " +
            "WHERE T.test_type_id = ?1", nativeQuery = true)
    int getComponentCountOfTestType(int test_type_id);
}

package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer> {

    Optional<EmployeesEntity> findByEmpNo(int empNo);

    List<EmployeesEntity> findAllByFirstName(String firstName);








//    Optional<EmployeesEntity> findByFirstNameStartsWith(String Name) throws Exception;
//
//    int countByFirstNameStartsWith(String Name) throws Exception;
//
//    @Query("SELECT e FROM EmployeesEntity AS e WHERE e.gender = ?1")
//    List<EmployeesEntity> querySelectGender(String Gender);
}

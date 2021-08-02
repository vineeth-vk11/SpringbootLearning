package com.springbootlearning.SpringbootLearning.EmployeeManagement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);
    Optional<Employee> findByIdAndDepartmentId(Long id, Long departmentId);
}

package com.springbootlearning.SpringbootLearning.DepartmentManagement;

import com.springbootlearning.SpringbootLearning.EmployeeManagement.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

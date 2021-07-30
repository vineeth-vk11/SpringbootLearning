package com.springbootlearning.SpringbootLearning.DepartmentManagement;

import com.springbootlearning.SpringbootLearning.EmployeeManagement.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long departmentId;

    private String departmentName;

}

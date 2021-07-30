package com.springbootlearning.SpringbootLearning.EmployeeManagement;


import com.springbootlearning.SpringbootLearning.DepartmentManagement.Department;

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String employeeName, employeeAddress, employeeEducation, employeeContactNumber;
    private Integer employeeAge;

    private Long departmentId;

    public Employee() {
    }

    public Employee(String employeeName, String employeeAddress, String employeeEducation, String employeeContactNumber, Integer employeeAge, Long departmentId) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeEducation = employeeEducation;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeAge = employeeAge;
        this.departmentId = departmentId;
    }

    public Employee(Long id, String employeeName, String employeeAddress, String employeeEducation, String employeeContactNumber, Integer employeeAge, Long departmentId) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeEducation = employeeEducation;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeAge = employeeAge;
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeEducation() {
        return employeeEducation;
    }

    public void setEmployeeEducation(String employeeEducation) {
        this.employeeEducation = employeeEducation;
    }

    public String getEmployeeContactNumber() {
        return employeeContactNumber;
    }

    public void setEmployeeContactNumber(String employeeContactNumber) {
        this.employeeContactNumber = employeeContactNumber;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }
}

package com.springbootlearning.SpringbootLearning.EmployeeManagement;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springbootlearning.SpringbootLearning.DepartmentManagement.Department;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_address")
    private String employeeAddress;

    @Column(name = "employee_education")
    private String employeeEducation;

    @Column(name = "employee_contact_number")
    private String employeeContactNumber;

    @Column(name = "employee_age")
    private Integer employeeAge;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String employeeName, String employeeAddress, String employeeEducation, String employeeContactNumber, Integer employeeAge) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeEducation = employeeEducation;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeAge = employeeAge;
    }

    public Employee(String employeeName, String employeeAddress, String employeeEducation, String employeeContactNumber, Integer employeeAge, Department department) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeEducation = employeeEducation;
        this.employeeContactNumber = employeeContactNumber;
        this.employeeAge = employeeAge;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeEducation='" + employeeEducation + '\'' +
                ", employeeContactNumber='" + employeeContactNumber + '\'' +
                ", employeeAge=" + employeeAge +
                '}';
    }
}

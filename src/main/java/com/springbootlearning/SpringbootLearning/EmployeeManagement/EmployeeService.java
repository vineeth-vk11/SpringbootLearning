package com.springbootlearning.SpringbootLearning.EmployeeManagement;

import com.springbootlearning.SpringbootLearning.DepartmentManagement.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> listAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> listEmployeesInDepartment(Long departmentId){
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public String numberOfEmployeesInADepartment(Long departmentId){
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
        return "Employees in department - " + String.valueOf(employeeList.size());
    }


    public void createEmployee(Long departmentId, Employee employee){

        departmentRepository.findById(departmentId).map(
                department -> {
                    employee.setDepartment(department);
                    return employeeRepository.save(employee);
                }
        );
    }

    public void updateEmployee(Long departmentId, Long employeeId, Employee updatedEmployee){
        employeeRepository.findById(employeeId).map(
                employee -> {
                    employee.setEmployeeName(updatedEmployee.getEmployeeName());
                    employee.setEmployeeAddress(updatedEmployee.getEmployeeAddress());
                    employee.setEmployeeAge(updatedEmployee.getEmployeeAge());
                    employee.setEmployeeContactNumber(updatedEmployee.getEmployeeContactNumber());
                    employee.setEmployeeEducation(updatedEmployee.getEmployeeEducation());

                    return employeeRepository.save(employee);
                }
        );
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }

    public void deleteEmployee(Long departmentId, Long employeeId){

        employeeRepository.findByIdAndDepartmentId(employeeId, departmentId).map(
                employee -> {
                    employeeRepository.delete(employee);
                    return ResponseEntity.ok().build();
                }
        );
    }

}

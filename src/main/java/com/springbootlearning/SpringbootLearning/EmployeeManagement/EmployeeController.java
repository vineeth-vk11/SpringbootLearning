package com.springbootlearning.SpringbootLearning.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/department/{id}/createEmployee")
    public void add(@RequestBody Employee employee, @PathVariable Long id){
        employeeService.createEmployee(id, employee);
    }

    @PutMapping("/department/{departmentId}/updateEmployee/{employeeId}")
    public void update(@RequestBody Employee employee, @PathVariable Long departmentId, @PathVariable Long employeeId){
        employeeService.updateEmployee(departmentId, employeeId, employee);
    }

    @DeleteMapping("/department/{departmentId}/deleteEmployee/{employeeId}")
    public void delete(@PathVariable Long departmentId, @PathVariable Long employeeId){
        employeeService.deleteEmployee(departmentId, employeeId);
    }

    @GetMapping("/getEmployees")
    public List<Employee> list(){
        return employeeService.listAllEmployees();
    }

    @GetMapping("/department/{departmentId}/getEmployees")
    public List<Employee> getEmployeesInDepartment(@PathVariable Long departmentId){
        return employeeService.listEmployeesInDepartment(departmentId);
    }

    @GetMapping("/department/{departmentId}/departmentOverview")
    public String getNumberOfEmployeesInDepartment(@PathVariable Long departmentId){
        return employeeService.numberOfEmployeesInADepartment(departmentId);
    }

    @GetMapping("/getEmployeeDetails/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping("/getEmployeeAndDepartmentDetails/{employeeId}")
    public Employee getEmployeeAndDepartmentDetails(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }
}

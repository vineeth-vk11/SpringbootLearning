package com.springbootlearning.SpringbootLearning.DepartmentManagement;

import com.springbootlearning.SpringbootLearning.EmployeeManagement.Employee;
import com.springbootlearning.SpringbootLearning.EmployeeManagement.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public List<Department> listAllDepartments(){
        return departmentRepository.findAll();
    }

    public void saveDepartment(Department department){
        departmentRepository.save(department);
    }

    public Department getDepartment(Long id){
        return departmentRepository.findById(id).get();
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

}

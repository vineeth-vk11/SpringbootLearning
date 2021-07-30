package com.springbootlearning.SpringbootLearning.DepartmentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/saveDepartment")
    public void add(@RequestBody Department department){
        departmentService.saveDepartment(department);
    }

    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<?> update(@RequestBody Department department, @PathVariable Long id){
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public void delete(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

    @GetMapping("/getDepartments")
    public List<Department> list(){
        return departmentService.listAllDepartments();
    }
}

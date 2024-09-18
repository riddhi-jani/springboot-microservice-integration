package com.example.department.controller;

import com.example.department.model.Department;
import com.example.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        Department departmentEntity = departmentService.addDepartment(department);
        return new ResponseEntity<>(departmentEntity, HttpStatus.CREATED);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") long departmentId){
        Department department = departmentService.getByDepartmentId(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/name/{departmentId}")
    public ResponseEntity<String> getDepartmentNameById(@PathVariable("departmentId") long departmentId){
        String name = departmentService.getNameByDepartmentId(departmentId);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departmentList = departmentService.getAllDepartment();
        return new ResponseEntity<>(departmentList, HttpStatus.OK);
    }

}

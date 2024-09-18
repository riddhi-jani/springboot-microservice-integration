package com.example.department.service;

import com.example.department.model.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDepartment();

    public Department getByDepartmentId(long departmentId);
    public String getNameByDepartmentId(long departmentId);

    public Department addDepartment(Department department);

}

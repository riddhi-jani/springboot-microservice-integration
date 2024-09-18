package com.example.department.service;

import com.example.department.client.EmployeeService;
import com.example.department.model.Department;
import com.example.department.model.Employee;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeService employeeService;
    @Override
    public List<Department> getAllDepartment() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(department -> {
            List<Employee> employeeList = employeeService.findByDepartment(department.getDepartmentId());
            department.setEmployeeList(employeeList);
            return department;
        }).collect(Collectors.toList());
    }

    @Override
    public Department getByDepartmentId(long departmentId) {
        Department department = departmentRepository.findByDepartmentId(departmentId);
        List<Employee> employeeList = employeeService.findByDepartment(department.getDepartmentId());
        department.setEmployeeList(employeeList);
        return department;
    }

    @Override
    public String getNameByDepartmentId(long departmentId) {
        return departmentRepository.findNameByDepartmentId(departmentId);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
}

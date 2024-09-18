package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getByEmployeeId(long employeeId);
    List<Employee> getByDepartmentId(long departmentId);
    List<Employee> getAllEmployee();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
}

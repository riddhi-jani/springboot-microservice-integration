package com.example.employee.service;

import com.example.employee.client.DepartmentService;
import com.example.employee.model.Department;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee getByEmployeeId(long employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        String departmentName = departmentService.findNameByDepartmentId(employee.getDepartmentId());
        employee.setDepartmentName(departmentName);
        return employee;
    }

    @Override
    public List<Employee> getByDepartmentId(long departmentId) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
        return employeeList.stream().map(employee -> {
            String departmentName = departmentService.findNameByDepartmentId(employee.getDepartmentId());
            employee.setDepartmentName(departmentName);
            return employee;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList =  employeeRepository.findAll();
        return employeeList.stream().map(employee -> {
            String departmentName = departmentService.findNameByDepartmentId(employee.getDepartmentId());
            employee.setDepartmentName(departmentName);
            return employee;
        }).collect(Collectors.toList());
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}

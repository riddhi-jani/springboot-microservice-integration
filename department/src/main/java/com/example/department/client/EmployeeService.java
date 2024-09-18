package com.example.department.client;

import com.example.department.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeService {

    @GetMapping("/employees/department/{departmentId}")
    List<Employee> findByDepartment(@PathVariable("departmentId") long departmentId);
}

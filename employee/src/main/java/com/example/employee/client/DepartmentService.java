package com.example.employee.client;

import com.example.employee.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "department-service")
public interface DepartmentService {

    @GetMapping("/departments/name/{departmentId}")
    String findNameByDepartmentId(@PathVariable("departmentId") long departmentId);
}

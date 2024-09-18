package com.example.department.repository;

import com.example.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentId(long departmentId);

    @Query("SELECT d.name FROM Department d WHERE d.departmentId = :departmentId")
    String findNameByDepartmentId(@Param("departmentId") long departmentId);
}

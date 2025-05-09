package com.example.demo;
// Java Program to Illustrate DepartmentService.java File

// Importing packages
// Importing required classes
import java.util.List;

// Class
public interface DepartmentService {

    // Save operation
    Employee saveDepartment(Employee department);

    // Read operation
    List<Employee> fetchDepartmentList();

    // Update operation
    Employee updateDepartment(Employee department,
                                Long departmentId);

    // Delete operation
    void deleteDepartmentById(Long departmentId);
}

package com.example.demo;
// Java Program to Illustrate DepartmentServiceImpl.java
// File

// Importing required packages

// Importing required classes
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class implementing DepartmentService class
public class DepartmentServiceImpl
        implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    // Save operation
    @Override
    public Employee saveDepartment(Employee department)
    {
        return departmentRepository.save(department);
    }

    // Read operation
    @Override public List<Employee> fetchDepartmentList()
    {
        return (List<Employee>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Employee
    updateDepartment(Employee department,
                     Long departmentId)
    {

        Employee depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
}

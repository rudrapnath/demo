package com.example.demo.service;
// Java Program to Illustrate DepartmentServiceImpl.java
// File

// Importing required packages

// Importing required classes
import java.util.List;
import java.util.Objects;

import com.example.demo.controller.DepartmentNotExistException;
import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
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
    public Department saveDepartment(Department department)
    {
        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            return departmentRepository.save(department);
        }
        else
            throw new DepartmentNotExistException("Department code invalid");



    }

    // Read operation
    @Override public List<Department> fetchDepartmentList()
    {
        return (List<Department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {

        Department depDB
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
        else
            throw new DepartmentNotExistException("Department code invalid");
        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        if(departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
        }
        else {
            throw new DepartmentNotExistException("Department not found");
        }



    }

    @Override
    public Department fetchDepartmentById(Long departmentId)  {
        if(departmentRepository.existsById(departmentId)) {
            return departmentRepository.findById(departmentId)
                    .get();
        }
        else {
            throw new DepartmentNotExistException("Department not found");
        }

    }

}

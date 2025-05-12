package com.example.demo.controller;
// Java Program to Illustrate DepartmentController.java File

// Importing packages modules
import java.util.List;
// Importing required classes
//import javax.validation.Valid;
import com.example.demo.entity.Response;
import com.example.demo.service.DepartmentService;
import com.example.demo.entity.Department;
import com.example.demo.entity.DepartmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
// Class
public class DepartmentController {

    //@Autowired
    //DepartmentRepository departmentRepository;
    @Autowired
    DepartmentService departmentService;



    // Save operation
    @PostMapping("/departments")

    public ResponseEntity saveDepartment(
            @RequestBody DepartmentWrapper deptWrapper)
    {
        Department department=new Department();
        department.setDepartmentAddress(deptWrapper.getDepartmentAddress());
        department.setDepartmentName(deptWrapper.getDepartmentName());
        department.setDepartmentCode(deptWrapper.getDepartmentCode());
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping("/departments")

    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")

    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }

    @GetMapping("/departmentById/{id}")

    public Department fetchDepartment(@PathVariable("id")
                                                Long departmentId)
    {

        return departmentService.fetchDepartmentById(departmentId);

    }

    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
                department, departmentId);
    }

}

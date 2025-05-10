package com.example.demo;
// Java Program to Illustrate DepartmentController.java File

// Importing packages modules
import java.util.List;
// Importing required classes
//import javax.validation.Valid;
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
        Employee department=new Employee();
        department.setDepartmentAddress(deptWrapper.getDepartmentAddress());
        department.setDepartmentName(deptWrapper.getDepartmentName());
        department.setDepartmentCode(deptWrapper.getDepartmentCode());
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping("/departments")

    public List<Employee> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

}

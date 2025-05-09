package com.example.demo;
// Java Program to Illustrate DepartmentController.java File

// Importing packages modules
import java.util.List;
// Importing required classes
//import javax.validation.Valid;
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
            @RequestBody Employee department)
    {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

}

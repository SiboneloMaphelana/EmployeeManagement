package com.employees.EmployeeManagement.controllers;

import com.employees.EmployeeManagement.DTOs.DepartmentDTO;
import com.employees.EmployeeManagement.models.Department;
import com.employees.EmployeeManagement.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentService.getDepartment(id);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department){
        return  departmentService.addDepartment(department);
    }

    @PutMapping("deparments/{id}")
    public void updateDepartment(@PathVariable Integer id, @RequestParam Department department){
        departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
    }

    @PatchMapping("departments/{id}")
    public void patchDepartmentByID(@RequestBody DepartmentDTO d, @PathVariable Integer id) {
        departmentService.patchDepartment(d, id);
    }
}

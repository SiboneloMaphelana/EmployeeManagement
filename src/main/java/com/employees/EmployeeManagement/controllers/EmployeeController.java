package com.employees.EmployeeManagement.controllers;

import com.employees.EmployeeManagement.DTOs.EmployeeDTO;
import com.employees.EmployeeManagement.models.Employee;
import com.employees.EmployeeManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return  employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @PatchMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(id, employeeDTO);
    }
}

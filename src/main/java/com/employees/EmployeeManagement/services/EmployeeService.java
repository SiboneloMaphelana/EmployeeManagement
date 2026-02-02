package com.employees.EmployeeManagement.services;

import com.employees.EmployeeManagement.DTOs.EmployeeDTO;
import com.employees.EmployeeManagement.models.Employee;
import com.employees.EmployeeManagement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Integer id, EmployeeDTO employeeDTO){
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
        Employee updatedEmployee = objectMapper.updateValue(existingEmployee, employeeDTO);

        return employeeRepository.save(updatedEmployee);
    }
}

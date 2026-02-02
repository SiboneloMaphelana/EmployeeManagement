package com.employees.EmployeeManagement.services;

import com.employees.EmployeeManagement.DTOs.DepartmentDTO;
import com.employees.EmployeeManagement.models.Department;
import com.employees.EmployeeManagement.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    public Department getDepartment(Integer id){
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department ID does not exist"));
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void updateDepartment(Department department, Integer id){
        if (Objects.equals(id, department.getId())){
            departmentRepository.save(department);
        }
    }

    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
    }

    public void patchDepartment(DepartmentDTO department, Integer id){
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
        Department patchedDepartment = objectMapper.updateValue(existingDepartment, department);
        departmentRepository.save(patchedDepartment);

    }


}

package com.employees.EmployeeManagement.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDTO {

    private String name;
    private String lastName;
    private Integer department;
}

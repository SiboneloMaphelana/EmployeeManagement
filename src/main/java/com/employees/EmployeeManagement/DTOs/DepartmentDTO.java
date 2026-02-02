package com.employees.EmployeeManagement.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Any field not present in the incoming JSON is ignored during the mapping, ensuring that other values stay the same in the database.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO {
    private String name;
    private Integer buildId;
}

package com.ideas2it.companymanagement.resource.dto;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the project database table.
 */

@Data
public class ProjectDto {
    private int id;

    private String projectDescription;

    private String projectName;

    private EmployeeDto employeeDto;

    private List<EmployeeDto> employeesDto = new ArrayList<>();
}
package com.ideas2it.companymanagement.employeemanagement.dto;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleDto {
    private int id;
    private String role;
    private List<Employee> employee;
}

package com.ideas2it.companymanagement.employee.service;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto trainerDto);

    List<EmployeeDto> getEmployeeDetails();

    EmployeeDto getEmployeeDetailsById(int id);

    boolean deleteEmployeeDetailsById(int id);

    EmployeeDto updateEmployeeDetails(EmployeeDto trainerDto);

}

package com.ideas2it.companymanagement.employee.helper;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.dto.RoleDto;
import com.ideas2it.companymanagement.employee.entity.Employee;
import com.ideas2it.companymanagement.employee.entity.Role;
import com.ideas2it.companymanagement.employee.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleHelper {
    public static Role roleDtoToRole(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRole(roleDto.getRole());
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDto> employeesDto = roleDto.getEmployeesDto();
        for (EmployeeDto employeeDtoDetails : employeesDto) {
            Employee employee = new Employee();
            employee.setId(employeeDtoDetails.getId());
            employee.setEmployeeId(employeeDtoDetails.getEmployeeId());
            employee.setEmployeeName(employeeDtoDetails.getEmployeeName());
            employee.setDesignation(employeeDtoDetails.getDesignation());
            employee.setDateOfBirth(employeeDtoDetails.getDateOfBirth());
            employee.setGender(employeeDtoDetails.getGender());
            employee.setEmailId(employeeDtoDetails.getEmailId());
            employee.setPhoneNumber(employeeDtoDetails.getPhoneNumber());
            employee.setDateOfJoining(employeeDtoDetails.getDateOfJoining());
            int experience = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfJoining());
            employee.setExperience(experience);
            int age = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfBirth());
            employee.setAge(age);
            employees.add(employee);
        }
        role.setEmployees(employees);
        return role;
    }

    public static RoleDto roleToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRole(role.getRole());
        List<EmployeeDto> employeesDto = new ArrayList<>();
        List<Employee> employees = role.getEmployees();
        for (Employee employeeDetails : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employeeDetails.getId());
            employeeDto.setEmployeeId(employeeDetails.getEmployeeId());
            employeeDto.setEmployeeName(employeeDetails.getEmployeeName());
            employeeDto.setDesignation(employeeDetails.getDesignation());
            employeeDto.setDateOfBirth(employeeDetails.getDateOfBirth());
            employeeDto.setGender(employeeDetails.getGender());
            employeeDto.setEmailId(employeeDetails.getEmailId());
            employeeDto.setPhoneNumber(employeeDetails.getPhoneNumber());
            employeeDto.setDateOfJoining(employeeDetails.getDateOfJoining());
            int experience = DateUtil.getYearBetweenDate(employeeDetails.getDateOfJoining());
            employeeDto.setExperience(experience);
            int age = DateUtil.getYearBetweenDate(employeeDetails.getDateOfBirth());
            employeeDto.setAge(age);
            employeesDto.add(employeeDto);
        }
        roleDto.setEmployeesDto(employeesDto);
        return roleDto;
    }
}

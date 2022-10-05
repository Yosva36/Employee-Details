package com.ideas2it.companymanagement.resource.helper;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.entity.Employee;
import com.ideas2it.companymanagement.employee.util.DateUtil;
import com.ideas2it.companymanagement.resource.dto.ProjectDto;
import com.ideas2it.companymanagement.resource.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper {

    public static ProjectDto projectToProjectDto(Project project) {
        if (project != null) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(project.getId());
            projectDto.setProjectName(project.getProjectName());
            projectDto.setProjectDescription(project.getProjectDescription());
            Employee employee = project.getEmployee();
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setEmployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            employeeDto.setDesignation(employee.getDesignation());
            employeeDto.setDateOfBirth(employee.getDateOfBirth());
            employeeDto.setGender(employee.getGender());
            employeeDto.setEmailId(employee.getEmailId());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setDateOfJoining(employee.getDateOfJoining());
            int experience = DateUtil.getYearBetweenDate(employee.getDateOfJoining());
            employeeDto.setExperience(experience);
            int age = DateUtil.getYearBetweenDate(employee.getDateOfBirth());
            employeeDto.setAge(age);
            projectDto.setEmployeeDto(employeeDto);
            List<EmployeeDto> employeesDto = new ArrayList<>();
            List<Employee> employees = project.getEmployees();
            for (Employee employeeDetails : employees) {
                employeeDto = new EmployeeDto();
                employeeDto.setId(employeeDetails.getId());
                employeeDto.setEmployeeId(employeeDetails.getEmployeeId());
                employeeDto.setEmployeeName(employeeDetails.getEmployeeName());
                employeeDto.setDesignation(employeeDetails.getDesignation());
                employeeDto.setDateOfBirth(employeeDetails.getDateOfBirth());
                employeeDto.setGender(employeeDetails.getGender());
                employeeDto.setEmailId(employeeDetails.getEmailId());
                employeeDto.setPhoneNumber(employeeDetails.getPhoneNumber());
                employeeDto.setDateOfJoining(employeeDetails.getDateOfJoining());
                experience = DateUtil.getYearBetweenDate(employeeDetails.getDateOfJoining());
                employeeDto.setExperience(experience);
                age = DateUtil.getYearBetweenDate(employeeDetails.getDateOfBirth());
                employeeDto.setAge(age);
                employeesDto.add(employeeDto);
            }
            projectDto.setEmployeesDto(employeesDto);
            return projectDto;
        }
        return null;
    }

    public static Project projectDtoToProject(ProjectDto projectDto) {
        if (projectDto != null) {
            Project project = new Project();
            project.setId(projectDto.getId());
            project.setProjectName(projectDto.getProjectName());
            project.setProjectDescription(projectDto.getProjectDescription());
            EmployeeDto employeeDto = projectDto.getEmployeeDto();
            Employee employee = new Employee();
            employee.setId(employeeDto.getId());
            employee.setEmployeeId(employeeDto.getEmployeeId());
            employee.setEmployeeName(employeeDto.getEmployeeName());
            employee.setDesignation(employeeDto.getDesignation());
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
            employee.setGender(employeeDto.getGender());
            employee.setEmailId(employeeDto.getEmailId());
            employee.setDateOfJoining(employeeDto.getDateOfJoining());
            int experience = DateUtil.getYearBetweenDate(employeeDto.getDateOfJoining());
            employee.setExperience(experience);
            int age = DateUtil.getYearBetweenDate(employeeDto.getDateOfBirth());
            employee.setAge(age);
            project.setEmployee(employee);
            List<Employee> employees = new ArrayList<>();
            List<EmployeeDto> employeesDto = projectDto.getEmployeesDto();
            for (EmployeeDto employeeDtoDetails : employeesDto) {
                employee = new Employee();
                employee.setId(employeeDtoDetails.getId());
                employee.setEmployeeId(employeeDtoDetails.getEmployeeId());
                employee.setEmployeeName(employeeDtoDetails.getEmployeeName());
                employee.setDesignation(employeeDtoDetails.getDesignation());
                employee.setDateOfBirth(employeeDtoDetails.getDateOfBirth());
                employee.setGender(employeeDtoDetails.getGender());
                employee.setEmailId(employeeDtoDetails.getEmailId());
                employee.setPhoneNumber(employeeDtoDetails.getPhoneNumber());
                employee.setDateOfJoining(employeeDtoDetails.getDateOfJoining());
                experience = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfJoining());
                employee.setExperience(experience);
                age = DateUtil.getYearBetweenDate(employeeDtoDetails.getDateOfBirth());
                employee.setAge(age);
                employees.add(employee);
            }
            project.setEmployees(employees);
            return project;
        }
        return null;
    }
}

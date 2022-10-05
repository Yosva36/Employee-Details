package com.ideas2it.companymanagement.employee.service.impl;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.helper.EmployeeHelper;
import com.ideas2it.companymanagement.employee.repository.EmployeeRepository;
import com.ideas2it.companymanagement.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * <p>
     * This method is used to set EmployeeDto objects to Employee.
     * </p>
     */
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        return EmployeeHelper.employeeToEmployeeDto(employeeRepository.save(EmployeeHelper.employeeDtoToEmployee(
                employeeDto)));
    }

    /**
     * <p>
     * This method is used to get all Employee details from database.
     * </p>
     */
    public List<EmployeeDto> getEmployeeDetails() {
        return employeeRepository.findAll().stream().
                map(EmployeeHelper::employeeToEmployeeDto).collect(Collectors.toList());
    }

    /**
     * <p>
     * This method is used to get a Employee details by Id(primary key in database)
     * </p>
     */
    public EmployeeDto getEmployeeDetailsById(int id) {
        return EmployeeHelper.employeeToEmployeeDto(employeeRepository.findById(id).orElse(null));
    }

    /**
     * <p>
     * This method is used to delete a Employee details by Id(primary key in database)
     * </p>
     */
    public boolean deleteEmployeeDetailsById(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * <p>
     * This method is used to update Employee details
     * </p>
     */
    public EmployeeDto updateEmployeeDetails(EmployeeDto employeeDto) {
        return EmployeeHelper.employeeToEmployeeDto(employeeRepository
                .save(EmployeeHelper.employeeDtoToEmployee(employeeDto)));
    }
}

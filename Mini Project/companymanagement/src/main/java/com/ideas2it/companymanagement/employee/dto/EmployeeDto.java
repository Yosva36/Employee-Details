package com.ideas2it.companymanagement.employee.dto;

import com.ideas2it.companymanagement.asset.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.resource.dto.ProjectDto;
import com.ideas2it.companymanagement.seat.dto.SeatDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDto {

    private int id;
    private String employeeId;
    private String employeeName;
    private String gender;
    private LocalDate dateOfBirth;
    private Long phoneNumber;
    private String emailId;
    private String designation;
    private LocalDate dateOfJoining;
    private int experience;
    private int Age;
    private SeatDto seatDto;
    private List<AssetDetailsDto> assetDetailsDtos = new ArrayList<>();
    private ProjectDto projectDto;
    private RoleDto roleDto;

}
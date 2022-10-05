package com.ideas2it.companymanagement.employee.helper;

import com.ideas2it.companymanagement.asset.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.asset.dto.AssetTypeDto;
import com.ideas2it.companymanagement.asset.entity.AssetDetails;
import com.ideas2it.companymanagement.asset.entity.AssetType;
import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.dto.RoleDto;
import com.ideas2it.companymanagement.employee.entity.Employee;
import com.ideas2it.companymanagement.employee.entity.Role;
import com.ideas2it.companymanagement.employee.util.DateUtil;
import com.ideas2it.companymanagement.resource.dto.ProjectDto;
import com.ideas2it.companymanagement.resource.entity.Project;
import com.ideas2it.companymanagement.seat.dto.SeatDto;
import com.ideas2it.companymanagement.seat.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {
    public static Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setGender(employeeDto.getGender());
        employee.setEmailId(employeeDto.getEmailId());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setDateOfJoining(employeeDto.getDateOfJoining());
        int experience = DateUtil.getYearBetweenDate(employeeDto.getDateOfJoining());
        employee.setExperience(experience);
        int age = DateUtil.getYearBetweenDate(employeeDto.getDateOfBirth());
        employee.setAge(age);
        SeatDto seatDto = employeeDto.getSeatDto();
        if (seatDto != null) {
            Seat seat = new Seat();
            seat.setId(seatDto.getId());
            seat.setSeatNumber(seatDto.getSeatNumber());
            employee.setSeat(seat);
        }

        List<AssetDetails> assetDetails = new ArrayList<>();
        List<AssetDetailsDto> assetDetailsDto = employeeDto.getAssetDetailsDtos();
        for (AssetDetailsDto assetDetailDto : assetDetailsDto) {
            AssetDetails assetDetail = new AssetDetails();
            AssetTypeDto assetTypeDto = assetDetailDto.getAssetDto();
            AssetType assetType = new AssetType();
            assetType.setId(assetType.getId());
            assetType.setAssetType(assetTypeDto.getAssetType());
            assetDetail.setAssetType(assetType);
            assetDetail.setId(assetDetailDto.getId());
            assetDetail.setAssetName(assetDetailDto.getAssetName());
            assetDetail.setSerialNumber(assetDetailDto.getSerialNumber());
            assetDetails.add(assetDetail);
        }
        employee.setAssetDetails(assetDetails);

        ProjectDto projectDto = employeeDto.getProjectDto();
        if (projectDto != null) {
            Project project = new Project();
            project.setId(projectDto.getId());
            project.setProjectName(projectDto.getProjectName());
            project.setProjectDescription(projectDto.getProjectDescription());
            employee.setProject(project);
        }

        RoleDto roleDto = employeeDto.getRoleDto();
        if (roleDto != null) {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setRole(roleDto.getRole());
            employee.setRole(role);
        }
        return employee;
    }

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        if (employee != null) {
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
            Seat seat = employee.getSeat();
            SeatDto seatDto = new SeatDto();
            if (seat != null) {
                seatDto.setId(seat.getId());
                seatDto.setSeatNumber(seat.getSeatNumber());
                employeeDto.setSeatDto(seatDto);
            }

            List<AssetDetailsDto> assetDetailsDtos = new ArrayList<>();
            List<AssetDetails> assetDetails = employee.getAssetDetails();
            for (AssetDetails assetDetail : assetDetails) {
                AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
                AssetType assetType = assetDetail.getAssetType();
                AssetTypeDto assetTypeDto = new AssetTypeDto();
                assetTypeDto.setId(assetType.getId());
                assetTypeDto.setAssetType(assetType.getAssetType());
                assetDetailsDto.setAssetDto(assetTypeDto);
                assetDetailsDto.setId(assetDetail.getId());
                assetDetailsDto.setAssetName(assetDetail.getAssetName());
                assetDetailsDto.setSerialNumber(assetDetail.getSerialNumber());
                assetDetailsDtos.add(assetDetailsDto);
            }
            employeeDto.setAssetDetailsDtos(assetDetailsDtos);

            Project project = employee.getProject();
            ProjectDto projectDto = new ProjectDto();
            if (project != null) {
                projectDto.setId(project.getId());
                projectDto.setProjectName(project.getProjectName());
                projectDto.setProjectDescription(project.getProjectDescription());
                employeeDto.setProjectDto(projectDto);
            }

            Role role = employee.getRole();
            RoleDto roleDto = new RoleDto();
            if (role != null) {
                roleDto.setId(role.getId());
                roleDto.setRole(role.getRole());
                employeeDto.setRoleDto(roleDto);
                return employeeDto;
            }
        }
        return null;
    }
}

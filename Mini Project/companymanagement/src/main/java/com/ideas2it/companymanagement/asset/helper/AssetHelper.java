package com.ideas2it.companymanagement.asset.helper;

import com.ideas2it.companymanagement.asset.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.asset.dto.AssetTypeDto;
import com.ideas2it.companymanagement.asset.entity.AssetDetails;
import com.ideas2it.companymanagement.asset.entity.AssetType;
import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.entity.Employee;
import com.ideas2it.companymanagement.employee.util.DateUtil;

public class AssetHelper {

    public static AssetType assetDtoToAsset(AssetTypeDto assetTypeDto) {
        AssetType assetType = new AssetType();
        assetType.setId(assetTypeDto.getId());
        assetType.setAssetType(assetTypeDto.getAssetType());
        assetType.setAssetDetails(assetDetailsDtoToAssetDetails(assetTypeDto.getAssetDetailsDto()));
        AssetDetailsDto assetDetailsDto = assetTypeDto.getAssetDetailsDto();
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setId(assetDetailsDto.getId());
        assetDetails.setAssetName(assetDetailsDto.getAssetName());
        assetDetails.setSerialNumber(assetDetailsDto.getSerialNumber());
        assetType.setAssetDetails(assetDetails);

        return assetType;
    }

    public static AssetTypeDto assetToAssetDto(AssetType assetType) {
        if (assetType != null) {
            AssetTypeDto assetTypeDto = new AssetTypeDto();
            assetTypeDto.setId(assetType.getId());
            assetTypeDto.setAssetType(assetType.getAssetType());
            AssetDetails assetDetails = assetType.getAssetDetails();
            AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
            assetDetailsDto.setId(assetDetails.getId());
            assetDetailsDto.setAssetName(assetDetails.getAssetName());
            assetDetailsDto.setSerialNumber(assetDetails.getSerialNumber());
            assetTypeDto.setAssetDetailsDto(assetDetailsDto);
            return assetTypeDto;
        }
        return null;
    }

    public static AssetDetails assetDetailsDtoToAssetDetails(AssetDetailsDto assetDetailsDto) {
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setId(assetDetailsDto.getId());
        assetDetails.setAssetName(assetDetailsDto.getAssetName());
        assetDetails.setSerialNumber(assetDetailsDto.getSerialNumber());
        AssetTypeDto assetTypeDto = assetDetailsDto.getAssetDto();
        AssetType assetType = new AssetType();
        assetType.setId(assetTypeDto.getId());
        assetType.setAssetType(assetTypeDto.getAssetType());
        assetDetails.setAssetType(assetType);
        EmployeeDto employeeDto = assetDetailsDto.getEmployeeDto();
        Employee employee = new Employee();
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
        assetDetails.setEmployee(employee);
        return assetDetails;
    }

    public static AssetDetailsDto assetDetailsToAssetDetailsDto(AssetDetails assetDetails) {
        if (assetDetails != null) {
            AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
            assetDetailsDto.setId(assetDetails.getId());
            assetDetailsDto.setAssetName(assetDetails.getAssetName());
            assetDetailsDto.setSerialNumber(assetDetails.getSerialNumber());
            AssetType assetType = assetDetails.getAssetType();
            AssetTypeDto assetTypeDto = new AssetTypeDto();
            assetTypeDto.setId(assetType.getId());
            assetTypeDto.setAssetType(assetType.getAssetType());
            assetDetailsDto.setAssetDto(assetTypeDto);
            Employee employee = assetDetails.getEmployee();
            EmployeeDto employeeDto = new EmployeeDto();
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
            assetDetailsDto.setEmployeeDto(employeeDto);
            return assetDetailsDto;
        }
        return null;
    }
}

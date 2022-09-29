package com.ideas2it.companymanagement.assetmanagement.dto;

import lombok.Data;

@Data
public class AssetDetailsDto {

    private String assetName;
    private String serialNumber;
    private AssetDto assetDto;
    private EmployeeDto employeeDto;

}

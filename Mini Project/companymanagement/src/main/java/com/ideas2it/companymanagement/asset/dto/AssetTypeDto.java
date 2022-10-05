package com.ideas2it.companymanagement.asset.dto;

import lombok.Data;

@Data
public class AssetTypeDto {

    private int id;
    private String assetType;
    private AssetDetailsDto assetDetailsDto;

}

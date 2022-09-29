package com.ideas2it.companymanagement.assetmanagement.helper;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDetailsDto;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetDto;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetType;
import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;

public class AssetHelper {

    public static AssetType assetDtoToAsset(AssetDto assetDto) {
        AssetType assetType = new AssetType();
        assetType.setAssetType(assetDto.getAssetType());
        assetType.setAssetDetails(assetDetailsDtoToAssetDetails(assetDto.getAssetDetailsDto()));
        return assetType;
    }

    public static AssetDto assetToAssetDto(AssetType assetType) {
        if (assetType != null) {
            AssetDto assetDto = new AssetDto();
            assetDto.setAssetType(assetType.getAssetType());
            assetDto.setAssetDetailsDto(assetDetailsToAssetDetailsDto(assetType.getAssetDetails()));
            return assetDto;
        }
        return null;
    }

    public static AssetDetails assetDetailsDtoToAssetDetails(AssetDetailsDto assetDetailsDto) {
        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setAssetName(assetDetailsDto.getAssetName());
        assetDetails.setSerialNumber(assetDetailsDto.getSerialNumber());
        assetDetails.setAsset(assetDtoToAsset(assetDetailsDto.getAssetDto()));
        //Need Employee object
        return assetDetails;
    }

    public static AssetDetailsDto assetDetailsToAssetDetailsDto(AssetDetails assetDetails) {
        if (assetDetails != null) {
            AssetDetailsDto assetDetailsDto = new AssetDetailsDto();
            assetDetailsDto.setAssetName(assetDetails.getAssetName());
            assetDetailsDto.setSerialNumber(assetDetails.getSerialNumber());
            assetDetailsDto.setAssetDto(assetToAssetDto(assetDetails.getAsset()));
            //Need Employee object
            return assetDetailsDto;
        }
        return null;
    }
}

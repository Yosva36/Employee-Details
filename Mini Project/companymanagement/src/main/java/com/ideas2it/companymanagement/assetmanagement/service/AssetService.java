package com.ideas2it.companymanagement.assetmanagement.service;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDto;

import java.util.List;

public interface AssetService {

    AssetDto setAsset(AssetDto assetDto);

    AssetDto getAsset(int id);

    boolean deleteAsset(int id);

    AssetDto updateAsset(AssetDto assetDto);

    List<AssetDto> getAllAssetDetails();
}

package com.ideas2it.companymanagement.asset.service;

import com.ideas2it.companymanagement.asset.dto.AssetTypeDto;

import java.util.List;

public interface AssetService {

    AssetTypeDto setAsset(AssetTypeDto assetDto);

    AssetTypeDto getAsset(int id);

    boolean deleteAsset(int id);

    AssetTypeDto updateAsset(AssetTypeDto assetDto);

    List<AssetTypeDto> getAllAssetDetails();
}

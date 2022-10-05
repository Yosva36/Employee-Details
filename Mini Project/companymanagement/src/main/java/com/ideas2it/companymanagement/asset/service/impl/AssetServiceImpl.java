package com.ideas2it.companymanagement.asset.service.impl;

import com.ideas2it.companymanagement.asset.dao.AssetRepo;
import com.ideas2it.companymanagement.asset.dto.AssetTypeDto;
import com.ideas2it.companymanagement.asset.helper.AssetHelper;
import com.ideas2it.companymanagement.asset.service.AssetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepo assetRepo;

    public AssetServiceImpl(AssetRepo assetRepo) {
        this.assetRepo = assetRepo;
    }

    @Override
    public AssetTypeDto setAsset(AssetTypeDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    @Override
    public AssetTypeDto getAsset(int id) {
        return AssetHelper.assetToAssetDto(assetRepo.findById(id).orElse(null));
    }

    @Override
    public boolean deleteAsset(int id) {
        if (assetRepo.existsById(id)) {
            assetRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public AssetTypeDto updateAsset(AssetTypeDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    @Override
    public List<AssetTypeDto> getAllAssetDetails() {
        return assetRepo.findAll().stream().map(AssetHelper::assetToAssetDto).collect(Collectors.toList());
    }

}

package com.ideas2it.companymanagement.assetmanagement.service.impl;

import com.ideas2it.companymanagement.assetmanagement.dao.AssetRepo;
import com.ideas2it.companymanagement.assetmanagement.dto.AssetDto;
import com.ideas2it.companymanagement.assetmanagement.helper.AssetHelper;
import com.ideas2it.companymanagement.assetmanagement.service.AssetService;
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
    public AssetDto setAsset(AssetDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    @Override
    public AssetDto getAsset(int id) {
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
    public AssetDto updateAsset(AssetDto assetDto) {
        return AssetHelper.assetToAssetDto(assetRepo.save(AssetHelper.assetDtoToAsset(assetDto)));
    }

    @Override
    public List<AssetDto> getAllAssetDetails() {
        return assetRepo.findAll().stream().map(AssetHelper::assetToAssetDto).collect(Collectors.toList());
    }

}

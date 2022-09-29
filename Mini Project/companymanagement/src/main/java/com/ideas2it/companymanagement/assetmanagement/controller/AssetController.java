package com.ideas2it.companymanagement.assetmanagement.controller;

import com.ideas2it.companymanagement.assetmanagement.dto.AssetDto;
import com.ideas2it.companymanagement.assetmanagement.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/{assetId}")
    private AssetDto getAsset(@PathVariable("assetId") int id) {
       return assetService.getAsset(id);
    }

    @PostMapping
    private AssetDto insertAsset(AssetDto assetDto) {
        return assetService.setAsset(assetDto);
    }

    @PutMapping
    private AssetDto updateAsset(AssetDto assetDto) {
        return assetService.updateAsset(assetDto);
    }

    @DeleteMapping("/{assetId}")
    private Boolean deleteAsset(@PathVariable("assetId") int id) {
        return assetService.deleteAsset(id);
    }

    @GetMapping
    private List<AssetDto> getAllAssets() {
        return assetService.getAllAssetDetails();
    }
}

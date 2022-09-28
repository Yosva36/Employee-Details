package com.ideas2it.companymanagement.assetmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_type")
    private String assetType;

    @OneToOne(mappedBy = "asset")
    private AssetDetails assetDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public AssetDetails getAssetDetails() {
        return assetDetails;
    }

    public void setAssetDetails(AssetDetails assetDetails) {
        this.assetDetails = assetDetails;
    }
}

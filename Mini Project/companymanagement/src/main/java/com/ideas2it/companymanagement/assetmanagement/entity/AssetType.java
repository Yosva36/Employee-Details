package com.ideas2it.companymanagement.assetmanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "asset")
@Data
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_type")
    private String assetType;

    @OneToOne(mappedBy = "asset")
    private AssetDetails assetDetails;
}


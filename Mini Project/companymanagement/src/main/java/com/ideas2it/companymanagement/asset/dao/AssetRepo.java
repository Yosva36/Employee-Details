package com.ideas2it.companymanagement.asset.dao;

import com.ideas2it.companymanagement.asset.entity.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends JpaRepository<AssetType, Integer> {
}

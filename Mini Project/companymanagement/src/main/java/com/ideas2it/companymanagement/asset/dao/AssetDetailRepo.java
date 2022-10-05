package com.ideas2it.companymanagement.asset.dao;

import com.ideas2it.companymanagement.asset.entity.AssetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailRepo extends JpaRepository<AssetDetails, Integer> {
}

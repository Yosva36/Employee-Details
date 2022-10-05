package com.ideas2it.companymanagement.asset.entity;

import com.ideas2it.companymanagement.employee.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asset_details")
@Setter
@Getter
public class AssetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
    private AssetType assetType;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}

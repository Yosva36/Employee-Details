<<<<<<< HEAD
package com.ideas2it.companymanagement.assetmanagement.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "asset_details")
@Data
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

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
=======
package com.ideas2it.companymanagement.assetmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset_details")
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
    private Asset asset;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
>>>>>>> 68f1181069dde901b873f446f54e5a70192ec8c8

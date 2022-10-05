package com.ideas2it.companymanagement.resource.entity;


import com.ideas2it.companymanagement.employee.entity.Employee;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the project database table.
 */
@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_name")
    private String projectName;

    //bi-directional many-to-one association to EmployeeDetail
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee employee;

    //bi-directional many-to-one association to Resource
    @OneToMany(mappedBy = "project")
    private List<Employee> employees = new ArrayList<Employee>();

}
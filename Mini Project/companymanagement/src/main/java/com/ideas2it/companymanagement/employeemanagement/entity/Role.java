package com.ideas2it.companymanagement.employeemanagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="role_details")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String role;
    @OneToMany(mappedBy="role")
    private List<Employee> employees;
}
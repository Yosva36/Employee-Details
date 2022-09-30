package com.ideas2it.companymanagement.seatmanagement.entity;

import com.ideas2it.companymanagement.employeemanagement.entity.Employee;
import lombok.Data;

import javax.persistence.*;


/**
 * The persistent class for the allocation_details database table.
 */
@Entity
@Table(name = "allocation_details")
@Data
public class Allocation {

    @Id
    private int id;
    @Column(name = "seat_number")
    private String seatNumber;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
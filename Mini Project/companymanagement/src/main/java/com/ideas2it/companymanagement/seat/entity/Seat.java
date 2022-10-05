package com.ideas2it.companymanagement.seat.entity;

import com.ideas2it.companymanagement.employee.entity.Employee;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the allocation_details database table.
 */
@Entity
@Table(name = "allocation_details")
@Data
public class Seat {

    @Id
    private int id;
    @Column(name = "seat_number")
    private String seatNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

}
package com.ideas2it.companymanagement.employeemanagement.entity;

import com.ideas2it.companymanagement.assetmanagement.entity.AssetDetails;
import com.ideas2it.companymanagement.resourcemanagement.entity.Project;
import com.ideas2it.companymanagement.seatmanagement.entity.Allocation;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column
    private String designation;
    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;
    @Column
    private int experience;
    @OneToOne(mappedBy = "employee")
    private Allocation seat;
    @OneToOne(mappedBy = "employee")
    private AssetDetails assetDetails;
    @ManyToMany(mappedBy = "employees")
    @ToString.Exclude
    private List<Project> project = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "role",referencedColumnName = "id")
    private Role role;

}

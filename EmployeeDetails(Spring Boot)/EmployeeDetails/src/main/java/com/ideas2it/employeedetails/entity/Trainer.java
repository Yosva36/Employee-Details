package com.ideas2it.employeedetails.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Trainer entity that has persistent objects
 */
@Entity
@Table (name = "trainer_details")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Trainer implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String trainerId;
    private String name;
    private String gender;

    @Column (name = "birth_date")
    private LocalDate dateOfBirth;

    @Column (name = "blood_group")
    private String bloodGroup;

    @Column (name = "phone_number")
    private long phoneNumber;

    @Column (name = "mail_id")
    private String mailId;

    @Column (name = "date_of_join")
    private LocalDate dateOfJoin;

    @Column (name = "total_projects")
    private int totalProjectsDone;

    @ManyToMany
    @JoinTable(name = "trainee_trainer",
            joinColumns = {@JoinColumn (name = "trainer_id")},
            inverseJoinColumns = { @JoinColumn(name = "trainee_id") })
    //@JsonManagedReference
    private List<Trainee> trainees = new ArrayList<Trainee>();

    public Trainer() {
    }

    public Trainer(String trainerId, String name, String gender,
                   LocalDate dateOfBirth, String bloodGroup, long phoneNumber, String mailId,
                   LocalDate dateOfJoin, int totalProjectsDone) {
        this.trainerId = trainerId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.mailId = mailId;
        this.dateOfJoin = dateOfJoin;
        this.totalProjectsDone = totalProjectsDone;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();          
    }

    public int getTrainingExperience() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfJoin, currentDate).getYears();
    }
    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public int getTotalProjectsDone() {
        return totalProjectsDone;
    }  

    public void setTotalProjectsDone(int totalProjectsDone) {
        this.totalProjectsDone = totalProjectsDone;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }
}


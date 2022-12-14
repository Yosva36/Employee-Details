package com.ideas2it.employeedetails.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Trainee entity holds persistent objects
 */
@Entity
@Table (name = "trainee_details")
public class Trainee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "trainee_id")
    private String traineeId;
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

    @Column (name = "task_completed")
    private String currentTask;

    @ManyToMany(mappedBy="trainees")
    private List<Trainer> trainers = new ArrayList<Trainer>();

    public Trainee(String traineeId, String name, String gender,
                   LocalDate dateOfBirth, String bloodGroup, long phoneNumber,
                   String mailId, String currentTask) {
        this.traineeId = traineeId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.mailId = mailId;
        this.currentTask = currentTask;
    }

    public Trainee() {
    }

    public String getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(String traineeId) {
        this.traineeId = traineeId;
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
    public String getCurrentTask() {
        return currentTask;
    }  

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}
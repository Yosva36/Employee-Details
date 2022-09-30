package com.ideas2it.employeedetails.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *  Deals with trainer dto
 *  to carry objects to the Controller to Service
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TrainerDto implements Serializable {

    private int id;
    private String trainerId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private long phoneNumber;
    private String mailId;
    private LocalDate dateOfJoin;
    private int totalProjectsDone;

    private List<TraineeDto> traineesDto = new ArrayList<TraineeDto>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
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

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();          
    }
    public int getTrainingExperience() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfJoin, currentDate).getYears();
    }

    public int getTotalProjectsDone() {
        return totalProjectsDone;
    }  

    public void setTotalProjectsDone(int totalProjectsDone) {
        this.totalProjectsDone = totalProjectsDone;
    }

    public List<TraineeDto> getTraineesDto() {
        return traineesDto;
    }

    public void setTraineesDto(List<TraineeDto> traineesDto) {
        this.traineesDto = traineesDto;
    }
        
}
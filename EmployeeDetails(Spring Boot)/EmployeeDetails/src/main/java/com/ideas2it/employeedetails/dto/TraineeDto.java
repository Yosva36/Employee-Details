package com.ideas2it.employeedetails.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ideas2it.employeedetails.constants.EmployeeConstants;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 *  Deals with trainee dto
 *  to carry objects to the Controller to Service
 */
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TraineeDto implements Serializable {

    private int id;
    private String traineeId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private long phoneNumber;
    private String mailId;
    private String currentTask;

    private List<TrainerDto> trainersDto = new ArrayList<TrainerDto>();

    public TraineeDto(String traineeId, String name, String gender, LocalDate dateOfBirth,
                      String bloodGroup, long phoneNumber, String mailId, String currentTask) {
        this.traineeId = traineeId;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.mailId = mailId;
        this.currentTask = currentTask;
    }

    public TraineeDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(String traineeId) {
        this.traineeId = traineeId;
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

    public List<TrainerDto> getTrainersDto() {
        return trainersDto;
    }

    public void setTrainersDto(List<TrainerDto> trainersDto) {
        this.trainersDto = trainersDto;
    }

}
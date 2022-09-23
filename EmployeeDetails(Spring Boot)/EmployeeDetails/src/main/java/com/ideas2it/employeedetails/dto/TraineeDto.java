package com.ideas2it.employeedetails.dto;

import com.ideas2it.employeedetails.constants.EmployeeConstants;

import java.time.LocalDate;
import java.time.Period;

/**
 *  Deals with trainee dto
 *  to carry objects to the Controller to Service
 */
public class TraineeDto {

    private int id;
    private String traineeId;
    private String name;
    private String gender;
    private LocalDate dateOfBirth;
    private String bloodGroup;
    private long phoneNumber;
    private String mailId;
    private String currentTask;

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

    public String toString() {
       return ("ID           : " + getTraineeId() + "\n" + "Name         : " + getName()
                + "\n" + "Gender       : " + getGender() + "\n" + "Age          : " 
                + getAge() + "\n" + "Phone Number : " 
                + getPhoneNumber() + "\n" + "Mail ID      : " + getMailId()
                + "\n" + "Blood Group  : " + getBloodGroup() + "\n" 
                + "Current Task : " + getCurrentTask() + "\n" 
                + "Company Name : " + EmployeeConstants.COMPANY_NAME + "\n");
    }
}
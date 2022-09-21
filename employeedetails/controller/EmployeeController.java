package com.ideas2it.employeedetails.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.service.impl.TraineeServiceImpl;
import com.ideas2it.employeedetails.service.impl.TrainerServiceImpl;
import com.ideas2it.employeedetails.util.DateUtil;
import com.ideas2it.employeedetails.util.EmployeeUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Deals with the input output for employee CRUD operations.
 *
 */
public class EmployeeController {

    Logger logger = Logger.getLogger(EmployeeController.class);
    TraineeService traineeService = new TraineeServiceImpl();
    TrainerService trainerService = new TrainerServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String log4jPath = "C:\\Employee Details\\log_properties\\log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        EmployeeController employeeController = new EmployeeController();		
        employeeController.getEmployeeDetails();
    }  
 
    /*
     *
     * Get the employee details for add, delete, update, display operations.
     *
     */    
    private void getEmployeeDetails() {
        boolean isContinue = true;        
        while(isContinue) {
            int choice = 0;
            logger.info("Enter 1 for add employee details");
            logger.info("Enter 2 for display details");
            logger.info("Enter 3 for delete details");
            logger.info("Enter 4 for update details");
            logger.info("Enter 5 for display all details");
            logger.info("Enter 6 to Assign trainee to trainers");
            logger.info("Enter 7 to Assign trainer to trainees");
            logger.info("Enter 8 to Display Associated Trainer with Trainees");
            logger.info("Enter 9 for exit ");
            String userChoice = scanner.nextLine();
            String regex = "[1-9]";
            if(userChoice.matches(regex)) 
                choice = Integer.parseInt(userChoice);

            switch(choice) {
            case 1:
                addEmployeeDetails();
	            break;

            case 2:
                displayEmployeeDetailsById();
                break;

            case 3:
                deleteEmployeeDetailsById();
                break;

            case 4:
                updateEmployeeDetailsById();
                break;

            case 5:
                displayAllEmployeeDetails();
                break;

            case 6:
                associateTraineeToTrainers();
                break;

            case 7:
                associateTrainerToTrainees();
                break;

            case 8:
                displayAssociatedTrainerWithTrainees();
                break;
                
            case 9:
                isContinue = false;
                break;

            default:
                logger.info("Please enter a valid number");
	        }
        }
    }

    /*
     * 
     * This method is used to add Trainee details.
     *
     */     
    private void addTraineeDetails() {
        TraineeDto traineeDto = new TraineeDto();
        
        traineeDto.setTraineeId(EmployeeUtil.generateEmployeeId());
        logger.info("Employee ID : " + traineeDto.getTraineeId());
      
        scanner.nextLine();
        boolean isValidName = false;
        while(!isValidName) {
            logger.info("Enter your Name : ");
            String employeeName = scanner.nextLine();
            boolean isValidNameFormat = EmployeeUtil.isValidName(employeeName);
            if (isValidNameFormat) {
                traineeDto.setName(employeeName.substring(0,1).toUpperCase().concat(employeeName.substring(1)));
                isValidName = true;
            } else {
                logger.error("Please provide valid Name");
            }
        }

        boolean isValidGenderName = false;
        while(!isValidGenderName) {       
            logger.info("Enter your Gender : ");
            String gender = scanner.nextLine();        
            boolean isValidGenderNameFormat = EmployeeUtil.isValidGender(gender);
            if (isValidGenderNameFormat) {
                traineeDto.setGender(gender);
                isValidGenderName = true;
            } else {
                logger.error("Invalid Name");
            }
        } 

        boolean isValidDateOfBirth = false;
        while (!isValidDateOfBirth) {
            logger.info("Enter your date of birth in YYYY-MM-DD format: ");
            String dateOfBirth = scanner.nextLine();
            boolean isValidDate = DateUtil.isValidDate(dateOfBirth);
	        if (isValidDate) {
                LocalDate date = LocalDate.parse(dateOfBirth);
                traineeDto.setDateOfBirth(date);
                isValidDateOfBirth = true;
	        } else {
                logger.info("Please give a valid Date");
	        }
        } 
            
        boolean isValidBloodGroupName = false;
        while(!isValidBloodGroupName) {     
            logger.info("Enter your Blood group : ");
            String bloodGroup = scanner.nextLine();
            boolean isValidBloodGroupNameFormat = EmployeeUtil.isValidBloodGroup(bloodGroup);
            if (isValidBloodGroupNameFormat) {
                traineeDto.setBloodGroup(bloodGroup);
                isValidBloodGroupName = true;
            } else {
                logger.info("Please provide valid Blood Group");
            }
        }
        
	    boolean isValidPhoneNumber = false;
        while(!isValidPhoneNumber) {
            logger.info("Enter your 10 digit Phone Number : ");
            String number = scanner.nextLine();        
            boolean isValidPhoneNumberFormat= EmployeeUtil.isValidPhoneNumber(number);
            if (isValidPhoneNumberFormat) {
                long phoneNumber = Long.parseLong(number);
                traineeDto.setPhoneNumber(phoneNumber);
                isValidPhoneNumber = true;
            } else {
                logger.info("Please provide a valid Phone Number");
            }
        }

        boolean isValidMailId = false;
        while(!isValidMailId) {
            logger.info("Enter your mail Id : ");
            String mailId = scanner.nextLine();        
            boolean isValidMailIdFormat = EmployeeUtil.isValidMailId(mailId);
            if (isValidMailIdFormat) {
                traineeDto.setMailId(mailId);
                isValidMailId = true;
            } else {
                logger.info("Please provide a valid email Id");
            }
        }
    
        boolean isValidTaskName = false;
        while(!isValidTaskName) {
            logger.info("Enter your Current Task : ");
            String currentTask = scanner.nextLine();
            if (currentTask.matches("[a-zA-Z ]*")) {
                traineeDto.setCurrentTask(currentTask);
	             isValidTaskName = true;
            } else {
                logger.info("Please provide a valid details");
            }
        }
        traineeService.setTrainee(traineeDto);
    }

    /**
     * 
     * This method is used to add trainer details.
     *
     */     
    private void addTrainerDetails() {

        TrainerDto trainerDto = new TrainerDto();
        
        trainerDto.setTrainerId(EmployeeUtil.generateEmployeeId());
        System.out.println("Employee ID : " + trainerDto.getTrainerId());
      
        scanner.nextLine();
        boolean isValidName = false;
        while(!isValidName) {
            logger.info("Enter your Name : ");
            String employeeName = scanner.nextLine();
            boolean isValidNameFormat = EmployeeUtil.isValidName(employeeName);
            if (isValidNameFormat) {
                trainerDto.setName(employeeName);
                isValidName = true;
            } else {
                logger.info("Please provide valid Name");
            }
        }

        boolean isValidGenderName = false;
        while(!isValidGenderName) {       
            logger.info("Enter your Gender : ");
            String gender = scanner.nextLine();        
            boolean isValidGenderNameFormat = EmployeeUtil.isValidGender(gender);
            if (isValidGenderNameFormat) {
                trainerDto.setGender(gender);
                isValidGenderName = true;
            } else {
                logger.info("Invalid Name");
            }
        }
    
        boolean isValidDateOfBirth = false;
        while (!isValidDateOfBirth) {
            logger.info("Enter your date of birth in YYYY-MM-DD format: ");
            String dateOfBirth = scanner.nextLine();
            boolean isValidDate = DateUtil.isValidDate(dateOfBirth);
	        if (isValidDate) {
                LocalDate date = LocalDate.parse(dateOfBirth);
		        trainerDto.setDateOfBirth(date);
		        isValidDateOfBirth = true;
	        } else {
            logger.info("Please Give a Valid Date");
	        }
        }
        
        boolean isValidBloodGroup = false;
        while(!isValidBloodGroup) {     
            logger.info("Enter your Blood group : ");
            String bloodGroup = scanner.nextLine();
            boolean isValidBloodGroupName = EmployeeUtil.isValidBloodGroup(bloodGroup);
            if (isValidBloodGroupName) {
                trainerDto.setBloodGroup(bloodGroup);
                isValidBloodGroup = true;
            } else {
                logger.info("Please provide valid Blood Group");
            }
        }

	    boolean isValidPhoneNumber = false;
        while(!isValidPhoneNumber) {
            logger.info("Enter your 10 digit Phone Number : ");
            String number = scanner.nextLine();        
            boolean isValidPhoneNumberFormat = EmployeeUtil.isValidPhoneNumber(number);
            if (isValidPhoneNumberFormat) {
                long phoneNumber = Long.parseLong(number);
                trainerDto.setPhoneNumber(phoneNumber);
	            isValidPhoneNumber = true;
            } else {
                logger.info("Please provide a valid Phone Number");
            }
        }

        boolean isValidMailId = false;
        while(!isValidMailId) {
            logger.info("Enter your mail Id : ");
            String mailId = scanner.nextLine();        
            boolean isValidMailIdFormat = EmployeeUtil.isValidMailId(mailId);
            if (isValidMailIdFormat) {
                trainerDto.setMailId(mailId);
	            isValidMailId = true;
            } else {
                logger.error("Please provide a valid email Id");
            }
        }

        boolean isValidDateOfJoin = false;
        while (!isValidDateOfJoin) {
            logger.info("Enter your date of join in YYYY-MM-DD format: ");
            String dateOfJoin = scanner.nextLine();
            boolean isValidDate = DateUtil.isValidDate(dateOfJoin);
            if (isValidDate) {
                LocalDate date = LocalDate.parse(dateOfJoin);
                trainerDto.setDateOfJoin(date);
                isValidDateOfJoin = true;
            } else {
                logger.info("Please give a valid Date");
            }
        }
        
        boolean isValidTotalProjectsDone = false;
        while(!isValidTotalProjectsDone) {
            logger.info("Enter how many projects are you Done : ");
            String projectsDone = scanner.nextLine();
            if(projectsDone.matches("[0-9]{1,2}")) {
                int totalProjectsDone = Integer.parseInt(projectsDone);
                trainerDto.setTotalProjectsDone(totalProjectsDone);
                isValidTotalProjectsDone = true;
            } else {
                logger.info("Please Provide valid Details");
            }
        }
        trainerService.setTrainer(trainerDto);
    }

    /**
     * 
     * This method is used to update all employee details.
     *
     */
    private void updateEmployeeDetailsById() {
        boolean isContinueToUpdate = true;
        while (isContinueToUpdate) {
            logger.info("Press 0 for update Trainer details\nPress 1 for update Trainee details\nPress 2 to HomeScreen");
            int choiceMadeToUpdate = scanner.nextInt();
            scanner.nextLine();
            if (choiceMadeToUpdate == 0) {
            	updateTrainerDetailsById();
            }
            else if (choiceMadeToUpdate == 1) {
            	updateTraineeDetailsById();
	        }
            else if(choiceMadeToUpdate == 2) {
	            isContinueToUpdate = false;
	        }
            else {
                logger.info("Kindly enter value in the mentioned format!");
	        }
        }
    }      

    /**
     * 
     * This method is used to add trainee or trainer details as per choice.
     *
     */  
    private void addEmployeeDetails() {
        logger.info("Enter 1 for add Trainee\nEnter 2 for add Trainer");
        int add = scanner.nextInt();
        switch(add) {
        case 1:
            addTraineeDetails();
            break;

        case 2:
            addTrainerDetails();
            break;

        default:
            logger.info("Invalid selection");
        }
    }

    /**
     * 
     * This method is used to display trainee ot trainer details 
     * by employee Id.
     *
     */  
    private void displayEmployeeDetailsById() {
        logger.info("Enter 1 for display Trainee\nEnter 2 for display Trainer");
        int display = scanner.nextInt();
        switch (display) {
        case 1:
            logger.info("Enter Employee Id : ");
            String traineeId = scanner.next();
            TraineeDto traineeDto = traineeService.getTraineeById(traineeId);
            if (traineeDto == null) {
                logger.info("No Record Found at this Id");
            } else {
                logger.info(traineeDto);
                scanner.nextLine();
            }
            break;

        case 2:
            System.out.print("Enter Employee Id : ");
            String trainerId = scanner.next();
            TrainerDto trainerDto = trainerService.getTrainerById(trainerId);
            if (trainerDto == null) {
                logger.info("No Record Found at this Id");
            } else {
                logger.info(trainerDto);
            }
            break;

        default:
            logger.info("Invalid selection");
        }
    }

    /**
     * 
     * This method is used to delete trainee or trainer details
     * by employee Id.
     *
     */  
    private void deleteEmployeeDetailsById() {
        System.out.println("Enter 1 for delete Trainee Details\nEnter 2 for delete Trainer Details");
        int delete = scanner.nextInt();
        switch(delete) {
        case 1:
            logger.info("Enter Employee Id : ");
            String deleteTraineeId = scanner.next();
            boolean toDeleteTrainee = traineeService.deleteTraineeDetailsById(deleteTraineeId);
            if(toDeleteTrainee) {
                System.out.println("trainee details are deleted");
                scanner.nextLine();
	        } else {
                logger.info("Details not found please check EmployeeId");
            }
            break;

        case 2:
            logger.info("Enter Employee Id for Trainer: ");
            String deleteTrainerId = scanner.next();
            boolean toDeleteTrainer = trainerService.deleteTrainerDetailsById(deleteTrainerId);
            if(toDeleteTrainer) {
                logger.info("Trainer details are deleted");
                scanner.nextLine();
	        }
            else {
                logger.info("Details not found please check EmployeeId");
                scanner.nextLine();
            }
            break;

        default:
            logger.info("Invalid selection");
        }
    }
 
    /**
     * 
     * This method is used to display all trainee details.
     *
     */          
    private  void displayAllTraineeDetails() throws EmployeeRuntimeException {
        if (traineeService.getTrainee().size() == 0) {
            throw new EmployeeRuntimeException("No Trainee Details Found.");
        } else {
            for (TraineeDto traineeDto : traineeService.getTrainee()) {
                logger.info(traineeDto);
            }
        } 
    }
 
    /**
     * 
     * This method is used to display all trainer details.
     *
     */ 
    private  void displayAllTrainerDetails() throws EmployeeRuntimeException {
        if (trainerService.getTrainer().size() == 0) {
            throw new EmployeeRuntimeException("No Trainer Details Found");
        } else {
            for (TrainerDto trainerDto : trainerService.getTrainer()) {
                logger.info(trainerDto);
            }
        }   
    }

    /**
     * 
     * This method is used to update all trainee details.
     *
     */ 
    private void updateTraineeDetailsById() {
        boolean isContinueToEditTrainee = true;
        HashMap<String, String> traineeMap= new HashMap<String, String>();
        logger.info("Enter the Trainee Id to Continue");
        String toSearchId = scanner.next();
        while (isContinueToEditTrainee) { 
            logger.info("What do you want to update? \n\t**Alert**\nDon't leave any spaces between words");
            String toUpdateKey = scanner.next();
            logger.info("Give the new " + toUpdateKey + " to update");
            String toUpdateValue = scanner.next();
            traineeMap.put(toUpdateKey, toUpdateValue);
            logger.info("Do you want to update another field on this Id\nPress 0 to add  Press 1 to update the given fields");
            int toContinue = scanner.nextInt();
            if (toContinue == 1) {
                isContinueToEditTrainee = false;
            }
        }
        if (traineeService.updateTrainee(toSearchId,traineeMap)) {
            logger.info("Sucessfully Updated");
        }
        else {
            logger.error("It doen't match some of the fields and format, Sorry! but it's okay, Let's try again ");
        } 
    }

    /**
     * 
     * This method is used to update all trainer details.
     *
     */ 
    private void updateTrainerDetailsById() {        
        boolean isContinueToEditTrainer = true;
        HashMap<String, String> trainerMap= new HashMap<String, String>();
        logger.info("Enter the Trainer Id to Continue");
        String toSearchId = scanner.next();
        while(isContinueToEditTrainer) { 
            logger.info("What do you want to update? \n\t**Alert**\nDon't leave any spaces between words");
            String toUpdateKey = scanner.next();
            logger.info("Give the new " + toUpdateKey + " to update");
            String toUpdateValue = scanner.next();
            trainerMap.put(toUpdateKey, toUpdateValue);
            logger.info("Do you want to update another field on this Id\nPress 0 to add  Press 1 to update the given fields");
            int toContinue = scanner.nextInt();
            if (toContinue == 1) {
                isContinueToEditTrainer = false;
            }
        }
        if (trainerService.updateTrainer(toSearchId, trainerMap)) {
            logger.info("Successfully Updated");
        }
        else {
            logger.error("It doesn't match some of the fields, Sorry! but it's okay, try again you might get it next time");
        }      
    }

    /**
     * 
     * This method is used to display all employee details.
     *
     */ 
    private void displayAllEmployeeDetails() {
        logger.info("Enter 1 for display Trainee\nEnter 2 for display Trainer");
        int add = scanner.nextInt();
        switch(add) {
        case 1:
            try {
                displayAllTraineeDetails();
            } catch (EmployeeRuntimeException employeeRuntimeException) {
                logger.error("No Details Found",employeeRuntimeException);
            }
            break;

        case 2:
            displayAllTrainerDetails();
            break;

        default:
            logger.info("Invalid selection");
        }
    }

    /**
     * This method is used to Associate trainee to trainers.
     */ 
    private void associateTraineeToTrainers() {
        logger.info("Enter trainee id");
        String traineeId = scanner.nextLine();
        logger.info("Enter trainer ids");
        String trainerIds = scanner.nextLine();
        List<String>  trainers = Arrays.asList(trainerIds.split(","));
        traineeService.associateTraineeToTrainers(traineeId, trainers);
    }

    /**
     * This method is used to Associate trainer to trainees.
     */
    private void associateTrainerToTrainees() {
        logger.info("Enter trainer id");
        String trainerId = scanner.nextLine();
        logger.info("Enter trainee ids");
        String traineeIds = scanner.nextLine();
        List<String>  trainees = Arrays.asList(traineeIds.split(","));
        trainerService.associateTrainerToTrainees(trainerId, trainees);
    }

    /**
     * This method is about to display associated trainer with trainees
     */
    private void displayAssociatedTrainerWithTrainees() {
        System.out.println("enter trainer id");
        String id = scanner.nextLine();
        TrainerDto trainerDto = trainerService.getTrainerById(id);
        if (trainerDto != null) {
            logger.info(trainerDto.toString() + trainerDto.getTraineesDto());
        } else {
            logger.info("Trainee Details not found");
        }
    }
}
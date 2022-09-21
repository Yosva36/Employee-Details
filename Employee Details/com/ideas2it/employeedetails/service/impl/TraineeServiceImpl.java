package com.ideas2it.employeedetails.service.impl;

import java.util.List;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dao.TraineeDao;
import com.ideas2it.employeedetails.dao.impl.TraineeDaoImpl;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.util.DateUtil;
import com.ideas2it.employeedetails.util.EmployeeUtil;

/**
 *
 */
public class TraineeServiceImpl implements TraineeService {

    TraineeDao traineeDao = new TraineeDaoImpl();

    /**
     * 
     * This method is used to set traineeDto objects to trainee.
     *
     * @param traineeDto
     *
     */     
    public void setTrainee(TraineeDto traineeDto) {
        traineeDao.insertTrainee(EmployeeHelper.traineeDtoToTrainee(traineeDto));
    }
  
    /**
     * 
     * This method is used to get all trainee details from database.
     *
     * @return List<TraineeDto>
     */ 
    public List<TraineeDto> getTrainee() {
        return traineeDao.retrieveTrainees().stream().
        map(trainee -> {return EmployeeHelper.traineeToTraineeDto(trainee);}).collect(Collectors.toList());
    }

    /**
     * 
     * This method is used to get a trainee details by Id.
     *
     * @return traineeDto
     */    
    public TraineeDto getTraineeById(String employeeId) {
        Trainee trainee = traineeDao.searchTrainee(employeeId);
        TraineeDto traineeDto = EmployeeHelper.traineeToTraineeDto(trainee);
        traineeDto.setTrainersDto(EmployeeHelper.convertTrainerList(trainee.getTrainers()));
        if (trainee != null) { 
            return traineeDto;
        } 
        return null;        
    }

    /**
     * 
     * This method is used to delete a trainee details by Id.
     *
     * @param employeeId
     *
     * @return boolean
     */ 
    public boolean deleteTraineeDetailsById(String employeeId) {
        for (Trainee trainee : traineeDao.retrieveTrainees()) {
            if (employeeId.equals(trainee.getId())) {
                return traineeDao.deleteTrainee(trainee);
            }
        }
        return false;
    }

    /**
     * 
     * This method is used to update trainee details by id.
     *
     * @param employeeId, traineeDto, HashMap<String, String> toUpdate
     *
     * @return boolean
     */ 
    public boolean updateTrainee(String employeeId, HashMap<String, String> traineeMap) {
        Trainee trainee = traineeDao.searchTrainee(employeeId);
        int count = 0;         
	    if (traineeMap.containsKey("name") && EmployeeUtil.isValidName(traineeMap.get("name"))) {
	        trainee.setName(traineeMap.get("name"));
            count++;
        }
	    if (traineeMap.containsKey("dateofbirth") && DateUtil.isValidDate(traineeMap.get("dateofbirth"))) {
            LocalDate date = LocalDate.parse(traineeMap.get("dateofbirth"));
            trainee.setDateOfBirth(date);
            count++;           
        } 
	    if (traineeMap.containsKey("phonenumber") && EmployeeUtil.isValidPhoneNumber(traineeMap.get("phonenumber"))) {
            long phoneNumber = Long.parseLong(traineeMap.get("phonenumber"));
	        trainee.setPhoneNumber(phoneNumber);
            count++;	        
	    }
	    if (traineeMap.containsKey("mailid") && EmployeeUtil.isValidMailId(traineeMap.get("mailid"))) {
	        trainee.setMailId(traineeMap.get("mailid"));
            count++;
	    }
        traineeDao.updateTrainee(trainee);
        return count == traineeMap.size();
    }

    /**
     * This method is used to give Trainer to TraineeService
     *
     * @param employeeId
     * @return
     */
    public Trainee getTraineeForTrainerService(String employeeId) {
        Trainee trainee = null;
        trainee= traineeDao.searchTrainee(employeeId);
        if (trainee != null) {
            return trainee;
        }
        return trainee;
    }

    /**
     * This method is used to associate trainee to Trainers
     * @param traineeId
     * @param trainerIds
     */
    public void associateTraineeToTrainers(String traineeId, List<String> trainerIds) {
        TrainerService trainerService = new TrainerServiceImpl();
        Trainee trainee = traineeDao.searchTrainee(traineeId);
        if (trainee != null) {
            List<Trainer> trainers = new ArrayList<Trainer>();
            for (String id : trainerIds) {
                Trainer trainer = new Trainer();
                trainer = trainerService.getTrainerForTraineeService(id);
                if (trainer != null) {
                    trainers.add(trainer);
                }
            }
            trainee.setTrainers(trainers);
            traineeDao.updateTrainee(trainee);
        }
    }
}    

    


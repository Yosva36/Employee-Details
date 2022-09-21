package com.ideas2it.employeedetails.service.impl;

import java.util.List;
import java.util.stream.Collectors; 
import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.dao.TrainerDao;
import com.ideas2it.employeedetails.dao.impl.TrainerDaoImpl;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.util.DateUtil;
import com.ideas2it.employeedetails.util.EmployeeUtil;

/**
 * Deals with the trainee business logics.
 *
 */
public class TrainerServiceImpl implements TrainerService {

    TrainerDao trainerDao = new TrainerDaoImpl();

    /**
     * 
     * This method is used to set trainerDto objects to trainee.
     * 
     * @param trainerDto
     *
     */  
    public void setTrainer(TrainerDto trainerDto) {
        trainerDao.insertTrainer(EmployeeHelper.trainerDtoToTrainer(trainerDto));
    }

    /**
     * 
     * This method is used to get all trainer details from database.
     *
     * @return List<TrainerDto>
     */ 
    public List<TrainerDto> getTrainer() {
        return trainerDao.retrieveTrainers().stream().
        map(trainer -> {return EmployeeHelper.trainerToTrainerDto(trainer);}).collect(Collectors.toList());
    }

    /**
     * 
     * This method is used to get a trainee details by Id.
     *
     * @return trainerDto
     */    
    public TrainerDto getTrainerById(String employeeId) {      
        Trainer trainer= trainerDao.searchTrainer(employeeId);
        TrainerDto trainerDto = EmployeeHelper.trainerToTrainerDto(trainer);
        trainerDto.setTraineesDto(EmployeeHelper.convertTraineeList(trainer.getTrainees()));
        if (trainer != null) {
            return trainerDto;
        }
        return null;    
    }

    /**
     * 
     * This method is used to delete a trainer details by Id.
     *
     * @param employeeId
     *
     * @return boolean
     */
    public boolean deleteTrainerDetailsById(String employeeId) {
        for (Trainer trainer : trainerDao.retrieveTrainers()) {
            if (employeeId.equals(trainer.getId())) {    
                return trainerDao.deleteTrainer(trainer);
            }
        }
        return false;
    }

     /**
     * This method is used to update trainer details by id.
     * @param employeeId
     * @param HashMap<String,String> trainerMap
     * @return boolean
     */ 
    public boolean updateTrainer(String employeeId, HashMap<String,String> trainerMap) {
        Trainer trainer = trainerDao.searchTrainer(employeeId);
        int count = 0;
	    if (trainerMap.containsKey("name") && EmployeeUtil.isValidName(trainerMap.get("name"))) {
	        trainer.setName(trainerMap.get("name"));
            count++;
	    }
	    if (trainerMap.containsKey("dateofbirth") && DateUtil.isValidDate(trainerMap.get("dateofbirth"))) {
            LocalDate date = LocalDate.parse(trainerMap.get("dateofbirth"));
            trainer.setDateOfBirth(date);
            count++;
        }
	    if (trainerMap.containsKey("phonenumber") && EmployeeUtil.isValidPhoneNumber(trainerMap.get("phonenumber"))) {
            long phoneNumber = Long.parseLong(trainerMap.get("phonenumber"));
            trainer.setPhoneNumber(phoneNumber);
            count++;
	    }
	    if (trainerMap.containsKey("mailid") && EmployeeUtil.isValidMailId(trainerMap.get("mailid"))) {
	        trainer.setMailId(trainerMap.get("mailid"));
            count++;
	    }
        trainerDao.updateTrainer(trainer);
        return count == trainerMap.size();
    }

    /**
     * This method is used to give Trainee to TrainerService
     * @param employeeId
     * @return
     */
    public Trainer getTrainerForTraineeService(String employeeId) {
         Trainer trainer= trainerDao.searchTrainer(employeeId);
        if (trainer != null) {
            return trainer;
        }
        return trainer;
    }

    /**
     * This method is used to associate trainer to trainees
     * @param trainerId
     * @param traineeIds
     */
    public void associateTrainerToTrainees(String trainerId, List<String> traineeIds) {
        TraineeService traineeService = new TraineeServiceImpl();
        Trainer trainer = trainerDao.searchTrainer(trainerId);
        if (trainer != null) {
            List<Trainee> trainees = new ArrayList<Trainee>();
            for (String ids : traineeIds) {
                Trainee trainee = traineeService.getTraineeForTrainerService(ids);
                if (trainee != null) {
                    trainees.add(trainee);
                }
            }
            trainer.setTrainees(trainees);
            trainerDao.updateTrainer(trainer);
        }
    }
   
}

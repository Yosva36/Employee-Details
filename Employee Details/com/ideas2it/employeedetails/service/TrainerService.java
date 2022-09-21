package com.ideas2it.employeedetails.service;

import java.util.List;
import java.util.HashMap;  

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;

/**
 * Deals with the trainer business logics.
 *
 */
public interface TrainerService {

    void setTrainer(TrainerDto trainerDto);

    List<TrainerDto> getTrainer();

    TrainerDto getTrainerById(String employeeId);
    
    boolean deleteTrainerDetailsById(String employeeId);

    boolean updateTrainer(String employeeId, HashMap<String, String> trainerMap);

    Trainer getTrainerForTraineeService(String employeeId);

    void associateTrainerToTrainees(String trainerId, List<String> traineeIds);
}
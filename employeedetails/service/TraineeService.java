package com.ideas2it.employeedetails.service;

import java.util.List;  
import java.util.HashMap;
import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.entity.Trainee;

/**
 * Deals with the trainee business logics.
 *
 */
public interface TraineeService {

    void setTrainee(TraineeDto traineeDto);

    List<TraineeDto> getTrainee();

    TraineeDto getTraineeById(String employeeId);

    boolean deleteTraineeDetailsById(String employeeId);
    
    boolean updateTrainee(String employeeId,HashMap<String, String> traineeMap);

    Trainee getTraineeForTrainerService(String employeeId);

    void associateTraineeToTrainers(String traineeId, List<String> trainerIds);
}
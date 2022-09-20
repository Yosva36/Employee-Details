package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TraineeDto;

import java.util.List;

/**
 * Deals with the trainee business logics.
 *
 **/
public interface TraineeService {

    TraineeDto setTrainee(TraineeDto traineeDto);

    List<TraineeDto> getTrainees();

    TraineeDto getTraineeById(int id);

    void deleteTrainee(int id);
    
    TraineeDto updateTrainee(TraineeDto traineeDto);

   // void associateTrainee(String traineeId, List<String> trainerIds);
}
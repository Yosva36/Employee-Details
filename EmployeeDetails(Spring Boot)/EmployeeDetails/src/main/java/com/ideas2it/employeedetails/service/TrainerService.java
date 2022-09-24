package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.entity.Trainer;

import java.util.List;

/**
 * Deals with the trainer business logics.
 */
public interface TrainerService {

    TrainerDto setTrainer(TrainerDto traineeDto);

    List<TrainerDto> getTrainers();

    TrainerDto getTrainerById(int id);

    void deleteTrainer(int id);

    TrainerDto updateTrainer(TrainerDto trainerDto);

    void associateTrainerToTrainees(int trainerId, int traineeId);
}

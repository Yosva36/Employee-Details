package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.entity.Trainer;

import java.util.List;

/**
 * Deals with the trainer business logics.
 */
public interface TrainerService {

    TrainerDto setTrainer(TrainerDto traineeDto);

    List<Trainer> getTrainers();

    Trainer getTrainerById(int id);

    void deleteTrainer(int id);

    TrainerDto updateTrainer(TrainerDto trainerDto);

    Trainer getTrainerForAssociation(int id);

    TrainerDto associateTrainerToTrainees(int trainerId, int traineeId);
}

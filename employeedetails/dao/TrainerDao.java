package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainer;

import java.util.List;

/**
 * Deals with employee database and related operations.
 */
public interface TrainerDao {

    void insertTrainer(Trainer trainer);
 
    List<Trainer> retrieveTrainers();

    boolean deleteTrainer(Trainer trainer);

    Trainer searchTrainer(String trainerId);

    void updateTrainer(Trainer trainer);
}


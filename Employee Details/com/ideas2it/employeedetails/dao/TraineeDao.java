package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainee;

import java.util.List;

/**
 * Deals with employee database and related operations.
 */
public interface TraineeDao{

    void insertTrainee(Trainee trainee);

    List<Trainee> retrieveTrainees();

    boolean deleteTrainee(Trainee trainee);

    Trainee searchTrainee(String employeeId);

    void updateTrainee(Trainee trainee);
}
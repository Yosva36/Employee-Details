package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TraineeDao that uses JpaRepository methods for data manipulation.
 */
public interface TraineeRepo extends JpaRepository<Trainee,Integer> {
}

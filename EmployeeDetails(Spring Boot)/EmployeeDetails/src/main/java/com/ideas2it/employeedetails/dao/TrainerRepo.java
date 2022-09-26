package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrainerDao that uses JpaRepository methods for data manipulation.
 */
public interface TrainerRepo extends JpaRepository<Trainer,Integer> {
}

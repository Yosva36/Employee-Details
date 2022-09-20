package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraineeDao extends JpaRepository<Trainee,Integer> {
}

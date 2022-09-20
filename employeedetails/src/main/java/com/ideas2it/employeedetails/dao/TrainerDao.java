package com.ideas2it.employeedetails.dao;

import com.ideas2it.employeedetails.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerDao extends JpaRepository<Trainer,Integer> {
}

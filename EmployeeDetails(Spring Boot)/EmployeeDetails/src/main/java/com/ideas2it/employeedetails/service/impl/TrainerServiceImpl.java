package com.ideas2it.employeedetails.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.dao.TrainerDao;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * Deals with the trainee business logics.
 *
 **/
@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerDao trainerDao;

    /**
     * This method is used to set trainerDto objects to trainee.
     * @param trainerDto
     */
    public TrainerDto setTrainer(TrainerDto trainerDto) {
        return EmployeeHelper.trainerToTrainerDto(trainerDao.save(EmployeeHelper.trainerDtoToTrainer(trainerDto)));
    }

    /**
     * This method is used to get all trainer details from database.
     * @return List<TrainerDto>
     */
    public List<TrainerDto> getTrainers() {
        return trainerDao.findAll().stream().map(EmployeeHelper::trainerToTrainerDto).collect(Collectors.toList());
    }

    /**
     * This method is used to get a trainee details by id.
     * @return trainerDto
     */
    public TrainerDto getTrainerById(int id) {
        Optional<Trainer> trainer= trainerDao.findById(id);
        TrainerDto trainerDto = null;
        if (trainer.isPresent()) {
            trainerDto = EmployeeHelper.trainerToTrainerDto(trainer.get());
        }
        return null;
    }

    /**
     * This method is used to delete a trainer details by id.
     * @param id
     * @return boolean
     */
    public void deleteTrainer(int id) throws EmptyResultDataAccessException {
        trainerDao.deleteById(id);
    }

    /**
     * This method is used to update trainer details by id.
     * @param trainerDto
     */
    public TrainerDto updateTrainer(TrainerDto trainerDto) {
        return EmployeeHelper.trainerToTrainerDto(trainerDao.save(EmployeeHelper.trainerDtoToTrainer(trainerDto)));
    }
}


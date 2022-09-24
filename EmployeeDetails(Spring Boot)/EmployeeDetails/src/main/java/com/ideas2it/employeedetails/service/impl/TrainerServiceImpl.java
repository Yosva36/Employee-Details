package com.ideas2it.employeedetails.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.dao.TrainerDao;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 * Deals with the trainee business logics.
 *
 */
@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerDao trainerDao;

    private final TraineeService traineeService;

    @Autowired
    public TrainerServiceImpl(TrainerDao trainerDao, TraineeService traineeService) {
        this.trainerDao = trainerDao;
        this.traineeService = traineeService;
    }



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
        Optional<Trainer> trainer = trainerDao.findById(id);
        TrainerDto trainerDto = null;
        if (trainer.isPresent()) {
            Trainer presentTrainer = trainer.get();
            trainerDto = EmployeeHelper.trainerToTrainerDto(presentTrainer);
            trainerDto.setTraineesDto(EmployeeHelper.convertTraineeList(presentTrainer.getTrainees()));
            return trainerDto;
        }
        return trainerDto;
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

    @Override
    public void associateTrainerToTrainees(int trainerId, int traineeId) {
        Trainer trainer = trainerDao.findById(trainerId).get();
        List<Trainee> trainees = new ArrayList<>();
        if (trainer != null) {
            Trainee trainee = new Trainee();
            trainee = traineeService.getTraineeForTrainerService(traineeId);
            if (trainee != null) {
                trainees.add(trainee);
            }
        }
        trainer.setTrainees(trainees);
        trainerDao.save(trainer);
    }
}


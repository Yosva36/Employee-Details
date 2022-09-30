package com.ideas2it.employeedetails.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.dao.TrainerRepo;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Deals with the trainee business logics.
 *
 */
@Service
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepo trainerDao;

    private final TraineeService traineeService;

    @Autowired
    public TrainerServiceImpl(TrainerRepo trainerDao, TraineeService traineeService) {
        this.trainerDao = trainerDao;
        this.traineeService = traineeService;
    }

    /**
     * This method is used to set trainerDto objects to trainee.
     * @param trainerDto
     */
    @Override
    public TrainerDto setTrainer(TrainerDto trainerDto) {
        return EmployeeHelper.trainerToTrainerDto(trainerDao.save(EmployeeHelper.trainerDtoToTrainer(trainerDto)));
    }

    /**
     * This method is used to get all trainer details from database.
     * @return List<TrainerDto>
     */
    @Override
    public List<Trainer> getTrainers() {
        return trainerDao.findAll();
        //return trainerDao.findAll().stream().map(EmployeeHelper::trainerToTrainerDto).collect(Collectors.toList());
    }

    /**
     * This method is used to get a trainee details by id.
     *
     * @return trainerDto
     */
    @Override
    public Trainer getTrainerById(int id) {
        Optional<Trainer> trainerResult = trainerDao.findById(id);
        TrainerDto trainerDto = null;
        if (trainerResult.isPresent()) {
            Trainer trainer = trainerResult.get();
            trainerDto = EmployeeHelper.trainerToTrainerDto(trainer);
         /*   if(trainerDto != null && trainer.getTrainees() != null && !trainer.getTrainees().isEmpty()) {
                trainerDto.getTraineesDto().addAll(trainer.getTrainees().stream().map(EmployeeHelper::traineeToTraineeDto).collect(Collectors.toList()));
            }*/
        }
        return trainerResult.get();
    }

    /**
     * This method is used to delete a trainer details by id.
     * @param id
     */
    @Override
    public void deleteTrainer(int id) {
            trainerDao.deleteById(id);
    }

    /**
     * This method is used to update trainer details by id.
     * @param trainerDto
     */
    @Override
    public TrainerDto updateTrainer(TrainerDto trainerDto) {
        return EmployeeHelper.trainerToTrainerDto(trainerDao.save(EmployeeHelper.trainerDtoToTrainer(trainerDto)));
    }

    /**
     * Get trainer to TraineeService for Association
     * @param id
     * @return trainer
     */
    @Override
    public Trainer getTrainerForAssociation(int id) {
        Optional<Trainer> trainer = trainerDao.findById(id);
        return trainer.orElse(null);
    }

    /**
     * Associate trainer to trainee
     * @param trainerId
     * @param traineeId
     * @return traineeDto
     */
    @Override
    public TrainerDto associateTrainerToTrainees(int trainerId, int traineeId) {
        Optional<Trainer> trainer = trainerDao.findById(trainerId);
        Trainer presentTrainer;
        if (trainer.isPresent()) {
            presentTrainer = trainer.get();
            List<Trainee> trainees = presentTrainer.getTrainees();
            Trainee trainee = traineeService.getTraineeForAssociation(traineeId);
            if (trainee != null) {
                trainees.add(trainee);
               return EmployeeHelper.trainerToTrainerDto(trainerDao.save(presentTrainer));
            }
        }
        return null;
    }

}


package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dao.TraineeRepo;
import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Deals with the trainee business logics.
 */
@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepo traineeDao;

    private final TrainerService trainerService;


    @Autowired
    public TraineeServiceImpl(TraineeRepo traineeDao, @Lazy TrainerService trainerService) {
        this.traineeDao = traineeDao;
        this.trainerService = trainerService;
    }

    /**
     * This method is used to set traineeDto objects to trainee.
     *
     * @param traineeDto
     */
    @Override
    public TraineeDto setTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }

    /**
     * This method is used to get all trainee details from database.
     *
     * @return List<TraineeDto>
     */
    @Override
    public List<Trainee> getTrainees() {
        return traineeDao.findAll();
       // return traineeDao.findAll().stream().map(EmployeeHelper::traineeToTraineeDto).collect(Collectors.toList());
    }

    /**
     * This method is used to get a trainee details by Id.
     *
     * @param id
     * @return traineeDto
     */
    @Override
    public TraineeDto getTraineeById(int id) {
        Optional<Trainee> trainee = traineeDao.findById(id);
        TraineeDto traineeDto = null;
        if (trainee.isPresent()) {
            Trainee presentTrainee = trainee.get();
            traineeDto = EmployeeHelper.traineeToTraineeDto(presentTrainee);
            traineeDto.setTrainersDto(EmployeeHelper.convertTrainerList(presentTrainee.getTrainers()));
        }
        return traineeDto;
    }

    /**
     * This method is used to delete a trainee details by Id.
     *
     * @param id
     */
    @Override
    public void deleteTrainee(int id) {
        traineeDao.deleteById(id);
    }

    /**
     * This method is used to update trainee details by Id.
     *
     * @param traineeDto
     */
    @Override
    public TraineeDto updateTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }

    /**
     *  Gives trainee to trainer service for association purpose.
     * @param id
     * @return trainee
     */
    @Override
    public Trainee getTraineeForAssociation(int id){
        return traineeDao.findById(id).orElse(null);
    }

    @Override
    public TraineeDto associateTrainerToTrainees(int traineeId, int trainerId) {
        Optional<Trainee> trainee = traineeDao.findById(traineeId);
        Trainee presentTrainee;
        if (trainee.isPresent()) {
            presentTrainee = trainee.get();
            List<Trainer> trainers = presentTrainee.getTrainers();
            Trainer trainer = trainerService.getTrainerForAssociation(trainerId);
            if (trainer != null) {
                trainers.add(trainer);
                return EmployeeHelper.traineeToTraineeDto(traineeDao.save(presentTrainee));
            }
        }
        return null;
    }
}



    


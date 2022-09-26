package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dao.TraineeRepo;
import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.helper.EmployeeHelper;
import com.ideas2it.employeedetails.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Deals with the trainee business logics.
 *
 */
@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepo traineeDao;


    @Autowired
    public TraineeServiceImpl(TraineeRepo traineeDao){
        this.traineeDao=traineeDao;
    }

    /**
     * This method is used to set traineeDto objects to trainee.
     * @param traineeDto
     */
    @Override
    public TraineeDto setTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }
  
    /**
     * This method is used to get all trainee details from database.
     * @return List<TraineeDto>
     */
    @Override
    public List<TraineeDto> getTrainees() {
        return traineeDao.findAll().stream().map(EmployeeHelper::traineeToTraineeDto).collect(Collectors.toList());
    }

    /**
     * This method is used to get a trainee details by Id.
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
            return traineeDto;
        }
        return traineeDto;
    }

    /**
     * This method is used to delete a trainee details by Id.
     * @param id
     */
    @Override
    public void deleteTrainee(int id) throws EmptyResultDataAccessException {
        traineeDao.deleteById(id);
    }

    /**
     * This method is used to update trainee details by Id.
     * @param traineeDto
     */
    @Override
    public TraineeDto updateTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }

    @Override
    public Trainee getTraineeForTrainerService(int id) {
        Optional<Trainee> trainee= traineeDao.findById(id);
        return trainee.orElseGet(trainee::get);
    }
}



    


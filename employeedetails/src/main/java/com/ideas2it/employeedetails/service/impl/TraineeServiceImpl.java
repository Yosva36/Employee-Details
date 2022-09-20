package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dao.TraineeDao;
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
 **/
@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeDao traineeDao;

    @Autowired
    public TraineeServiceImpl(TraineeDao traineeDao){
        this.traineeDao=traineeDao;
    }

    /**
     * This method is used to set traineeDto objects to trainee.
     * @param traineeDto
     */     
    public TraineeDto setTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }
  
    /**
     * This method is used to get all trainee details from database.
     * @return List<TraineeDto>
     */ 
    public List<TraineeDto> getTrainees() {
        return traineeDao.findAll().stream().map(trainee ->EmployeeHelper.traineeToTraineeDto(trainee)).collect(Collectors.toList());
    }

    /**
     * This method is used to get a trainee details by Id.
     * @param id
     * @return traineeDto
     */    
    public TraineeDto getTraineeById(int id) {
        //Trainee trainee = traineeDao.searchTrainee(employeeId);
        Optional<Trainee> trainee = traineeDao.findById(id);
        TraineeDto traineeDto = null;
        if (trainee.isPresent()) {
            traineeDto = EmployeeHelper.traineeToTraineeDto(trainee.get());
           // traineeDto.setTrainersDto(EmployeeHelper.convertTrainerList(trainee.getTrainers()));
        }
        return traineeDto;
    }

    /**
     * This method is used to delete a trainee details by Id.
     * @param id
     */ 
    public void deleteTrainee(int id) throws EmptyResultDataAccessException {
        traineeDao.deleteById(id);
    }

    /**
     * This method is used to update trainee details by Id.
     * @param traineeDto
     */ 
    public TraineeDto updateTrainee(TraineeDto traineeDto) {
        return EmployeeHelper.traineeToTraineeDto(traineeDao.save(EmployeeHelper.traineeDtoToTrainee(traineeDto)));
    }


//    public void associateTrainee(String traineeId, List<String> trainerIds) {
//        TrainerDao trainerDao = new TrainerDaoImpl();
//        Trainee trainee = traineeDao.searchTrainee(traineeId);
//        if (trainee != null) {
//            List<Trainer> trainers = new ArrayList<Trainer>();
//            for (String s : trainerIds) {
//                Trainer trainer = new Trainer();
//                trainer = trainerDao.searchTrainer(s);
//                if (trainer != null) {
//                    trainers.add(trainer);
//                }
//            }
//            trainee.setTrainers(trainers);
//            traineeDao.updateTrainee(trainee);
//        }
//    }
}



    


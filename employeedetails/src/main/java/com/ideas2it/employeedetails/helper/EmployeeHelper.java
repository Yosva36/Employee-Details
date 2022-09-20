package com.ideas2it.employeedetails.helper;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.entity.Trainee;
import com.ideas2it.employeedetails.entity.Trainer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHelper {

    /*
     * Convert trainer dto into trainer objects
     * @param trainerDto
     * @return trainer
     */
    public static Trainer trainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setId(trainerDto.getId());
        trainer.setName(trainerDto.getName());
        trainer.setTrainerId(trainerDto.getTrainerId());
        trainer.setBloodGroup(trainerDto.getBloodGroup());
        trainer.setMailId(trainerDto.getMailId());
        trainer.setPhoneNumber(trainerDto.getPhoneNumber());
        trainer.setGender(trainerDto.getGender());
        trainer.setDateOfBirth(trainerDto.getDateOfBirth());
        trainer.setDateOfJoin(trainerDto.getDateOfJoin());
        trainer.setTotalProjectsDone(trainerDto.getTotalProjectsDone());
        return trainer;
    }

    /*
     * Convert trainer into trainer dto objects
     * @param trainer
     * @return trainerDto
     */
    public static TrainerDto trainerToTrainerDto(Trainer trainer) {
        if (trainer != null) {
            TrainerDto trainerDto = new TrainerDto();
            trainerDto.setId(trainer.getId());
            trainerDto.setName(trainer.getName());
            trainerDto.setTrainerId(trainer.getTrainerId());
            trainerDto.setBloodGroup(trainer.getBloodGroup());
            trainerDto.setMailId(trainer.getMailId());
            trainerDto.setPhoneNumber(trainer.getPhoneNumber());
            trainerDto.setGender(trainer.getGender());
            trainerDto.setDateOfBirth(trainer.getDateOfBirth());
            trainerDto.setDateOfJoin(trainer.getDateOfJoin());
            trainerDto.setTotalProjectsDone(trainer.getTotalProjectsDone());
            return trainerDto;
        }
        return null;
    }

    /*
     * Convert trainee dto into trainee objects
     * @param traineeDto
     * @return trainee
     */
    public static Trainee traineeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setId(traineeDto.getId());
        trainee.setName(traineeDto.getName());
        trainee.setTraineeId(traineeDto.getTraineeId());
        trainee.setBloodGroup(traineeDto.getBloodGroup());
        trainee.setMailId(traineeDto.getMailId());
        trainee.setPhoneNumber(traineeDto.getPhoneNumber());
        trainee.setGender(traineeDto.getGender());
        trainee.setDateOfBirth(traineeDto.getDateOfBirth());
        trainee.setCurrentTask(traineeDto.getCurrentTask());
        return trainee;
    }

    /*
     * Convert trainee into traineeDto objects
     * @param trainee
     * @return traineeDto
     */
    public static TraineeDto traineeToTraineeDto(Trainee trainee) {
        if (trainee != null) {
            TraineeDto traineeDto = new TraineeDto();
            traineeDto.setId(trainee.getId());
            traineeDto.setTraineeId(trainee.getTraineeId());
            traineeDto.setName(trainee.getName());
            traineeDto.setBloodGroup(trainee.getBloodGroup());
            traineeDto.setMailId(trainee.getMailId());
            traineeDto.setPhoneNumber(trainee.getPhoneNumber());
            traineeDto.setGender(trainee.getGender());
            traineeDto.setCurrentTask(trainee.getCurrentTask());
            traineeDto.setDateOfBirth(trainee.getDateOfBirth());
            return traineeDto;
        }
        return null;
    }

    /*
     * Convert trainee list trainee Dto list
     * @param List<Trainee> trainees
     * @return List<TraineeDto>
     */
    public static List<TraineeDto> convertTraineeList(List<Trainee> trainees) {
        List<TraineeDto> traineesDto = new ArrayList<>();
        TraineeDto traineeDto = null;
        for (Trainee trainee : trainees) {
	    traineeDto = traineeToTraineeDto(trainee);
	    traineesDto.add(traineeDto);
        }
        return traineesDto;
    }
}

    
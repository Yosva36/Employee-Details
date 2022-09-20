package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Receive and process all requests from client
 */
@RestController
@RequestMapping("/trainees")
public class TraineeController {

    private TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    /*
     * Get trainee details from client
     * @param traineeDto
     */
    @PostMapping
    public TraineeDto getTrainee(@RequestBody TraineeDto traineeDto){

        return traineeService.setTrainee(traineeDto);
    }

    /*
     * Get trainee details by id
     * @param id
     */
    @GetMapping("/{traineeId}")
    public TraineeDto getTraineeById (@PathVariable("traineeId") int id){
        return traineeService.getTraineeById(id);
    }

    /*
     * To get all trainees list
     * @return List<TraineeDto>
     */
    @GetMapping
    public List<TraineeDto> getAllTrainees(){
        return traineeService.getTrainees();
    }

    /*
     * Update trainee details
     * @param traineeId, traineeDto
     */
    @PutMapping
    public TraineeDto updateTrainee(@RequestBody TraineeDto traineeDto){

        return traineeService.updateTrainee(traineeDto);
    }

    /*
     * Delete trainee details by id
     * @param id
     */
    @DeleteMapping("/{traineeId}")
    public String deleteTrainee(@PathVariable("traineeId") int id) {
        try {
            traineeService.deleteTrainee(id);
            return "Deleted";
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return "No Records Found";
        }
    }
}
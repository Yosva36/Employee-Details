package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Deals with the trainer requests
 */
@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    /*
     * This method is used to insert trainer details
     * @param trainerDto
     */
    @PostMapping
    public TrainerDto insertTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.setTrainer(trainerDto);
    }

    /*
     * Get trainer details by id
     * @param id
     */
    @GetMapping("/{trainerId}")
    public TrainerDto getTrainerById (@PathVariable("trainerId") int id){
        return trainerService.getTrainerById(id);
    }

    /*
     * This method is used to get all trainers from database.
     * @return List<TrainerDto>
     */
    @GetMapping
    public List<TrainerDto> getAllTrainers(){
        return trainerService.getTrainers();
    }

    /*
     * This method is used to update all trainer details
     * @param trainerDto*
     */
    @PutMapping
    public TrainerDto updateTrainer(@RequestBody TrainerDto trainerDto){

        return trainerService.updateTrainer(trainerDto);
    }

    /*
     * Delete trainer details by id
     * @param id
     */
    @DeleteMapping("/{trainerId}")
    public String deleteTrainer(@PathVariable("trainerId") int id){
        try {
            trainerService.deleteTrainer(id);
            return "Deleted";
        } catch (EmptyResultDataAccessException emptyResultDataAccessException){
            return "Not Deleted";
        }
    }
}

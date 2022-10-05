package com.ideas2it.companymanagement.seat.controller;

import com.ideas2it.companymanagement.seat.dto.SeatDto;
import com.ideas2it.companymanagement.seat.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seatAllotment")
public class AllocationController {
    private final AllocationService allocationService;

    @Autowired
    public AllocationController(AllocationService allocationService) {
        this.allocationService = allocationService;
    }

    @PostMapping
    public SeatDto addAllocation(@RequestBody SeatDto allocationDto) {
        return allocationService.insertSeatAllocation(allocationDto);
    }

    @GetMapping("/{id}")
    public SeatDto getAllocationById(@PathVariable("id") int id) {
        return allocationService.getSeatById(id);
    }

    @GetMapping
    public List<SeatDto> getAllocation() {
        return allocationService.getSeatDetails();
    }

    @PutMapping
    public SeatDto updateAllocation(@RequestBody SeatDto allocationDto) {
        return allocationService.updateSeat(allocationDto);
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable("id") int id) {
        if (allocationService.deleteEmployeeById(id)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}

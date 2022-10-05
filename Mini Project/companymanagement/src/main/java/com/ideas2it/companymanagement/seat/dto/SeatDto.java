package com.ideas2it.companymanagement.seat.dto;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import lombok.Data;

@Data
public class SeatDto {
    private int id;
    private String seatNumber;
    private EmployeeDto employeeDto;

    public SeatDto(int id, String seatNumber) {
        this.id = id;
        this.seatNumber = seatNumber;
    }

    public SeatDto() {
    }
}


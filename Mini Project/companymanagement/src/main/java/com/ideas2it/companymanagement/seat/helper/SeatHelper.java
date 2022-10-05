package com.ideas2it.companymanagement.seat.helper;

import com.ideas2it.companymanagement.employee.dto.EmployeeDto;
import com.ideas2it.companymanagement.employee.entity.Employee;
import com.ideas2it.companymanagement.employee.util.DateUtil;
import com.ideas2it.companymanagement.seat.dto.SeatDto;
import com.ideas2it.companymanagement.seat.entity.Seat;

public class SeatHelper {

    public static Seat changeDtoToAllocationDetail(SeatDto seatDto) {
        if (seatDto != null) {
            Seat seat = new Seat();
            seat.setId(seatDto.getId());
            seat.setSeatNumber(seatDto.getSeatNumber());
            EmployeeDto employeeDto = seatDto.getEmployeeDto();
            if (employeeDto != null) {
                Employee employee = new Employee();
                employee.setId(employee.getId());
                employee.setEmployeeId(employeeDto.getEmployeeId());
                employee.setEmployeeName(employeeDto.getEmployeeName());
                employee.setDesignation(employeeDto.getDesignation());
                employee.setDateOfBirth(employeeDto.getDateOfBirth());
                employee.setPhoneNumber(employee.getPhoneNumber());
                employee.setGender(employeeDto.getGender());
                employee.setEmailId(employeeDto.getEmailId());
                employee.setDateOfJoining(employeeDto.getDateOfJoining());
                int experience = DateUtil.getYearBetweenDate(employeeDto.getDateOfJoining());
                employee.setExperience(experience);
                int age = DateUtil.getYearBetweenDate(employeeDto.getDateOfBirth());
                employee.setAge(age);
                seat.setEmployee(employee);
            }
            return seat;
        }
        return null;
    }

    public static SeatDto changeSeatAllocationToDto(Seat seat) {
        if (seat != null) {
            SeatDto seatDto = new SeatDto();
            seatDto.setId(seat.getId());
            seatDto.setSeatNumber(seat.getSeatNumber());
            Employee employee = seat.getEmployee();
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setEmployeeId(employee.getEmployeeId());
            employeeDto.setEmployeeName(employee.getEmployeeName());
            employeeDto.setDesignation(employee.getDesignation());
            employeeDto.setDateOfBirth(employee.getDateOfBirth());
            employeeDto.setGender(employee.getGender());
            employeeDto.setEmailId(employee.getEmailId());
            employeeDto.setPhoneNumber(employee.getPhoneNumber());
            employeeDto.setDateOfJoining(employee.getDateOfJoining());
            int experience = DateUtil.getYearBetweenDate(employee.getDateOfJoining());
            employeeDto.setExperience(experience);
            int age = DateUtil.getYearBetweenDate(employee.getDateOfBirth());
            employeeDto.setAge(age);
            seatDto.setEmployeeDto(employeeDto);
            return seatDto;
        }
        return null;
    }
}

package com.ideas2it.employeedetails.exception;

/**
 * Deals with details not found error.
 */
public class EmployeeRuntimeException extends RuntimeException {
    public EmployeeRuntimeException(String message) {
        super(message);
    }
}

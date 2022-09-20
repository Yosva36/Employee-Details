package com.ideas2it.employeedetails.util;

/**
 *
 * Deals with the Date validation.
 *
 **/
public class DateUtil {

    /**
     *
     * This method is used validate date. 
     *
     * @param date
     * @return boolean
     */   
    public static boolean isValidDate(String date) {
        String regex = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
        return date.matches(regex);
    }
}
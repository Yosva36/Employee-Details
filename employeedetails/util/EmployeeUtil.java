package com.ideas2it.employeedetails.util;

import com.ideas2it.employeedetails.enums.Gender;

/**
 * Deals with the employee details validation needs.
 *
 */
public class EmployeeUtil {

    private static int commonId = 22000;

    /**
     *
     * This method is used Generate the employee Id. 
     *
     * @return employeeId
     */ 
    public static String generateEmployeeId() {        
        String companyId = "I";
        int permanentId = commonId + 1;
        commonId = permanentId;
        String employeeId = companyId + commonId;
        return employeeId;
    }

    /**
     *
     * This method is used validate phone number. 
     *
     * @param number
     * @return boolean
     */ 		
    public static boolean isValidPhoneNumber(String number) {                
        String regex = "[6-9][0-9]{9}"; 
        if (number != null){   
            return number.matches(regex);
        }
        return false;
    }

    /**
     *
     * This method is used validate name. 
     *
     * @param name
     * @return boolean
     */ 
    public static boolean isValidName(String name) {                
        String regex = "[a-zA-Z ]*";
        if (name != null) {       
           return name.matches(regex);
        }
        return false; 
    }

    /**
     *
     * This method is used validate gender. 
     *
     * @param genderName
     * @return boolean
     */
    public static boolean isValidGender(String genderName) {                
        for (Gender gender : Gender.values()) {
            if(gender.name().equalsIgnoreCase(genderName)) {
                return true;
            } 
        } 
        return false;  
    }

    /**
     *
     * This method is used validate blood group. 
     *
     * @param bloodGroup
     * @return boolean
     */
    public static boolean isValidBloodGroup(String bloodGroup) {
        String regex = "^(A|B|AB|O)[+-]$"; 
        if (bloodGroup != null) {              
           return bloodGroup.matches(regex);
        } 
        return false;
    }

    /**
     * This method is used validate mail id.
     * @param mailId
     * @return boolean
     */
    public static boolean isValidMailId(String mailId) {                
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (mailId != null) {       
            return mailId.matches(regex);
        }
        return false;  
    }    
}
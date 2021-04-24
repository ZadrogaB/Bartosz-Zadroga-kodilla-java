package com.kodill.hibernate.facade;

public class SearchingException extends Exception {
    public static String ERR_NO_SUCH_EMPLOYEE = "Such user does not exist";
    public static String ERR_NO_SUCH_COMPANY = "Such company does not exist";

    public SearchingException(String message){
        super(message);
    }
}

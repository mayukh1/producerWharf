package com.tarento.wharf.util;

public class Constants {
    /**
     * Query Parameters and Response Parameters
     */
    public static String SUCCESS= "success";
    public static String ASC= "asc";
    public static String DESC= "desc";
    public static String TRUE = "true";
    public static String FALSE = "false";
    public static String STRING_BLANK="";
    public static String COMMA_SPACE_SEPARATOR=", ";
    public static final String DATE = "date";
    public static String QUERY_ALERT_SUBJECT =  "Query Alert!!";
    public static String SCHEDULER_ALERT_SUBJECT = "Scheduler Alert!!";
    public static String STRING_SPACE = " ";
    public static String STRING_HYPEN = "-";
    public static String NEW_MESSAGE = "New";
    public static String READ_MESSAGE = "Read";
    public static String DELETE_MESSAGE = "Delete";
    public static String SEND_MESSAGE = "Send";
    public static String FILE_TYPE = "PDF,DOC,TXT,JPG,JPEG,PNG,GIF,AAC,MP3,MP4";
    public static String IMAGE_FILE_TYPE = "JPG,JPEG,PNG,GIF";
    public static String FCM_API_URL = "fcm.api.url";
    public static String FCM_API_KEY = "fcm.api.key";
    
    /**
     * URLs and Paths
     */
    public static String UPLOADED_FOLDER = "/home/uploads/";

    /**
     * Status Code and Messages
     */
    public static int UNAUTHORIZED_ID = 401;
    public static int SUCCESS_ID = 200;
    public static int FAILURE_ID = 320;
    public static String UNAUTHORIZED = "Invalid credentials. Please try again.";
    public static String PROCESS_FAIL = "Process failed, Please try again.";
    
    /**
     * Allowed Origins for CORS Bean
     */
    public static final String GET = "GET";
    public static final String POST = "POST"; 
    public static final String PUT = "PUT"; 
    public static final String DELETE = "DELETE";
    public static final String OPTIONS = "OPTIONS"; 
    
    /**
     * Qualifiers and Services
     */
    public static final String USER_SERVICE = "userService";
    public static final String USER_DAO = "userDao"; 
    public static final String ROLE_ACTION_SERVICE = "roleActionService" ;
    public static final String ROLE_DAO = "roleDao";
}

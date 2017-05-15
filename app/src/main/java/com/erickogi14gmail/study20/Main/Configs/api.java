package com.erickogi14gmail.study20.Main.Configs;

/**
 * Created by kimani kogi on 5/13/2017.
 */

public class api {

    public final static String API_KEY = "a063b2f6f85b4df6b9bce476d25f3e60";
    public final static String COURSES_END_POINT = "http://erickogi.co.ke/study/api/v1/?action=get_courses";



    public final static String CONTENT_END_POINT = "http://erickogi.co.ke/study/api/v1/?action=get_content&course_code=";
//INTENTS KEYS
    public final static String COURSE_CODE = "course_code";
    public final static int ALL_TECH_SOURCES_PARSING_CODE = 200;

    //COURSES
    public final static String KEY_CATEGORY_TECH = "technology";
    public final static String KEY_URL_TAG = "key_url";
    public final static String KEY_URL_TO_IMAGE_TAG = "key_url_to_image";


    //CONTENT
    public final static String KEY_SOURCE_ID = "id";
    public final static String KEY_SOURCE_NAME = "name";
    public final static String KEY_SOURCE_DESCRIPTION = "description";
    public final static String KEY_SOURCE_URL = "url";
    public final static String KEY_SOURCE_CATEGORY = "category";
    public final static String KEY_SOURCE_LANGUAGE = "language";
    public final static String KEY_SOURCE_COUNTRY = "country";






    public static final String LOGIN_URL = "http://erickogi.co.ke/study/api/v1/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "fdaradlogin";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";
    public static final String KEY_SHARED_PREF = "user_key";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}

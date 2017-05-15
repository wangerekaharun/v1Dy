package com.erickogi14gmail.study20.Main.DB;

/**
 * Created by kimani kogi on 4/19/2017.
 */

public class DBKeys {

//TABLE CONTENTS
    public static final String CONTENT_TABLE = "content_table";


    // Labels Table  Columns names

    public static final String KEY_ID = "id";
    public static final String KEY_COURSE_ID = "course_id";
    public static final String KEY_COURSE_CODE = "course_code";
    public static final String KEY_COURSE_TITLE = "course_title";
    public static final String KEY_CHAPTER_NO = "chapter_no";
    public static final String KEY_CHAPTER_TITLE = "chapter_title";

    public static final String KEY_CHAPTER_CONTENT = "chapter_content";
    public static final String KEY_UPDATED_ON = "updated_on";

//TABLE COURSES
    public static final String COURSES_TABLE = "course_table";

    // Labels Table  Columns names


    public static final String KEY_NO_OF_CHAPTERS = "no_of_chapters";
    public static final String KEY_UPLOADED_BY = "uploaded_by";




    public  String COURSE_ID;
    public  String COURSE_TITLE;
    public  int CHAPTER_NO;
    public  String CHAPTER_TITLE;

    public  String CHAPTER_CONTENT;
    public  String UPDATED_ON;


    public  int NO_OF_CHAPTERS;
    public  String UPLOADED_BY;

}

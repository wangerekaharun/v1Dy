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

    //Assignments

    public static final String KEY_ASSIGNMENT_ID = "assignment_id";
    public static final String KEY_ASSIGNMENT_NAME = "assignment_name";
    public static final String KEY_ASSIGNMENT_CODE = "assignment_course_code";
    public static final String KEY_ASSIGNMENT_DONE_BY = "assignment_done_by";
    public static final String KEY_ASSIGNMENT_PUBLISHED_BY = "assignment_published_by";
    public static final String KEY_ASSIGNMENT_PUBLISHED_ON = "assignment_published_on";
    public static final String KEY_ASSIGNMENT_DONE_ON = "assignment_date";
    public static final String KEY_ASSIGNMENT_COURSE_NAME = "assignment_course";
    public static final String KEY_ASSIGNMENT_TYPE = "assignment_type";


    //News
    public final static String API_KEY = "a063b2f6f85b4df6b9bce476d25f3e60";
    public final static String ARTICLES_END_POINT = "https://newsapi.org/v1/articles?source=";
    public final static String SOURCES_END_POINT = "https://newsapi.org/v1/sources";

    public final static int ALL_SORUCES_PARSING_CODE = 100;
    public final static int ALL_TECH_SOURCES_PARSING_CODE = 200;

    public final static String KEY_CATEGORY_TECH = "technology";
    public final static String KEY_URL_TAG = "key_url";
    public final static String KEY_URL_TO_IMAGE_TAG = "key_url_to_image";
    //news types
    public final static String KEY_CATEGORY_BUSINESS = "business";
    public final static String KEY_CATEGORY_ENTERTAINMENT = "entertainment";
    public final static String KEY_CATEGORY_POLITICS = "politics";
    public final static String KEY_CATEGORY_SPORTS = "sport";
    public final static String KEY_CATEGORY_MUSIC = "music";
    public final static String KEY_CATEGORY_SCIENCE = "science-and-nature";

    //sources
    public final static String KEY_SOURCE_ID = "id";
    public final static String KEY_SOURCE_NAME = "name";
    public final static String KEY_SOURCE_DESCRIPTION = "description";
    public final static String KEY_SOURCE_URL = "url";
    public final static String KEY_SOURCE_CATEGORY = "category";
    public final static String KEY_SOURCE_LANGUAGE = "language";
    public final static String KEY_SOURCE_COUNTRY = "country";


    //ARTICLES
    public final static String KEY_ARTICLE_AUTOR = "author";
    public final static String KEY_ARTICLE_TITLE = "title";
    public final static String KEY_ARTICLE_DESCRIPTION = "description";
    public final static String KEY_ARTICLE_URL = "url";
    public final static String KEY_ARTICLE_URLTOIMAGE = "urlToImage";
    public final static String KEY_ARTICLE_PUBLISHEDAT = "publishedAt";








    public  String COURSE_ID;
    public  String COURSE_TITLE;
    public  int CHAPTER_NO;
    public  String CHAPTER_TITLE;

    public  String CHAPTER_CONTENT;
    public  String UPDATED_ON;


    public  int NO_OF_CHAPTERS;
    public  String UPLOADED_BY;

}

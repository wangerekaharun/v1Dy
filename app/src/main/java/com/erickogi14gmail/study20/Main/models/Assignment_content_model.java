package com.erickogi14gmail.study20.Main.models;

/**
 * Created by kimani kogi on 5/18/2017.
 */

public class Assignment_content_model {

    private int ASSIGNMENT_ID;
    private String ASSIGNMENT_NAME;
    private String ASSIGNMENT_CODE;
    private String ASSIGNMENT_DONE_BY;
    private String ASSIGNMENT_PUBLISHED_BY;
    private String ASSIGNMENT_PUBLISHED_ON;
    private String ASSIGNMENT_DONE_ON;
    private String ASSIGNMENT_COURSE_NAME;
    private String ASSIGNMENT_TYPE;
    private String ASSIGNMENT_CONTENT;

    public Assignment_content_model() {


    }

    public Assignment_content_model(int ASSIGNMENT_ID, String ASSIGNMENT_NAME, String ASSIGNMENT_CODE, String ASSIGNMENT_DONE_BY,
                                    String ASSIGNMENT_PUBLISHED_BY, String ASSIGNMENT_PUBLISHED_ON, String ASSIGNMENT_DONE_ON,
                                    String ASSIGNMENT_COURSE_NAME, String ASSIGNMENT_TYPE, String ASSIGNMENT_CONTENT) {
        this.ASSIGNMENT_ID = ASSIGNMENT_ID;
        this.ASSIGNMENT_NAME = ASSIGNMENT_NAME;
        this.ASSIGNMENT_CODE = ASSIGNMENT_CODE;
        this.ASSIGNMENT_DONE_BY = ASSIGNMENT_DONE_BY;
        this.ASSIGNMENT_PUBLISHED_BY = ASSIGNMENT_PUBLISHED_BY;
        this.ASSIGNMENT_PUBLISHED_ON = ASSIGNMENT_PUBLISHED_ON;
        this.ASSIGNMENT_DONE_ON = ASSIGNMENT_DONE_ON;
        this.ASSIGNMENT_COURSE_NAME = ASSIGNMENT_COURSE_NAME;
        this.ASSIGNMENT_TYPE = ASSIGNMENT_TYPE;
        this.ASSIGNMENT_CONTENT = ASSIGNMENT_CONTENT;
    }

    public int getASSIGNMENT_ID() {
        return ASSIGNMENT_ID;
    }

    public void setASSIGNMENT_ID(int ASSIGNMENT_ID) {
        this.ASSIGNMENT_ID = ASSIGNMENT_ID;
    }

    public String getASSIGNMENT_NAME() {
        return ASSIGNMENT_NAME;
    }

    public void setASSIGNMENT_NAME(String ASSIGNMENT_NAME) {
        this.ASSIGNMENT_NAME = ASSIGNMENT_NAME;
    }

    public String getASSIGNMENT_CODE() {
        return ASSIGNMENT_CODE;
    }

    public void setASSIGNMENT_CODE(String ASSIGNMENT_CODE) {
        this.ASSIGNMENT_CODE = ASSIGNMENT_CODE;
    }

    public String getASSIGNMENT_DONE_BY() {
        return ASSIGNMENT_DONE_BY;
    }

    public void setASSIGNMENT_DONE_BY(String ASSIGNMENT_DONE_BY) {
        this.ASSIGNMENT_DONE_BY = ASSIGNMENT_DONE_BY;
    }

    public String getASSIGNMENT_PUBLISHED_BY() {
        return ASSIGNMENT_PUBLISHED_BY;
    }

    public void setASSIGNMENT_PUBLISHED_BY(String ASSIGNMENT_PUBLISHED_BY) {
        this.ASSIGNMENT_PUBLISHED_BY = ASSIGNMENT_PUBLISHED_BY;
    }

    public String getASSIGNMENT_PUBLISHED_ON() {
        return ASSIGNMENT_PUBLISHED_ON;
    }

    public void setASSIGNMENT_PUBLISHED_ON(String ASSIGNMENT_PUBLISHED_ON) {
        this.ASSIGNMENT_PUBLISHED_ON = ASSIGNMENT_PUBLISHED_ON;
    }

    public String getASSIGNMENT_DONE_ON() {
        return ASSIGNMENT_DONE_ON;
    }

    public void setASSIGNMENT_DONE_ON(String ASSIGNMENT_DONE_ON) {
        this.ASSIGNMENT_DONE_ON = ASSIGNMENT_DONE_ON;
    }

    public String getASSIGNMENT_COURSE_NAME() {
        return ASSIGNMENT_COURSE_NAME;
    }

    public void setASSIGNMENT_COURSE_NAME(String ASSIGNMENT_COURSE_NAME) {
        this.ASSIGNMENT_COURSE_NAME = ASSIGNMENT_COURSE_NAME;
    }

    public String getASSIGNMENT_TYPE() {
        return ASSIGNMENT_TYPE;
    }

    public void setASSIGNMENT_TYPE(String ASSIGNMENT_TYPE) {
        this.ASSIGNMENT_TYPE = ASSIGNMENT_TYPE;
    }

    public String getASSIGNMENT_CONTENT() {
        return ASSIGNMENT_CONTENT;
    }

    public void setASSIGNMENT_CONTENT(String ASSIGNMENT_CONTENT) {
        this.ASSIGNMENT_CONTENT = ASSIGNMENT_CONTENT;
    }
}

package com.erickogi14gmail.study20.Main.models;

/**
 * Created by kimani kogi on 5/13/2017.
 */

public class Course_model {
    private   String COURSE_ID;
    private   String COURSE_TITLE;

    private   int NO_OF_CHAPTERS;
    private   String UPLOADED_BY;


    public Course_model(String COURSE_ID, String COURSE_TITLE, int NO_OF_CHAPTERS, String UPLOADED_BY) {
        this.COURSE_ID = COURSE_ID;
        this.COURSE_TITLE = COURSE_TITLE;
        this.NO_OF_CHAPTERS = NO_OF_CHAPTERS;
        this.UPLOADED_BY = UPLOADED_BY;
    }

    public Course_model() {

    }

    public String getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(String COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getCOURSE_TITLE() {
        return COURSE_TITLE;
    }

    public void setCOURSE_TITLE(String COURSE_TITLE) {
        this.COURSE_TITLE = COURSE_TITLE;
    }

    public int getNO_OF_CHAPTERS() {
        return NO_OF_CHAPTERS;
    }

    public void setNO_OF_CHAPTERS(int NO_OF_CHAPTERS) {
        this.NO_OF_CHAPTERS = NO_OF_CHAPTERS;
    }

    public String getUPLOADED_BY() {
        return UPLOADED_BY;
    }

    public void setUPLOADED_BY(String UPLOADED_BY) {
        this.UPLOADED_BY = UPLOADED_BY;
    }
}

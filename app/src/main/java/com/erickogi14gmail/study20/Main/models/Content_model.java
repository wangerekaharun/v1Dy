package com.erickogi14gmail.study20.Main.models;

/**
 * Created by kimani kogi on 5/13/2017.
 */

public class Content_model {
    private int id;
    private   String COURSE_ID;
    private   String COURSE_TITLE;
    private   int CHAPTER_NO;
    private   String CHAPTER_TITLE;

    private   String CHAPTER_CONTENT;
    private   String UPDATED_ON;

    public Content_model(int id,String COURSE_ID, String COURSE_TITLE, int CHAPTER_NO, String CHAPTER_TITLE, String CHAPTER_CONTENT, String UPDATED_ON) {
      this.id=id;
        this.COURSE_ID = COURSE_ID;
        this.COURSE_TITLE = COURSE_TITLE;
        this.CHAPTER_NO = CHAPTER_NO;
        this.CHAPTER_TITLE = CHAPTER_TITLE;
        this.CHAPTER_CONTENT = CHAPTER_CONTENT;
        this.UPDATED_ON = UPDATED_ON;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Content_model() {

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

    public int getCHAPTER_NO() {
        return CHAPTER_NO;
    }

    public void setCHAPTER_NO(int CHAPTER_NO) {
        this.CHAPTER_NO = CHAPTER_NO;
    }

    public String getCHAPTER_TITLE() {
        return CHAPTER_TITLE;
    }

    public void setCHAPTER_TITLE(String CHAPTER_TITLE) {
        this.CHAPTER_TITLE = CHAPTER_TITLE;
    }

    public String getCHAPTER_CONTENT() {
        return CHAPTER_CONTENT;
    }

    public void setCHAPTER_CONTENT(String CHAPTER_CONTENT) {
        this.CHAPTER_CONTENT = CHAPTER_CONTENT;
    }

    public String getUPDATED_ON() {
        return UPDATED_ON;
    }

    public void setUPDATED_ON(String UPDATED_ON) {
        this.UPDATED_ON = UPDATED_ON;
    }
}

package com.erickogi14gmail.study20.Main.models;

/**
 * Created by kimani kogi on 5/13/2017.
 */

public class Chapters {

    private int chapter_no;
    private String chapter_title;

    public Chapters(int chapter_no, String chapter_title) {
        this.chapter_no = chapter_no;
        this.chapter_title = chapter_title;


    }

    public Chapters() {
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public int getChapter_no() {
        return chapter_no;
    }

    public void setChapter_no(int chapter_no) {
        this.chapter_no = chapter_no;
    }
}

package com.erickogi14gmail.study20.Main.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimani kogi on 4/19/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "study.db";


    String CREATE_TABLE_CONTENT = "CREATE TABLE " + DBKeys.CONTENT_TABLE + "("
            + DBKeys.KEY_ID + " INTEGER PRIMARY KEY ,"

            + DBKeys.KEY_COURSE_ID + " VARCHAR, "
            + DBKeys.KEY_COURSE_TITLE+ " TEXT, "

            + DBKeys.KEY_CHAPTER_NO+ " INTEGER ,"
            + DBKeys.KEY_CHAPTER_TITLE + " TEXT ,"

            + DBKeys.KEY_CHAPTER_CONTENT + " Text ,"


            + DBKeys.KEY_UPDATED_ON + " TEXT"

            + ")";
    String CREATE_TABLE_COURSES = "CREATE TABLE " + DBKeys.COURSES_TABLE+ "("
            + DBKeys.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"

            + DBKeys.KEY_COURSE_ID + " TEXT, "
            + DBKeys.KEY_COURSE_TITLE+ " TEXT, "

            + DBKeys.KEY_NO_OF_CHAPTERS+ " INTEGER ,"

            + DBKeys.KEY_UPLOADED_BY + " TEXT"

            + ")";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_COURSES);
        db.execSQL(CREATE_TABLE_CONTENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBKeys.COURSES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DBKeys.CONTENT_TABLE);


        // Create tables again
        onCreate(db);

    }

}



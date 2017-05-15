package com.erickogi14gmail.study20.Main.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.erickogi14gmail.study20.Main.models.Chapters;
import com.erickogi14gmail.study20.Main.models.Content_model;
import com.erickogi14gmail.study20.Main.models.Course_model;

import java.util.ArrayList;

import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_CHAPTER_CONTENT;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_CHAPTER_NO;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_CHAPTER_TITLE;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_COURSE_ID;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_COURSE_TITLE;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_ID;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_NO_OF_CHAPTERS;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_UPDATED_ON;
import static com.erickogi14gmail.study20.Main.DB.DBKeys.KEY_UPLOADED_BY;

/**
 * Created by kimani kogi on 4/19/2017.
 */

public class DBOperations {

    private DBHandler dbHandler;

    public DBOperations(Context context) {
        dbHandler = new DBHandler(context);
    }

    public boolean in(ArrayList<Content_model> data) {
        boolean success = false;
        try {

            SQLiteDatabase db = dbHandler.getWritableDatabase();

            //d
            for (int a = 0; a < data.size(); a++) {

                final SQLiteStatement insert = db.compileStatement("INSERT INTO content_table VALUES (?,?,?,?,?,?,?)");
                insert.bindString(1, String.valueOf(data.get(a).getId()));
                insert.bindString(2, data.get(a).getCOURSE_ID());
                insert.bindString(3, data.get(a).getCOURSE_TITLE().toUpperCase());
                insert.bindString(4, String.valueOf(data.get(a).getCHAPTER_NO()));
                insert.bindString(5, data.get(a).getCHAPTER_TITLE());
                insert.bindString(6, data.get(a).getCHAPTER_CONTENT());
                insert.bindString(7, data.get(a).getUPDATED_ON());
//edit: hehe forgot about most important thing

                if (insert.executeInsert() >= 1) {
                    success = true;

                }
                else {

                }
            }
            db.close();
        }
        catch (Exception l){
            l.printStackTrace();

        }
        return success;
    }

    public int insertContent(DBKeys Keys) {
        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_COURSE_ID, Keys.COURSE_ID);
        values.put(KEY_COURSE_TITLE, Keys.COURSE_TITLE);

        values.put(KEY_CHAPTER_NO, Keys.CHAPTER_NO);
        values.put(KEY_CHAPTER_TITLE, Keys.CHAPTER_TITLE);
        values.put(KEY_CHAPTER_CONTENT, Keys.CHAPTER_CONTENT);

        values.put(KEY_UPDATED_ON, Keys.UPDATED_ON);


        // Inserting Row
        long keys_Id = db.insert(DBKeys.CONTENT_TABLE, null, values);
        db.close(); // Closing database connection
        return (int) keys_Id;
    }

    public int insertCourse(DBKeys Keys) {
        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_COURSE_ID, Keys.COURSE_ID);
        values.put(KEY_COURSE_TITLE, Keys.COURSE_TITLE);

        values.put(KEY_NO_OF_CHAPTERS, Keys.NO_OF_CHAPTERS);


        values.put(KEY_UPLOADED_BY, Keys.UPLOADED_BY);


        // Inserting Row
        long keys_Id = db.insert(DBKeys.COURSES_TABLE, null, values);
        db.close(); // Closing database connection
        return (int) keys_Id;
    }

    public boolean deleteCourse(String rowId) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete(DBKeys.COURSES_TABLE,KEY_COURSE_ID +  "= '" + rowId+"' ", null) > 0;
    }

    public boolean deleteContent(String rowId) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete(DBKeys.CONTENT_TABLE, KEY_COURSE_ID + "= '" + rowId+"' ", null) > 0;
    }


    public ArrayList<Course_model> getCourseList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<Course_model> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.COURSES_TABLE;


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                Course_model pojo = new Course_model();


                pojo.setCOURSE_ID(cursor.getString(1));
                pojo.setCOURSE_TITLE(cursor.getString(2));
                pojo.setNO_OF_CHAPTERS(cursor.getInt(3));

                pojo.setUPLOADED_BY(cursor.getString(4));


                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return data;


    }

    public String getContent() {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String content = null;
        String QUERY = "SELECT * FROM " + DBKeys.CONTENT_TABLE + " ";
        Cursor cursor = db.rawQuery(QUERY, null);


        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {


                content = cursor.getString(5);


            }
        }
        db.close();
        return content;
    }

    public ArrayList<Chapters> getChaptersByCourse(String courseId) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();


        ArrayList<Chapters> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.CONTENT_TABLE + " WHERE " + DBKeys.KEY_COURSE_ID + " = '" + courseId + "'";


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            while (cursor.moveToNext()) {
                Chapters pojo = new Chapters();


                pojo.setChapter_no(cursor.getInt(3));
                pojo.setChapter_title(cursor.getString(4));


                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

//        if (cursor == null) {
//            return null;
//        } else if (!cursor.moveToFirst()) {
//            cursor.close();
//            return null;
//        }
        return data;


    }


    public String getChapterContentByChapterByCourse(String courseId, String chapterNo) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String html = null;

        ArrayList<Chapters> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.CONTENT_TABLE + " WHERE " + DBKeys.KEY_COURSE_ID + " = '" + courseId + "' AND " + DBKeys.KEY_CHAPTER_NO + " ='" + chapterNo + "'";


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            if (cursor.moveToNext()) {
                Chapters pojo = new Chapters();

                html = cursor.getString(5);


//                pojo.setChapter_title(cursor.getString(5));
//
//
//
//                data.add(pojo);

            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return html;


    }


    public String getChapterContentByChapterByTitle(String courseId, String chapterTitle) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String html = null;

        ArrayList<Chapters> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.CONTENT_TABLE + " WHERE " + DBKeys.KEY_COURSE_ID + " = '" + courseId + "' AND " + DBKeys.KEY_CHAPTER_TITLE + " ='" + chapterTitle + "'";


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            if (cursor.moveToNext()) {


                html = cursor.getString(5);


            }
        }
        db.close();
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return html;


    }


    public boolean inCourse(Course_model data) {
        boolean success = false;

        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_COURSE_ID, data.getCOURSE_ID());
        values.put(KEY_COURSE_TITLE, data.getCOURSE_TITLE());

        values.put(KEY_NO_OF_CHAPTERS, data.getNO_OF_CHAPTERS());


        values.put(KEY_UPLOADED_BY, data.getUPLOADED_BY());


        // Inserting Row
        if (db.insert(DBKeys.COURSES_TABLE, null, values) >= 1) {
            success = true;
        }
        db.close();


        return success;


    }


    public boolean getCourseById(String courseId) {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();

        boolean isThere=false;
        ArrayList<Course_model> data = new ArrayList<>();
        String QUERY = "SELECT * FROM " + DBKeys.COURSES_TABLE+ "  WHERE " +DBKeys.KEY_COURSE_ID+ " = '"+courseId+ "' ";


        Cursor cursor = db.rawQuery(QUERY, null);

        if (!cursor.isLast()) {

            if(cursor.moveToNext()) {
               isThere=true;
            }
        }
        db.close();
        // looping through all rows and adding to list


        return isThere;


    }
}



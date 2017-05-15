package com.erickogi14gmail.study20.Main.Adapters;

import com.erickogi14gmail.study20.Main.models.Course_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 5/13/2017.
 */

public class JsonParser {
    static ArrayList<Course_model> course_list;

    public static ArrayList<Course_model> parseData(String content) {

        JSONArray course_arry = null;
       Course_model model = null;
        try {


            course_list = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            course_arry = jObj.getJSONArray("data");
            if(course_arry.length()<1){

            }
            for (int i = 0; i < course_arry.length(); i++) {

                JSONObject obj = course_arry.getJSONObject(i);
                model = new Course_model();



                model.setCOURSE_ID(obj.getString("course_id"));
                model.setCOURSE_TITLE(obj.getString("course_title"));
                model.setNO_OF_CHAPTERS(obj.getInt("course_chapters"));
                model.setUPLOADED_BY(obj.getString("uploaded_by"));



                course_list.add(model);
            }
            return course_list;

        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

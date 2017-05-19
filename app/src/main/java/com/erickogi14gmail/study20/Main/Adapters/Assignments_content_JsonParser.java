package com.erickogi14gmail.study20.Main.Adapters;

import com.erickogi14gmail.study20.Main.models.Assignment_content_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 5/18/2017.
 */

public class Assignments_content_JsonParser {
    static ArrayList<Assignment_content_model> content_list;

    public static ArrayList<Assignment_content_model> parseData(String content, int a) {

        JSONArray content_arry = null;
        Assignment_content_model model = null;
        try {


            content_list = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            content_arry = jObj.getJSONArray("data");
            if (content_arry.length() < 1) {

            }

            for (int i = 0; i < content_arry.length(); i++) {

                JSONObject obj = content_arry.getJSONObject(i);
                model = new Assignment_content_model();


                model.setASSIGNMENT_ID(obj.getInt("id"));
                model.setASSIGNMENT_NAME(obj.getString("title"));
                model.setASSIGNMENT_CODE(obj.getString("course_code"));
                model.setASSIGNMENT_DONE_BY(obj.getString("done_by"));
                model.setASSIGNMENT_PUBLISHED_BY(obj.getString("published_by"));
                model.setASSIGNMENT_PUBLISHED_ON(obj.getString("published_on"));
                model.setASSIGNMENT_DONE_ON(obj.getString("done_on"));
                model.setASSIGNMENT_COURSE_NAME(obj.getString("course_name"));
                model.setASSIGNMENT_TYPE(obj.getString("type"));
                if (a == 1) {
                    model.setASSIGNMENT_CONTENT("");
                } else {
                    model.setASSIGNMENT_CONTENT(obj.getString("content"));
                }


                content_list.add(model);
            }

            return content_list;

        } catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}



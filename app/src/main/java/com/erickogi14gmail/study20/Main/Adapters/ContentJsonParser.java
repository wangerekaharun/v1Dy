package com.erickogi14gmail.study20.Main.Adapters;

import android.util.Log;

import com.erickogi14gmail.study20.Main.models.Content_model;
import com.erickogi14gmail.study20.Main.models.Course_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 5/14/2017.
 */
public class ContentJsonParser {
    static ArrayList<Content_model> content_list;

    public static ArrayList<Content_model> parseData(String content) {

        JSONArray content_arry = null;
        Content_model model = null;
        try {


            content_list = new ArrayList<>();
            JSONObject jObj = new JSONObject(content);
            content_arry = jObj.getJSONArray("data");
            if(content_arry.length()<1){

            }

            for (int i = 0; i < content_arry.length(); i++) {

                JSONObject obj = content_arry.getJSONObject(i);
                model = new Content_model();

                model.setId(obj.getInt("id"));

                model.setCOURSE_ID(obj.getString("course_code"));
                model.setCOURSE_TITLE(obj.getString("course_title"));
                model.setCHAPTER_NO(obj.getInt("chapter_no"));
                model.setCHAPTER_TITLE(obj.getString("chapter_title"));
                model.setCHAPTER_CONTENT(obj.getString("chapter_content"));
                model.setUPDATED_ON(obj.getString("updated_by"));



                content_list.add(model);
            }

            return content_list;

        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


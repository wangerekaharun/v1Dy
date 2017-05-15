package com.erickogi14gmail.study20.Main.addContent;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SyncStateContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.erickogi14gmail.study20.Main.Adapters.AddRecyclerViewAdapter;
import com.erickogi14gmail.study20.Main.Adapters.ContentJsonParser;
import com.erickogi14gmail.study20.Main.Adapters.JsonParser;
import com.erickogi14gmail.study20.Main.Adapters.MainRecyclerViewAdapter;
import com.erickogi14gmail.study20.Main.Configs.api;
import com.erickogi14gmail.study20.Main.DB.DBOperations;
import com.erickogi14gmail.study20.Main.Read.ReadActivity;
import com.erickogi14gmail.study20.Main.models.Content_model;
import com.erickogi14gmail.study20.Main.models.Course_model;
import com.erickogi14gmail.study20.Main.utills.RecyclerTouchListener;
import com.erickogi14gmail.study20.R;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;


public class AddCourse extends AppCompatActivity {
    static RequestQueue queue;
    static Context context;
    private Toolbar mToolbar;
    MainRecyclerViewAdapter mainRecyclerViewAdapter;
    ArrayList<Course_model> displayedList;
    static RecyclerView.LayoutManager mLayoutManager;
    AddRecyclerViewAdapter adapter;
    DBOperations dbOperations;

    static ArrayList<Course_model> course_model;
    SwipeRefreshLayout swipe_refresh_layout;
    RecyclerView recyclerView_vertical;
    ProgressDialog progressDialog;
    private  int progressBarStatus;
    private Handler progressBarHandler=new Handler() ;

    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView_vertical = (RecyclerView) findViewById(R.id.recycle_view);
        swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipe_refresh_layout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        swipe_refresh_layout.setBackgroundResource(android.R.color.white);
        swipe_refresh_layout.setColorSchemeResources(android.R.color.white, android.R.color.holo_purple, android.R.color.white);

        swipe_refresh_layout.setRefreshing(true);

        swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh_layout.setRefreshing(true);
                getRecyclerView_sources();

            }
        });
        getRecyclerView_sources();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

            SearchView search = (SearchView) findViewById(R.id.search_bar);

            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


                @Override
                public boolean onQueryTextSubmit(String query) {


                    
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filter(newText);
                    return false;
                }
            });

        }


        recyclerView_vertical .addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView_vertical, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                try {
                   ArrayList<Content_model> c=new ArrayList<Content_model>();
                    c.clear();

                }
                catch (Exception NM){

                }


                String code=course_model.get(position).getCOURSE_ID();
                dbOperations=new DBOperations(AddCourse.this);
                if(dbOperations.getCourseById(code)){
                    Snackbar.make(view, "You have this Course Downloaded Already", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {


                    progressDialog = new ProgressDialog(view.getContext());
                    progressDialog.setCancelable(false);
                    progressDialog.setMessage("Downloading content.....");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    //progressDialog.setProgress(0);
                    progressDialog.setIndeterminate(true);
                    // progressDialog.setMax(100);
                    progressDialog.show();

                    progressBarStatus = 0;


                    dbOperations = new DBOperations(getApplicationContext());
                    code = code.replaceAll(" ", "%20");
                    requestDataContent(api.CONTENT_END_POINT+code, position);

                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));









    }
    void  insertCourse(Course_model data){
        dbOperations=new DBOperations(getApplicationContext());

        if(dbOperations.inCourse(data)){

            progressDialog.dismiss();

            StyleableToast st = new StyleableToast(getApplicationContext(), "Saved Successfully", Toast.LENGTH_SHORT);
            st.setBackgroundColor(Color.parseColor("#ff9040"));
            st.setTextColor(Color.WHITE);


            st.setMaxAlpha();
            st.show();

        }
else {
            StyleableToast st = new StyleableToast(getApplicationContext(), "Storage error 2", Toast.LENGTH_SHORT);
            st.setBackgroundColor(Color.parseColor("#ff9040"));
            st.setTextColor(Color.WHITE);
            st.setIcon(R.drawable.ic_error_outline_white_24dp);

            st.setMaxAlpha();
            st.show();
            progressDialog.dismiss();

        }

    }
void insert(ArrayList<Content_model> content_models,int position){

    dbOperations=new DBOperations(getApplicationContext());

    if(dbOperations.in(content_models)){

        content_models.clear();

        insertCourse(course_model.get(position));
    }
    else {
        StyleableToast st = new StyleableToast(getApplicationContext(), "Storage error 1", Toast.LENGTH_SHORT);
        st.setBackgroundColor(Color.parseColor("#ff9040"));
        st.setTextColor(Color.WHITE);
        st.setIcon(R.drawable.ic_error_outline_white_24dp);

        st.setMaxAlpha();
        st.show();
        progressDialog.dismiss();

    }
}
    private void getRecyclerView_sources() {
        requestDataSources(api.COURSES_END_POINT);
    }

    void filter(String text){
        ArrayList<Course_model> temp = new ArrayList();
        for(Course_model d: course_model){
            //or use .contains(text)
            if(d.getCOURSE_ID().toLowerCase().contains(text.toLowerCase())||d.getCOURSE_TITLE().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }

        }
try {
    adapter.updateList(temp);
}
catch (Exception nm){
    nm.printStackTrace();
}

    }

    public void setRecyclerView_courses(ArrayList<Course_model> course_modelArrayList) {
        try {
            course_model.clear();
        }
        catch (Exception MN){
            MN.printStackTrace();
        }
      course_model = course_modelArrayList;

        adapter = new AddRecyclerViewAdapter( getApplicationContext(),course_modelArrayList);
        adapter.notifyDataSetChanged();

        recyclerView_vertical = (RecyclerView) findViewById(R.id.recycle_view);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());

  //      if (this.isListView) {
//
            mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);


//        } else {
//
//            mStaggeredLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//
//
//        }


        recyclerView_vertical.setLayoutManager(mStaggeredLayoutManager);

        recyclerView_vertical.setItemAnimator(new DefaultItemAnimator());


        recyclerView_vertical.setAdapter(adapter);
        swipe_refresh_layout.setRefreshing(false);
    }



    public void requestDataSources(String uri) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<Course_model> course_modelsArrayList=new ArrayList<>();

                        if (response != null || !response.isEmpty()) {
                            try {
                                if(!course_modelsArrayList.isEmpty()) {
                                    course_modelsArrayList.clear();
                                }
                                course_modelsArrayList.clear();
                            }
                            catch (Exception m){
                                m.printStackTrace();
                            }
                            course_modelsArrayList = JsonParser.parseData(response);

                            setRecyclerView_courses(course_modelsArrayList);

                        } else {
                           swipe_refresh_layout.setRefreshing(false);
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        StyleableToast st = new StyleableToast(getApplicationContext(), "Network error", Toast.LENGTH_SHORT);
                        st.setBackgroundColor(Color.parseColor("#ff9040"));
                        st.setTextColor(Color.WHITE);
                        st.setIcon(R.drawable.ic_error_outline_white_24dp);

                        st.setMaxAlpha();
                        st.show();
                        swipe_refresh_layout.setRefreshing(false);
                        progressDialog.dismiss();


                    }
                });
        queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
        context = getApplicationContext();
    }


    public void requestDataContent(String uri, final int position) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ArrayList<Content_model> contentModelArrayList;


                        if (response != null || !response.isEmpty()) {

// ArrayList<Content_model> contentModelArrayLis;
//                                try {
//                                    if(!contentModelArrayList.isEmpty()) {
//                                        contentModelArrayList.clear();
//                                    }
//                                    contentModelArrayList.clear();
//                                }
//                                catch (Exception m){
//                                    m.printStackTrace();
//                                }
//

                            contentModelArrayList = ContentJsonParser.parseData(response);
                           // progressDialog.setProgress(50);

                            insert(contentModelArrayList,position);


                        }


                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        StyleableToast st = new StyleableToast(getApplicationContext(), "Network error", Toast.LENGTH_SHORT);
                        st.setBackgroundColor(Color.parseColor("#ff9040"));
                        st.setTextColor(Color.WHITE);
                        st.setIcon(R.drawable.ic_error_outline_white_24dp);

                        st.setMaxAlpha();
                        st.show();
                        swipe_refresh_layout.setRefreshing(false);
                        progressDialog.dismiss();
                    }
                });

        queue.add(stringRequest);


    }
}

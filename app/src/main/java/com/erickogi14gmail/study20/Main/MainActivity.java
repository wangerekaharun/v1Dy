package com.erickogi14gmail.study20.Main;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.study20.Main.Adapters.MainRecyclerViewAdapter;
import com.erickogi14gmail.study20.Main.Configs.api;
import com.erickogi14gmail.study20.Main.DB.DBOperations;
import com.erickogi14gmail.study20.Main.login.Login;
import com.erickogi14gmail.study20.Main.models.Course_model;
import com.erickogi14gmail.study20.Main.utills.HidingScrollListener;
import com.erickogi14gmail.study20.Main.utills.RecyclerTouchListener;
import com.erickogi14gmail.study20.R;

import com.erickogi14gmail.study20.Main.Read.ReadActivity;
import com.erickogi14gmail.study20.Main.addContent.AddCourse;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean loggedIn = false;
    private MainRecyclerViewAdapter adapter;

    Cursor cursor;
    DBOperations dbOperations =new DBOperations(this);
    static RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Course_model> data_model;
    RecyclerView lv;
    SwipeRefreshLayout swipe_refresh_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(api.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        loggedIn = sharedPreferences.getBoolean(api.LOGGEDIN_SHARED_PREF, false);
        Log.d("loginStatus",String.valueOf(loggedIn));
        if(!loggedIn){
            //We will start the Profile Activity
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
        else {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            lv = (RecyclerView) findViewById(R.id.recycle_view);
            swipe_refresh_layout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
            swipe_refresh_layout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
            swipe_refresh_layout.setBackgroundResource(android.R.color.white);
            swipe_refresh_layout.setColorSchemeResources(android.R.color.white, android.R.color.holo_purple, android.R.color.white);

            swipe_refresh_layout.setRefreshing(true);

            swipe_refresh_layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    swipe_refresh_layout.setRefreshing(true);
                    setRecyclerView();

                }
            });


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, AddCourse.class));
                }
            });

            setRecyclerView();
            lv.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), lv, new RecyclerTouchListener.ClickListener() {

                @Override
                public void onClick(View view, int position) {
                    Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                    intent.putExtra(api.COURSE_CODE, data_model.get(position).getCOURSE_ID());
                    startActivity(intent);

                }

                @Override
                public void onLongClick(View view, final int position) {

                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.remove_unit_dialog);
                    dialog.setTitle("DELETE COURSE");
                    Button button_delete = (Button) dialog.findViewById(R.id.dialog_button_yes);
                    Button button_keep = (Button) dialog.findViewById(R.id.dialog_button_no);

                    button_delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (dbOperations.deleteContent(data_model.get(position).getCOURSE_ID())) {
                                dbOperations.deleteCourse(data_model.get(position).getCOURSE_ID());
                            }

                            dialog.dismiss();
                            data_model.remove(position);
                            // notifyDataSetChanged();
                            adapter.notifyDataSetChanged();
                            setRecyclerView();
                        }
                    });
                    button_keep.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog.dismiss();
                        }
                    });


                    dialog.show();


                }
            }));

            lv.setOnScrollListener(new HidingScrollListener() {
                @Override
                public void onHide() {
                    fab.hide();
                }

                @Override
                public void onShow() {
                    fab.show();
                }
            });


        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setRecyclerView();
    }

    void setRecyclerView() {
//
        DBOperations dbOperations = new DBOperations(MainActivity.this);
        data_model = dbOperations.getCourseList();
        try {
            if (data_model.isEmpty()||data_model.equals(null)) {
                swipe_refresh_layout.setRefreshing(false);
                StyleableToast st = new StyleableToast(getApplicationContext(), "You Have No Saved Courses. Click the Add Button Below", Toast.LENGTH_SHORT);
                st.setBackgroundColor(Color.parseColor("#ff9040"));
                st.setTextColor(Color.WHITE);
                st.setIcon(R.drawable.ic_error_outline_white_24dp);

                st.setMaxAlpha();
                st.show();
                swipe_refresh_layout.setRefreshing(false);

            }
        else {



                adapter = new MainRecyclerViewAdapter( MainActivity.this,data_model);
                adapter.notifyDataSetChanged();


                mLayoutManager = new LinearLayoutManager(MainActivity.this);
                lv.setLayoutManager(mLayoutManager);
                lv.setItemAnimator(new DefaultItemAnimator());


                lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                swipe_refresh_layout.setRefreshing(false);
          }
        } catch (Exception a) {
a.printStackTrace();
            swipe_refresh_layout.setRefreshing(false);
            StyleableToast st = new StyleableToast(getApplicationContext(), "You Have No Saved Courses. Click the Add Button Below", Toast.LENGTH_SHORT);
            st.setBackgroundColor(Color.parseColor("#ff9040"));
            st.setTextColor(Color.WHITE);
            st.setIcon(R.drawable.ic_error_outline_white_24dp);

            st.setMaxAlpha();
            st.show();
            swipe_refresh_layout.setRefreshing(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT, " STUDY APP:Beta version now available  " +
                    "http://www.erickogi.co.ke/apps/study(preview).apk");
            in.setType("text/plain");
            startActivity(in);
            return true;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

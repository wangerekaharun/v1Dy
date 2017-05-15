package com.erickogi14gmail.study20.Main.Read;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

import com.erickogi14gmail.study20.Main.Configs.api;
import com.erickogi14gmail.study20.Main.DB.DBOperations;
import com.erickogi14gmail.study20.Main.models.Chapters;
import com.erickogi14gmail.study20.Main.utills.TouchyWebView;
import com.erickogi14gmail.study20.R;

import java.util.ArrayList;

public class ReadActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    TouchyWebView webView;
    DBOperations dbOperations = new DBOperations(this);
    private String code=null;
    private  int nav_id;
    private  String nav_items[];
    FloatingActionButton fabP,fab;

    protected void setNavigationItems(String[] items) {
        nav_items=items;
        final Menu menu = navigationView.getMenu();
        for (int a = 0; a < items.length; a++) {


            menu.add(items[a]);

        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         fab= (FloatingActionButton) findViewById(R.id.fab_next);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int to=nav_id+1;
                if(to<nav_items.length){
                    setWebView(dbOperations.getChapterContentByChapterByTitle(code,nav_items[to]));
                    nav_id=to;
                }
            }
        });

         fabP= (FloatingActionButton) findViewById(R.id.fab_prev);
        fabP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int to=nav_id-1;
                if(to<nav_items.length&&to>=0){
                    setWebView(dbOperations.getChapterContentByChapterByTitle(code,nav_items[to]));
                    nav_id=to;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);


        Intent intent = getIntent();
        code = intent.getStringExtra(api.COURSE_CODE);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Chapters> chapters = dbOperations.getChaptersByCourse(code);
        for (int count = 0; count < chapters.size(); count++) {

            list.add(chapters.get(count).getChapter_title());

        }
        String[] Arr = new String[list.size()];
        Arr = list.toArray(Arr);
        setNavigationItems(Arr);

        String html = dbOperations.getChapterContentByChapterByCourse(code, "1");


        webView = (TouchyWebView) findViewById(R.id.webView);
        webView.setOnScrollChangedCallback(new TouchyWebView.OnScrollChangedCallback() {
            @Override
            public void onScrollChange(WebView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY && scrollY > 0) {

                    fab.hide();
                    fabP.hide();
                  //  Toast.makeText(ReadActivity.this, "Scrolled", Toast.LENGTH_SHORT).show();
                }
                if (scrollY < oldScrollY) {
                    if (nav_id>=1){
                        fabP.show();
                    }
                    if(nav_id<nav_items.length-1) {
                        fab.show();
                    }

                  //  Toast.makeText(ReadActivity.this, "Scrolled", Toast.LENGTH_SHORT).show();
                }
            }
        });

         setWebView(html);
        nav_id=0;



    }

private void setWebView(String html){
    webView.getSettings().setJavaScriptEnabled(true);


//    webView.getSettings().setUseWideViewPort(true);
//    webView.getSettings().setLoadWithOverviewMode(true);
//    webView.getSettings().setAllowFileAccess(true);
   // webView.getSettings().setBuiltInZoomControls(true);
    webView.getSettings().setDisplayZoomControls(true);
   // webView.getSettings().setDefaultFontSize(25);
    webView.loadDataWithBaseURL(null,null,null,null,null);
    webView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "utf-8", null);


    webView.setWebChromeClient(new WebChromeClient() {


    });
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
        //getMenuInflater().inflate(R.menu.read, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
      //  String courseTilte=item.toString()

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
        String topicName = item.getTitle().toString();
        nav_id=item.getItemId();



        setWebView( dbOperations.getChapterContentByChapterByTitle(code,topicName));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

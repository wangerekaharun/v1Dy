package com.erickogi14gmail.study20.Main.News_Api_news;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.erickogi14gmail.study20.Main.Configs.api;
import com.erickogi14gmail.study20.Main.News_Api_news.utils.Categories;
import com.erickogi14gmail.study20.R;

public class News extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.news, menu);
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

        Intent intent = new Intent(News.this, Categories.class);
        if (id == R.id.nav_send) {


        } else if (id == R.id.nav_business) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_BUSINESS);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Business");
            startActivity(intent);
        } else if (id == R.id.nav_business) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_BUSINESS);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Business");
            startActivity(intent);
        } else if (id == R.id.nav_entertainment) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_ENTERTAINMENT);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Entertainment");
            startActivity(intent);

        } else if (id == R.id.nav_politics) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_POLITICS);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Political");
            startActivity(intent);

        } else if (id == R.id.nav_music) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_MUSIC);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Music");
            startActivity(intent);

        } else if (id == R.id.nav_science) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_SCIENCE);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Science/Nature");
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT, " Wish to share with you \n" +
                    "http://erickogi.co.ke/apps/news.apk");
            in.setType("text/plain");
            startActivity(in);
        } else if (id == R.id.nav_sports) {
            intent.putExtra(api.KEY_CATEGORY_INTENT, api.KEY_CATEGORY_SPORTS);
            intent.putExtra(api.KEY_CATEGORY_LABEL, "Sports");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

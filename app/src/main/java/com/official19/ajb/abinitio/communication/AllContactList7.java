package com.official19.ajb.abinitio.communication;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;

public class AllContactList7 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    String[] title={"Karansinh Gaherwar","Dhiraj Patil","Akash Gudadhe","Hemant Ghuge","Rushikesh Salunke",
    "Kaustubh Sankpal"};

    int[] images={R.drawable.laraib,R.drawable.laraib,R.drawable.akash,R.drawable.laraib,
            R.drawable.laraib,R.drawable.laraib};

    String[] description={"Automobile Dept","Civil Dept","Computer Dept","EnTC Dept","Instrumentation & Control Dept",
    "Mechanical Dept"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dept Student Co-Ordinator");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        setListView();

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivity.navigation(this ,id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setListView()
    {
        listView=(ListView)findViewById(R.id.lvFaculty);
        FacultyAdapter facultyAdapter = new FacultyAdapter(AllContactList7.this, title,description,images);
        listView.setAdapter(facultyAdapter);
    }
}

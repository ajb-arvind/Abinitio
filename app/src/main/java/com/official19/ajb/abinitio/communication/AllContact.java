package com.official19.ajb.abinitio.communication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.SimpleAdapter;
import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.civil;
import com.official19.ajb.abinitio.eventpackage.computer;
import com.official19.ajb.abinitio.eventpackage.entc;
import com.official19.ajb.abinitio.eventpackage.instru;

public class AllContact extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private ListView listView;
    String[] title={"Faculty Co-Ordinator","Faculty Incharge","Dept Faculty Incharge","Core Team","Web Team","Dept Student Co-Ordinator"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (ListView) findViewById(R.id.lvDepartments);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Contact Us");

        setupListView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        MainActivity.navigation(this,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setupListView() {

        SimpleAdapter simpleAdapter = new SimpleAdapter(AllContact.this, title,null);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        startActivity(new Intent(getApplicationContext(), AllContactList.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), AllContactList2.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), AllContactList3.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), AllContactList4.class));
                        break;
                    case 0:
                        startActivity(new Intent(getApplicationContext(), AllContactList5.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), AllContactList7.class));
                        break;


                }
            }
        });

    }

}

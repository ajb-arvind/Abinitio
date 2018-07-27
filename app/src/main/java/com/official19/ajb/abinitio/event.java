package com.official19.ajb.abinitio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.civil;
import com.official19.ajb.abinitio.eventpackage.computer;
import com.official19.ajb.abinitio.eventpackage.entc;
import com.official19.ajb.abinitio.eventpackage.instru;
import com.official19.ajb.abinitio.eventpackage.mechanical;

public class event extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (ListView) findViewById(R.id.lvDepartments);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Events");

        setupListView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        MainActivity.navigation(this,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setupListView() {
        String[] title = getResources().getStringArray(R.array.Departments);
        SimpleAdapter simpleAdapter = new SimpleAdapter(event.this, title,null);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), automobile.class));
                        finish();
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), civil.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), computer.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), entc.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(), instru.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(), mechanical.class));
                        break;
                }
            }
        });

    }

}

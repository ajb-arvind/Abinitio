package com.official19.ajb.abinitio.communication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.SimpleAdapter;
import com.official19.ajb.abinitio.event;
import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.civil;
import com.official19.ajb.abinitio.eventpackage.computer;
import com.official19.ajb.abinitio.eventpackage.entc;
import com.official19.ajb.abinitio.eventpackage.instru;
import com.official19.ajb.abinitio.eventpackage.mechanical;

public class WorkshopActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    public CardView cardView1, cardView2;
    public TextView textWork1,textWork2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Events");

        cardView1 = (CardView)findViewById(R.id.card1);
        cardView2 = (CardView)findViewById(R.id.card2);

        textWork1=(TextView)findViewById(R.id.tvRulesHidden);
        textWork2=(TextView)findViewById(R.id.tvEventHidden);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textWork1.getVisibility() == view.VISIBLE)
                {
                    textWork1.setVisibility(view.GONE);
                }else{
                    textWork1.setVisibility(view.VISIBLE);
                }
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textWork2.getVisibility() == view.VISIBLE)
                {
                    textWork2.setVisibility(view.GONE);
                }else{
                    textWork2.setVisibility(view.VISIBLE);
                }
            }
        });
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

}

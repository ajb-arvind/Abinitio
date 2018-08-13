package com.official19.ajb.abinitio.other;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.eventpackage.computer;

public class gcoearaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView CollegeImage;
    TextView CollegeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcoeara);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUI();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent=getIntent();
        String Number=intent.getStringExtra("Gcoeara");

        switch (Number)
        {
            case "0":
                CollegeImage.setImageResource(R.drawable.principal);
                CollegeText.setText("");
                break;


            case "1":
                CollegeImage.setImageResource(R.drawable.college);
                CollegeText.setText("");
                break;

            case "2":
                CollegeImage.setImageResource(R.drawable.ab);
                CollegeText.setText("");
                break;
        }
    }

    void setUI(){
        CollegeImage = (ImageView)findViewById(R.id.ivCollegeImage);
        CollegeText = (TextView)findViewById(R.id.tvCollegeText);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivity.navigation(this ,id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

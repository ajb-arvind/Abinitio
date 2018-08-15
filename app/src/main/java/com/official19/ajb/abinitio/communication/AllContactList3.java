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

public class AllContactList3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    String[] title={"Sanjana Jadhav","Prathamesh Pathak","Mukul Kadaskar","Pravin Nikure","Chinmay Patwari","Girish Deshpande",
            "Pooja Chavan","Dipti Pawar","Sonal More","Akash Mule","Mujahid Attar","Deepali Bagul"
    ,"Atul Gade"};

    int[] images={R.drawable.sanjana1,R.drawable.prathamesh,R.drawable.mukul1,R.drawable.pravin1,R.drawable.chinmay,R.drawable.girish,
            R.drawable.pooja,R.drawable.dipti,R.drawable.sonal,R.drawable.akashmule,R.drawable.mujahid,R.drawable.dipali,R.drawable.atul};

    String[] description={"Student Co-ordinator\nContact:9404137191","Digital Head\nContact:8668704471","Documentation Head\nContact:9850067211","Sponsorship Head\nContact:8975588243","Treasurer\nContact:8007993570",
            "Publicity Head(boy)\nContact:8793887580",
    "Publicity Head(girl)\nContact:7028777972","Ladies Representative\nContact:7448215471",
    "Decoration Head\nContact:9067067272","Decoration Co-Head\nContact:7038620991","Management Team\nContact:9096689230","Management Team\nContact:9850140874","Management Team\nContact:9130716452"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Core Team");

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
        FacultyAdapter facultyAdapter = new FacultyAdapter(AllContactList3.this, title,description,images);
        listView.setAdapter(facultyAdapter);
    }
}


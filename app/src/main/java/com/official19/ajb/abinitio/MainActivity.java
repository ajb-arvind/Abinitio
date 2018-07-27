package com.official19.ajb.abinitio;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
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
import com.official19.ajb.abinitio.other.co_ordinator;
import com.official19.ajb.abinitio.other.gallary;
import com.official19.ajb.abinitio.communication.contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private CardView cardView;
    private TextView Day, Hrs, Min, Sec;
    int days = 0, hrss = 0, mins = 0, secs = 0;
    public static int ABINITIO_DAY = 31 , ABINITIO_HRS = 11, ABINITIO_MIN = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView=(ListView)findViewById(R.id.lvMain);
        cardView = (CardView)findViewById(R.id.cv_main);

        setUIViews();

        setSupportActionBar(toolbar);
        setTitle("Home");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setupListView();

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                DateFormat dd = new SimpleDateFormat("dd");
                                DateFormat hh = new SimpleDateFormat("hh");
                                DateFormat mm = new SimpleDateFormat("mm");
                                DateFormat ss = new SimpleDateFormat("ss");

                                String day = dd.format(Calendar.getInstance().getTime());
                                String hrs = hh.format(Calendar.getInstance().getTime());
                                String min = mm.format(Calendar.getInstance().getTime());
                                String sec = ss.format(Calendar.getInstance().getTime());

                                days = ABINITIO_DAY - Integer.parseInt(day);

                                if(Integer.parseInt(hrs) < 24 && Integer.parseInt(hrs) >= 11){
                                    hrss = 24 - Integer.parseInt(hrs) + ABINITIO_HRS-1;   //pm
                                }
                                else
                                    hrss = ABINITIO_HRS - Integer.parseInt(hrs) - 1;        //am

                                mins = ABINITIO_MIN - Integer.parseInt(min);
                                secs = ABINITIO_MIN - Integer.parseInt(sec);

                                Day.setText(String.valueOf(days));
                                Hrs.setText(String.valueOf(hrss));
                                Min.setText(String.valueOf(mins));
                                Sec.setText(String.valueOf(secs));
                            }
                        });
                    }

                }
                catch (InterruptedException e){

                }
            }
        };
        t.start();

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
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("no", null).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        navigation(this,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUIViews(){
        Day = (TextView)findViewById(R.id.tvDay);
        Hrs = (TextView)findViewById(R.id.tvHrs);
        Min = (TextView)findViewById(R.id.tvMin);
        Sec = (TextView)findViewById(R.id.tvSec);
    }


    private void setupListView()
    {

        final String[] title = getResources().getStringArray(R.array.Title);
        String[] description  = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,title,description);
        listView.setAdapter(simpleAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Toast.makeText(MainActivity.this,"Timetable not created",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,event.class));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;

                }
            }
        });

    }




    public static void navigation(Activity activity, int id){
        switch (id){


            case R.id.nav_home:
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
                break;

            case R.id.nav_auto:             activity.startActivity(new Intent(activity, automobile.class));
                break;

            case R.id.nav_comp:             activity.startActivity(new Intent(activity, computer.class));
                break;

            case R.id.nav_civil:             activity.startActivity(new Intent(activity, civil.class));
                break;

            case R.id.nav_entc:             activity.startActivity(new Intent(activity, entc.class));
                break;

            case R.id.nav_instru:             activity.startActivity(new Intent(activity, instru.class));
                break;

            case R.id.nav_mech:             activity.startActivity(new Intent(activity, mechanical.class));
                break;

            case R.id.nav_co_ordinator:             activity.startActivity(new Intent(activity, co_ordinator.class));
                break;

            case R.id.nav_gallry:             activity.startActivity(new Intent(activity, gallary.class));
                break;

            case R.id.nav_share:             //activity.startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_send:             //activity.startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_contact:             activity.startActivity(new Intent(activity, contact.class));
                break;
        }
    }

}

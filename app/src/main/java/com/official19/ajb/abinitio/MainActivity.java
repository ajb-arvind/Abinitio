package com.official19.ajb.abinitio;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

import com.official19.ajb.abinitio.allevent.GameActivity;
import com.official19.ajb.abinitio.communication.AllContact;
import com.official19.ajb.abinitio.communication.WorkshopActivity;
import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.civil;
import com.official19.ajb.abinitio.eventpackage.computer;
import com.official19.ajb.abinitio.eventpackage.entc;
import com.official19.ajb.abinitio.eventpackage.instru;
import com.official19.ajb.abinitio.eventpackage.mechanical;
import com.official19.ajb.abinitio.other.co_ordinator;
import com.official19.ajb.abinitio.other.gallary;
import com.official19.ajb.abinitio.other.gcoearaActivity;
import com.official19.ajb.abinitio.communication.contact;
import com.official19.ajb.abinitio.co_ordinatorlogin.loginScreen;
import com.official19.ajb.abinitio.timetablepackage.TimetableActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    public CardView cardView1, cardView2, cardView3, cardView4, cardView5;
    private TextView Day, Hrs, Min, Sec;
    public FloatingActionButton Float1,Float2,Float3,Float4, Float5;
    int days = 0, hrss = 0, mins = 0, secs = 0;
    public static int ABINITIO_DAY = 31 , ABINITIO_HRS = 11, ABINITIO_MIN = 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView=(ListView)findViewById(R.id.lvMain);

        setUIViews();
        newActivity();

        setSupportActionBar(toolbar);
        setTitle("Home");

        ExpandFloat();

        Float2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(openFacebook(MainActivity.this)));
            }
        });

        Float3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(openInstagram(MainActivity.this)));
            }
        });

        Float4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(openWebsite(MainActivity.this)));
            }
        });


        //setupListView();

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
                                    hrss = 23 - Integer.parseInt(hrs) + ABINITIO_HRS -1;   //pm
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


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

        cardView1 = (CardView)findViewById(R.id.card1);
        cardView2 = (CardView)findViewById(R.id.card2);
        cardView3 = (CardView)findViewById(R.id.card3);
        cardView4 = (CardView)findViewById(R.id.card4);
        cardView5 = (CardView)findViewById(R.id.card5);

        Float1 = findViewById(R.id.fab1);
        Float2 = findViewById(R.id.fab2);
        Float3 = findViewById(R.id.fab3);
        Float4 = findViewById(R.id.fab4);
        Float5 = findViewById(R.id.fab5);
    }

    public void newActivity(){
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TimetableActivity.class));
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), event.class));
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(getApplicationContext(), gcoearaActivity.class);
                intent1.putExtra("Gcoeara","4");
                startActivity(intent1);
                //startActivity(new Intent(getApplicationContext(), contact.class));
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), loginScreen.class));
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), WorkshopActivity.class));
            }
        });
    }


    void ExpandFloat(){
        Float1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Float2.getVisibility() == view.VISIBLE){
                    Float1.setImageResource(R.drawable.ic_float1);
                    Float2.setVisibility(view.GONE);
                    Float3.setVisibility(view.GONE);
                    Float4.setVisibility(view.GONE);
                }
                else{
                    Float1.setImageResource(R.drawable.ic_float1_close);
                    Float2.setVisibility(view.VISIBLE);
                    Float3.setVisibility(view.VISIBLE);
                    Float4.setVisibility(view.VISIBLE);
                }
            }
        });
    }
    /*private void setupListView()
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
                        startActivity(new Intent(MainActivity.this,collapse.class));
                        break;
                    case 3:
                        break;

                }
            }
        });

    }*/

    public static Intent openFacebook(Context context){
        try{
            context.getPackageManager().
                    getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/184421188766720"));
        }catch (Exception e){
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Abinitio2017"));
        }
    }

    public static Intent openInstagram(Context context){
        Uri uri = Uri.parse("https://www.instagram.com/abinitio_2k18/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            return likeIng;
        } catch (Exception e) {
            return  new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/abinitio_2k18/"));
        }
    }

    public static Intent openWebsite(Context context){
        return  new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://gcoeara.ac.in"));
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



            case R.id.nav_gallry:             activity.startActivity(new Intent(activity, gallary.class));
                break;

            /*case R.id.nav_principal_desk:           Intent intent0= new Intent(activity, gcoearaActivity.class);
                                                    intent0.putExtra("Gcoeara","0");
                                                    activity.startActivity(intent0);
                break;*/

            case R.id.nav_about_gcoeara:            Intent intent1= new Intent(activity, gcoearaActivity.class);
                                                    intent1.putExtra("Gcoeara","1");
                                                    activity.startActivity(intent1);
                break;

            case R.id.nav_about_us:             Intent intent2= new Intent(activity, gcoearaActivity.class);
                                                    intent2.putExtra("Gcoeara","2");
                                                    activity.startActivity(intent2);
                break;

            case R.id.nav_developer:             activity.startActivity(new Intent(activity, contact.class));
                break;

            case R.id.nav_contact:             activity.startActivity(new Intent(activity, AllContact.class));
                break;


        }
    }

}

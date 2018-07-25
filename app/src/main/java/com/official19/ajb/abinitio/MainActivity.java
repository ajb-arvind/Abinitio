package com.official19.ajb.abinitio;

import android.content.Context;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.official19.ajb.abinitio.event.automobile;
import com.official19.ajb.abinitio.event.computer;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView=(ListView)findViewById(R.id.lvMain);


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
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        switch (id){
            case R.id.nav_home:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;

            case R.id.nav_auto:             startActivity(new Intent(this, automobile.class));

                break;

            case R.id.nav_comp:             startActivity(new Intent(this, computer.class));
                break;

            case R.id.nav_civil:             startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_entc:             startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_instru:             startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_mech:             startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_share:             startActivity(new Intent(this, automobile.class));
                break;

            case R.id.nav_send:             startActivity(new Intent(this, automobile.class));
                break;
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setupListView()
    {
        String[] title = getResources().getStringArray(R.array.Title);
        String[] description  = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,title,description);
        listView.setAdapter(simpleAdapter);

    }


    public class SimpleAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,description,click;
        private String[] titlearray,descriptionarray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title,String[] description)
        {
            mcontext = context;
            titlearray = title;
            descriptionarray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titlearray.length;
        }

        @Override
        public Object getItem(int i) {
            return titlearray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view ==null)
            {
                view = layoutInflater.inflate(R.layout.list_content_main,null);
            }

            title=(TextView)view.findViewById(R.id.tvTitle);
            imageView=(ImageView)view.findViewById(R.id.ivMain);
            description=(TextView)view.findViewById(R.id.tvDescription);
            click=(TextView)view.findViewById(R.id.tvClick);

            if (titlearray[i].equalsIgnoreCase("Timetable")){
                title.setText("Timetable");
                description.setText("Description 1");
                imageView.setImageResource(R.drawable.calender);
            }else if (titlearray[i].equalsIgnoreCase("Departments")){
                title.setText("Departments");
                description.setText("Description 2");
                imageView.setImageResource(R.drawable.book);
            }else if (titlearray[i].equalsIgnoreCase("Coordinators")){
                title.setText("Coodinators");
                description.setText("Description 3");
                imageView.setImageResource(R.drawable.contact);
            }else if (titlearray[i].equalsIgnoreCase("Settings")){
                title.setText("Settings");
                description.setText("Description 4");
                imageView.setImageResource(R.drawable.settings);
            }

            return view;
        }
    }

}

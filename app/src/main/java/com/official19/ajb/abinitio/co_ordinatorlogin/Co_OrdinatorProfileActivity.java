package com.official19.ajb.abinitio.co_ordinatorlogin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;

public class Co_OrdinatorProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView Coordinator;
    private Button Logout, save;
    public CardView round1, round2, round3, changePassword;
    public TextView round1Text, round2Text, round3Text, Profile;
    static final int DIALOG_ID =0;
    int minute_x, hour_x, roundNo;
    String setAmPm, Time;
    TimePickerDialog timePickerDialog;
    String name, email, department, event, round1_fire, round2_fire, round3_fire;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co__ordinator_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SetUIViews();
        setTimerPiker();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");


            Logout=findViewById(R.id.btnSave);

            firebaseAuth=FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();

           /* Logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firebaseAuth.signOut();
                    startActivity(new Intent(Co_OrdinatorProfileActivity.this,loginScreen.class));
                    finish();
                }
            });*/

           getUserData();

           saveTimerDataFire();

           changePassword.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent= new Intent(getApplicationContext(), passwordActivity.class);
                   intent.putExtra("Gcoeara","0");
                   startActivity(intent);
               }
           });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    void SetUIViews(){
        save = (Button)findViewById(R.id.btnSave);
        round1 = (CardView)findViewById(R.id.round1CV);
        round2 = (CardView)findViewById(R.id.round2CV);
        round3 = (CardView)findViewById(R.id.round3CV);
        round1Text = (TextView)findViewById(R.id.round1TV);
        round2Text = (TextView)findViewById(R.id.round2TV);
        round3Text = (TextView)findViewById(R.id.round3TV);
        Profile = (TextView)findViewById(R.id.profileTV);
        changePassword = (CardView)findViewById(R.id.changePasswordCV);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        MainActivity.navigation(this ,id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_logout) {
            firebaseAuth.signOut();
            startActivity(new Intent(Co_OrdinatorProfileActivity.this,loginScreen.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    void getUserData(){
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                String profile = userProfile.getName()+" "+userProfile.email;
                Profile.setText(profile);
                if(!userProfile.getRound1().equals(""))
                    round1Text.setText(userProfile.getRound1());
                if(!userProfile.getRound2().equals(""))
                    round2Text.setText(userProfile.getRound2());
                if(!userProfile.getRound3().equals(""))
                    round3Text.setText(userProfile.getRound3());

                name = userProfile.getName();
                email = userProfile.getEmail();
                department = userProfile.getDepartment();
                event = userProfile.getEvent();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    void setTimerPiker(){
        round1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(Co_OrdinatorProfileActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        if(i >=12)
                            setAmPm = "PM";
                        else
                            setAmPm = "AM";

                        Time = i+" : "+i1+" "+setAmPm;
                        round1Text.setText(Time);
                    }
                }, hour_x, minute_x, false);
                timePickerDialog.show();
            }
        });

        round2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(Co_OrdinatorProfileActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        if(i >=12)
                            setAmPm = "PM";
                        else
                            setAmPm = "AM";

                        Time = i+" : "+i1+" "+setAmPm;
                        round2Text.setText(Time);
                    }
                }, hour_x, minute_x, false);
                timePickerDialog.show();
            }
        });

        round3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog = new TimePickerDialog(Co_OrdinatorProfileActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        if(i >=12)
                            setAmPm = "PM";
                        else
                            setAmPm = "AM";

                        Time = i+" : "+i1+" "+setAmPm;
                        round3Text.setText(Time);
                    }
                }, hour_x, minute_x, false);
                timePickerDialog.show();
            }
        });
    }


    void saveTimerDataFire(){
        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                round1_fire = round1Text.getText().toString();
                round2_fire = round2Text.getText().toString();
                round3_fire = round3Text.getText().toString();

                UserProfile userProfile=new UserProfile(name,email,department,event, round1_fire, round2_fire, round3_fire);
                databaseReference.setValue(userProfile);
                Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
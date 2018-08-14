package com.official19.ajb.abinitio.timetablepackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.co_ordinatorlogin.UserProfile;

import java.util.ArrayList;

public class TimetableActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView recyclerView,recyclerView1,recyclerView2,
    recyclerView3,recyclerView4,recyclerView5;
    ArrayList<Integer> images =new ArrayList<>();
    LinearLayoutManager linearLayoutManager,linearLayoutManager1,linearLayoutManager2,
    linearLayoutManager3,linearLayoutManager4,linearLayoutManager5;
    private Toolbar toolbar;
    public int ptrUID;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    String[] UIDAuto={"l6rtWi2hhMQXkoLohqnmWxnD3kq1","wkeujkUfLAb6DTt9nfp3uJ0nXYt2","CTMfjSf1rQUHZPwx4h5Xz1PUy5t1","GvD5WWyt00UbUgKWl60vzrUM0Wv2"};
    String[] UIDCivil={"nsrzV56qcoRBtrvT3TkeGw47rXz1","IW0AOJTLjpYoqPJ2XzngLBCo0o33","pNNVhofKIFXJIuxnMUkS57vnxar2","aTcPY0ufzAbnjhJwtf2f6Wmvaij2"};
    String[] UIDComp={"BoXFB7qBgyaHnu6kW1bJTH46qA22","1HLNVIUl53WqIpe5JvADky8yhES2","pVEwefICKLhnMsBhf8YN2tyLw1n1","GUGdvxGM7qd3DXo6G29UC1stGtM2","TMpKViU2wtZ0uu3XYjJUdsfVTLJ2"};
    String[] UIDEntc={"prHN5ZCMTVb3HDPj15Frh7WvkLJ3","dTo29VTUgZTZe4CrIVwU9cupNnF2","3ltheje9OHO84wfKUubONwoebMi1","9XuCuO5JpiTn9lPbeXFKRNmQi5k1"};
    String[] UIDInstru={"oJ4kQ9G5tlXfUpm5i4h6LEHJ0bk1","8ddP488U3Bg830ILueBasnnzdv22","Gzyq6tcv0rNcOP4KN9MmzHXROf33","mT1rgfdWg9WazPu0PnmIUmhawHs1"};
    String[] UIDMEch={"S06tKohHcITdy4ogZxebdyEaNW52","0ZrUvnDtOnWMPf6R7zGOvLU1i8k1","SDOHF70ERhXRshbVRYw30AjTOCs2","40Ew25SN3zZQCqAu9YKKlMiQ2zl1"};


    public int[] logosauto ={R.drawable.autologo1,R.drawable.autologo2,R.drawable.autologo3,R.drawable.autologo4};
    public int[] logoscivil ={R.drawable.civillogo1,R.drawable.civillogo2,R.drawable.civillogo3,R.drawable.cicillogo4};
    public int[] logoscomp ={R.drawable.complogo1,R.drawable.complogo2,R.drawable.complogo3,R.drawable.complogo4,R.drawable.complogo5};
    public int[] logosentc ={R.drawable.entclogo1,R.drawable.entclogo2,R.drawable.entclogo3,R.drawable.entclogo4};
    public int[] logosinstru ={R.drawable.instrulogo1,R.drawable.instrulogo2,R.drawable.instrulogo3,R.drawable.instrulogo4};
    public int[] logosmech ={R.drawable.mechlogo1,R.drawable.mechlogo2,R.drawable.mechlogo3,R.drawable.mechlogo4};


    UserProfile[] userProfileAuto = new UserProfile[UIDAuto.length];
    UserProfile[] userProfileCivil = new UserProfile[UIDCivil.length];
    UserProfile[] userProfileComp = new UserProfile[UIDComp.length];
    UserProfile[] userProfileEntc = new UserProfile[UIDEntc.length];
    UserProfile[] userProfileInstru = new UserProfile[UIDInstru.length];
    UserProfile[] userProfileMech = new UserProfile[UIDMEch.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TimeTable");

        addImages();

        linearManager();
        recycleView();
        layoutMan();
        setadap();

        //getUserData();

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

    /*void getUserData(){
            for(i=0; i<UIDarray.length; i++){
                DatabaseReference databaseReference = firebaseDatabase.getReference(UIDarray[i]);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    final int j = i;
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        userProfile[j] = dataSnapshot.getValue(UserProfile.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
        }
    }*/


    public void addImages()
    {
        images.add(R.drawable.ab1);
        images.add(R.drawable.ab2);
        images.add(R.drawable.ab3);
        images.add(R.drawable.ab4);
        images.add(R.drawable.ab5);

    }

    public void linearManager()
    {
        linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager1=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager2=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager3=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager4=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager5=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);

    }

    public void recycleView()
    {
        recyclerView=(RecyclerView)findViewById(R.id.rvListAutoGames);
        recyclerView1=(RecyclerView)findViewById(R.id.rvListCivilGames);
        recyclerView2=(RecyclerView)findViewById(R.id.rvListCompGames);
        recyclerView3=(RecyclerView)findViewById(R.id.rvListEnTCGames);
        recyclerView4=(RecyclerView)findViewById(R.id.rvListInstruGames);
        recyclerView5=(RecyclerView)findViewById(R.id.rvListMechGames);
    }

    public void layoutMan()
    {
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        recyclerView4.setLayoutManager(linearLayoutManager4);
        recyclerView5.setLayoutManager(linearLayoutManager5);

    }

    public void setadap()
    {
        String[] Auto_event=getResources().getStringArray(R.array.Auto_Event);
        String[] Civil_event=getResources().getStringArray(R.array.Civil_Event);
        String[] Comp_event=getResources().getStringArray(R.array.Comp_Event);
        String[] EnTC_event=getResources().getStringArray(R.array.Entc_Event);
        String[] Instru_event=getResources().getStringArray(R.array.Instru_Event);
        String[] Mech_event=getResources().getStringArray(R.array.Mech_Event);



        RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(this,logosauto,Auto_event, "auto");
        recyclerView.setAdapter(recyclerViewAdapter);
        RecyclerViewAdapter recyclerViewAdapter1 =new RecyclerViewAdapter(this,logoscivil,Civil_event,"civil");
        recyclerView1.setAdapter(recyclerViewAdapter1);
        RecyclerViewAdapter recyclerViewAdapter2 =new RecyclerViewAdapter(this,logoscomp,Comp_event,"comp");
        recyclerView2.setAdapter(recyclerViewAdapter2);
        RecyclerViewAdapter recyclerViewAdapter3 =new RecyclerViewAdapter(this,logosentc,EnTC_event,"entc");
        recyclerView3.setAdapter(recyclerViewAdapter3);
        RecyclerViewAdapter recyclerViewAdapter4 =new RecyclerViewAdapter(this,logosinstru,Instru_event,"instru");
        recyclerView4.setAdapter(recyclerViewAdapter4);
        RecyclerViewAdapter recyclerViewAdapter5 =new RecyclerViewAdapter(this,logosmech,Mech_event,"mech");
        recyclerView5.setAdapter(recyclerViewAdapter5);

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
    {
        Context mcontext;
        String[] EventNames;
        String department;
        int[] images ;
        LayoutInflater layoutInflater;

        public RecyclerViewAdapter(Context context,int[] images, String[] EventNames, String department )
        {
            this.mcontext=context;
            this.images=images;
            this.EventNames=EventNames;
            this.department = department;
            layoutInflater =LayoutInflater.from(mcontext);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= layoutInflater.inflate(R.layout.list_timetable,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            holder.imageList.setImageResource(images[position]);
            holder.Title.setText(EventNames[position]);

            switch (department) {
                case "auto":
                    switchAuto(position, holder);
                    break;

                case "civil":
                    switchCivil(position, holder);
                    break;

                case "comp":
                    switchComp(position, holder);
                    break;

                case "entc":
                    switchEntc(position, holder);
                    break;

                case "instru":
                    switchInstru(position, holder);
                    break;

                case "mech":
                    switchMech(position, holder);
                    break;

            }
        }


        @Override
        public int getItemCount() {
            return EventNames.length;
        }

        public void switchAuto(int i, final ViewHolder holder){


            switch (i){
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDAuto[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileAuto[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileAuto[0].getRound1());
                            holder.RoundTime2.setText(userProfileAuto[0].getRound2());
                            holder.RoundTime3.setText(userProfileAuto[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDAuto[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileAuto[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileAuto[1].getRound1());
                            holder.RoundTime2.setText(userProfileAuto[1].getRound2());
                            holder.RoundTime3.setText(userProfileAuto[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDAuto[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileAuto[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileAuto[2].getRound1());
                            holder.RoundTime2.setText(userProfileAuto[2].getRound2());
                            holder.RoundTime3.setText(userProfileAuto[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDAuto[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileAuto[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileAuto[3].getRound1());
                            holder.RoundTime2.setText(userProfileAuto[3].getRound2());
                            holder.RoundTime3.setText(userProfileAuto[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public void switchCivil(int i, final ViewHolder holder){
            switch (i){
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDCivil[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileCivil[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileCivil[0].getRound1());
                            holder.RoundTime2.setText(userProfileCivil[0].getRound2());
                            holder.RoundTime3.setText(userProfileCivil[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDCivil[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileCivil[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileCivil[1].getRound1());
                            holder.RoundTime2.setText(userProfileCivil[1].getRound2());
                            holder.RoundTime3.setText(userProfileCivil[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDCivil[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileCivil[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileCivil[2].getRound1());
                            holder.RoundTime2.setText(userProfileCivil[2].getRound2());
                            holder.RoundTime3.setText(userProfileCivil[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDCivil[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileCivil[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileCivil[3].getRound1());
                            holder.RoundTime2.setText(userProfileCivil[3].getRound2());
                            holder.RoundTime3.setText(userProfileCivil[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public void switchComp(int i, final ViewHolder holder){
            switch (i) {
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDComp[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileComp[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileComp[0].getRound1());
                            holder.RoundTime2.setText(userProfileComp[0].getRound2());
                            holder.RoundTime3.setText(userProfileComp[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDComp[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileComp[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileComp[1].getRound1());
                            holder.RoundTime2.setText(userProfileComp[1].getRound2());
                            holder.RoundTime3.setText(userProfileComp[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDComp[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileComp[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileComp[2].getRound1());
                            holder.RoundTime2.setText(userProfileComp[2].getRound2());
                            holder.RoundTime3.setText(userProfileComp[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDComp[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileComp[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileComp[3].getRound1());
                            holder.RoundTime2.setText(userProfileComp[3].getRound2());
                            holder.RoundTime3.setText(userProfileComp[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;

                case 4:
                    DatabaseReference databaseReference4 = firebaseDatabase.getReference(UIDComp[4]);
                    databaseReference4.addValueEventListener(new ValueEventListener() {
                        final int j = 4;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileComp[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileComp[4].getRound1());
                            holder.RoundTime2.setText(userProfileComp[4].getRound2());
                            holder.RoundTime3.setText(userProfileComp[4].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public void switchEntc(int i, final ViewHolder holder){
            switch (i){
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDEntc[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileEntc[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileEntc[0].getRound1());
                            holder.RoundTime2.setText(userProfileEntc[0].getRound2());
                            holder.RoundTime3.setText(userProfileEntc[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDEntc[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileEntc[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileEntc[1].getRound1());
                            holder.RoundTime2.setText(userProfileEntc[1].getRound2());
                            holder.RoundTime3.setText(userProfileEntc[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDEntc[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileEntc[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileEntc[2].getRound1());
                            holder.RoundTime2.setText(userProfileEntc[2].getRound2());
                            holder.RoundTime3.setText(userProfileEntc[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDEntc[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileEntc[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileEntc[3].getRound1());
                            holder.RoundTime2.setText(userProfileEntc[3].getRound2());
                            holder.RoundTime3.setText(userProfileEntc[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public void switchInstru(int i, final ViewHolder holder){
            switch (i){
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDInstru[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileInstru[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileInstru[0].getRound1());
                            holder.RoundTime2.setText(userProfileInstru[0].getRound2());
                            holder.RoundTime3.setText(userProfileInstru[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDInstru[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileInstru[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileInstru[1].getRound1());
                            holder.RoundTime2.setText(userProfileInstru[1].getRound2());
                            holder.RoundTime3.setText(userProfileInstru[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDInstru[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileInstru[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileInstru[2].getRound1());
                            holder.RoundTime2.setText(userProfileInstru[2].getRound2());
                            holder.RoundTime3.setText(userProfileInstru[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDInstru[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileInstru[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileInstru[3].getRound1());
                            holder.RoundTime2.setText(userProfileInstru[3].getRound2());
                            holder.RoundTime3.setText(userProfileInstru[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public void switchMech(int i, final ViewHolder holder){
            switch (i){
                case 0:
                    DatabaseReference databaseReference = firebaseDatabase.getReference(UIDMEch[0]);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        final int j = 0;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileMech[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileMech[0].getRound1());
                            holder.RoundTime2.setText(userProfileMech[0].getRound2());
                            holder.RoundTime3.setText(userProfileMech[0].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                    break;
                case 1:
                    DatabaseReference databaseReference1 = firebaseDatabase.getReference(UIDMEch[1]);
                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        final int j = 1;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileMech[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileMech[1].getRound1());
                            holder.RoundTime2.setText(userProfileMech[1].getRound2());
                            holder.RoundTime3.setText(userProfileMech[1].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 2:
                    DatabaseReference databaseReference2 = firebaseDatabase.getReference(UIDMEch[2]);
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        final int j = 2;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileMech[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileMech[2].getRound1());
                            holder.RoundTime2.setText(userProfileMech[2].getRound2());
                            holder.RoundTime3.setText(userProfileMech[2].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
                case 3:
                    DatabaseReference databaseReference3 = firebaseDatabase.getReference(UIDMEch[3]);
                    databaseReference3.addValueEventListener(new ValueEventListener() {
                        final int j = 3;

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            userProfileMech[j] = dataSnapshot.getValue(UserProfile.class);
                            holder.RoundTime1.setText(userProfileMech[3].getRound1());
                            holder.RoundTime2.setText(userProfileMech[3].getRound2());
                            holder.RoundTime3.setText(userProfileMech[3].getRound3());
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    break;
            }
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageList;
            public TextView Title,Fees
                    ,Round1,Round2,Round3,
                    RoundTime1,RoundTime2,RoundTime3;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageList=(ImageView)itemView.findViewById(R.id.ivtimetable);
                Title=(TextView)itemView.findViewById(R.id.tvtimetable);

                Round1=(TextView)itemView.findViewById(R.id.tvRound1);
                Round2=(TextView)itemView.findViewById(R.id.tvRound2);
                Round3=(TextView)itemView.findViewById(R.id.tvRound3);

                RoundTime1=(TextView)itemView.findViewById(R.id.tvRound1Time);
                RoundTime2=(TextView)itemView.findViewById(R.id.tvRound2Time);
                RoundTime3=(TextView)itemView.findViewById(R.id.tvRound3Time);
            }
        }


        }
}

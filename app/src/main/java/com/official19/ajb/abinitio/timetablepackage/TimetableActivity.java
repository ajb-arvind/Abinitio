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

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;



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

        getUserData();

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

    void getUserData(){
        DatabaseReference databaseReference = firebaseDatabase.getReference("3I8Mo3V28ERNSdua1harUQIP86a2");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                String profile = userProfile.getName()+" "+userProfile.email;
                Toast.makeText(getApplicationContext(), profile, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void addImages()
    {
        images.add(R.drawable.ab1);
        images.add(R.drawable.ab2);
        images.add(R.drawable.ab3);
        images.add(R.drawable.ab4);
        images.add(R.drawable.ab5);
        images.add(R.drawable.ab6);
        images.add(R.drawable.ab7);
        images.add(R.drawable.ab8);

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
        RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(this,images);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView1.setAdapter(recyclerViewAdapter);
        recyclerView2.setAdapter(recyclerViewAdapter);
        recyclerView3.setAdapter(recyclerViewAdapter);
        recyclerView4.setAdapter(recyclerViewAdapter);
        recyclerView5.setAdapter(recyclerViewAdapter);

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
    {
        Context mcontext;
        ArrayList<Integer> images ;
        LayoutInflater layoutInflater;

        public RecyclerViewAdapter(Context context,ArrayList<Integer> images )
        {
            this.mcontext=context;
            this.images=images;
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

            holder.imageList.setImageResource(images.get(position));
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageList;
            TextView Title,Fees
                    ,Round1,Round2,Round3,
                    RoundTime1,RoundTime2,RoundTime3;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageList=(ImageView)itemView.findViewById(R.id.ivtimetable);
                Title=(TextView)itemView.findViewById(R.id.tvAutoGames);
                Fees=(TextView)itemView.findViewById(R.id.tvEntryFee);

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

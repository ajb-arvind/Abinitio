package com.official19.ajb.abinitio.allevent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.eventpackage.automobile;
import com.official19.ajb.abinitio.eventpackage.computer;

public class CompGame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    CardView RulesCard, PrizeCard, Co_OrdinatorCard;
    TextView Description,RulesCardHidden, PrizeCardHidden, Co_OrdinatorCardHidden;
    ImageView RulesArrow,PrizeArrow,Co_OrdinatorArrow;
    FloatingActionButton makeCall;
    String cordintor_no, descb0, descb1, descb2, descb3, descb4,
            rulesCardHidden0, rulesCardHidden1, rulesCardHidden2, rulesCardHidden3, rulesCardHidden4,
            prizeCardHidden0, prizeCardHidden1, prizeCardHidden2, prizeCardHidden3, prizeCardHidden4,
            co_OrdinatorCardHidden0, co_OrdinatorCardHidden1, co_OrdinatorCardHidden2, co_OrdinatorCardHidden3, co_OrdinatorCardHidden4;
    ImageView event_logo;

    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUI();

        setSupportActionBar(toolbar);

        Intent intent =getIntent();
        String event = intent.getStringExtra("Comp_Event");

        getSupportActionBar().setTitle(event);

        completeMechanical();

        switch (event)
        {
            case "C60":
                Description.setText(descb0);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:9370088262";
                break;

            case "Algorix":
                Description.setText(descb1);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:9284705198";
                break;

            case "Search Master":
                Description.setText(descb2);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:8830678511";
                break;

            case "Data Geeks":
                Description.setText(descb3);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
                cordintor_no="tel:9370088262";
                break;

            case "Counter Strike":
                Description.setText(descb4);
                RulesCardHidden.setText(rulesCardHidden4);
                PrizeCardHidden.setText(prizeCardHidden4);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden4);
                cordintor_no="tel:9370088262";
                break;

        }


        ExpandCard();

        setMakeCall();

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
            startActivity(new Intent(this, computer.class));
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


    void setUI(){
        RulesCard = (CardView)findViewById(R.id.cvRulesCard);
        PrizeCard = (CardView)findViewById(R.id.cvPrizeCard);
        Co_OrdinatorCard = (CardView)findViewById(R.id.cvCo_ordinatorCard);

        Description=(TextView)findViewById(R.id.tvDescriptionGame);
        RulesCardHidden = (TextView) findViewById(R.id.tvRulesHidden);
        PrizeCardHidden = (TextView) findViewById(R.id.tvPrizeHidden);
        Co_OrdinatorCardHidden = (TextView) findViewById(R.id.tvCo_ordinatorHidden);

        event_logo=(ImageView)findViewById(R.id.imageGame);

        RulesArrow=(ImageView)findViewById(R.id.ivArrowRules);
        PrizeArrow=(ImageView)findViewById(R.id.ivArrowPrizes);
        Co_OrdinatorArrow=(ImageView)findViewById(R.id.ivArrowCordinator);

        makeCall = findViewById(R.id.call);

    }

    void ExpandCard(){

        RulesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(RulesCardHidden.getVisibility() == view.VISIBLE){
                    RulesCardHidden.setVisibility(view.GONE);
                    RulesArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    RulesCardHidden.setVisibility(view.VISIBLE);
                    RulesArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

        PrizeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(PrizeCardHidden.getVisibility() == view.VISIBLE){
                    PrizeCardHidden.setVisibility(view.GONE);
                    PrizeArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    PrizeCardHidden.setVisibility(view.VISIBLE);
                    PrizeArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

        Co_OrdinatorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Co_OrdinatorCardHidden.getVisibility() == view.VISIBLE){
                    Co_OrdinatorCardHidden.setVisibility(view.GONE);
                    Co_OrdinatorArrow.setImageResource(R.drawable.ic_arrow_drop_down);
                }
                else{
                    Co_OrdinatorCardHidden.setVisibility(view.VISIBLE);
                    Co_OrdinatorArrow.setImageResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });

    }

    void setMakeCall(){
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);//USE ACTION_DIAL
                callIntent.setData(Uri.parse(cordintor_no));
                if (ContextCompat.checkSelfPermission(CompGame.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CompGame.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                }
                else
                {
                    startActivity(callIntent);
                }
            }
        });
    }

    void completeMechanical(){
        //
        descb0 = "";

        descb1 = "";

        descb2= "";

        descb3= "";

        //
        rulesCardHidden0 = "";

        rulesCardHidden1 = "";

        rulesCardHidden2 = "";

        rulesCardHidden3 = "";

        prizeCardHidden0 = "";
        prizeCardHidden1 = "";
        prizeCardHidden2 = "";
        prizeCardHidden3 = "";

        co_OrdinatorCardHidden0 = "";
        co_OrdinatorCardHidden1 = "";
        co_OrdinatorCardHidden2 = "";
        co_OrdinatorCardHidden3 = "";
    }
}

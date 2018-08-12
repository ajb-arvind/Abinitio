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
import com.official19.ajb.abinitio.event;
import com.official19.ajb.abinitio.eventpackage.automobile;

public class GameActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CardView RulesCard, PrizeCard, Co_OrdinatorCard;
    TextView Description,RulesCardHidden, PrizeCardHidden, Co_OrdinatorCardHidden;
    ImageView RulesArrow,PrizeArrow,Co_OrdinatorArrow;
    FloatingActionButton makeCall;
    String cordintor_no, descb0, descb1, descb2, descb3,
            rulesCardHidden0, rulesCardHidden1, rulesCardHidden2, rulesCardHidden3,
            prizeCardHidden0, prizeCardHidden1, prizeCardHidden2, prizeCardHidden3,
            co_OrdinatorCardHidden0, co_OrdinatorCardHidden1, co_OrdinatorCardHidden2, co_OrdinatorCardHidden3;
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
        String event = intent.getStringExtra("Auto_Event");

        getSupportActionBar().setTitle(event);

        completeMechanical();

        switch (event)
        {
            case "Lathe War":
                Description.setText(descb0);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:9370088262";
                break;

            case "Vehicle Troubleshooting":
                Description.setText(descb1);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:9284705198";
                break;

            case "Mock Placement":
                Description.setText(descb2);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:8830678511";
                break;

            case "Model Making":
                Description.setText(descb3);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
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
            startActivity(new Intent(this, automobile.class));
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
                if (ContextCompat.checkSelfPermission(GameActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(GameActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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
        descb0 = "Participants are required to perform set of operations on the job using lathe machine. Problem statement for which will be declared on the spot. There will be two rounds.";

        descb1 = "Overall technical and practical knowledge of a participant will be check in this event, which will be carried away in three rounds as follows.";

        descb2= "This event is specially design to improve communication skills as well as personality of the participants. This event gives guidelines, how to prepare for the mock placement. This event consist of three rounds as follows:";

        descb3= "In this event, participants have to make a vehicle model from given material in given time period. \n" +
                "The principle behind this event is the significance of hydraulics in automobile Industry.\n" +
                "The participants have to use the given material to make a selfsustained load carrying vehicle using hydraulic power.";

        //
        rulesCardHidden0 = "Round 1:\n" +
                "\n" +
                "Will be of dimensions marking and profile cutting, which is to be completed in 40-45mins.\n" +
                "(If the no of participants will increase than 30 then the Apti. round will be taken.)\n" +
                "Participants will be shortlisted after Round 1 for Round 2.\n" +
                "\n" +
                "Round 2:\n" +
                "\n" +
                "Will also be of profile cutting, which is to be completed in 50-55mins.\n" +
                "After this round final 3 winners will be selected.\n" +
                "\n" +
                "Rules:\n" +
                "\n" +
                "    • All participants should carry workshop aprons and wear leather shoes.\n" +
                "    • Participants should carry their college ID-card.\n" +
                "    • Experience of working with a lathe machine.\n" +
                "    • Only one member in a team (Open for all branch students).\n" +
                "    • Not more than 2 tools would be provided.\n" +
                "    • Fine will be levied if any damages to Tool, Lathe Machine or Surroundings occur during Operation.\n" +
                "    • Any kind of malpractices like use of cell phone during the competition is completely banned.\n" +
                "    • Anyone found so will be disqualified.\n" +
                "    • Judge’s decision will be final.\n" +
                "    • No extra work piece will be provided and carrying of any extra material is banned.\n" +
                "    • After the completion of the task all the accessories must be returned.\n" +
                "    • For any query, contact the event co-ordinator\n" +
                "\n" +
                "      Entry Fee: Rs. 100/-";

        rulesCardHidden1 = "Round 1:\n" +
                "\n" +
                "Aptitude test regarding vehicles and new technology in automotive field.\n" +
                "Participants will be shortlisted after round 1.\n" +
                "\n" +
                "Round 2:\n" +
                "\n" +
                "Recognize parts of vehicles in given time.\n" +
                "Participants will be shortlisted after round 2.\n" +
                "\n" +
                "Round 3:\n" +
                "\n" +
                "Viva and troubleshooting, Participants should recognize the problems in vehicles.\n" +
                "Final 3 winners will be selected by Judges after third round. \n" +
                "\n" +
                "\n" +
                "Rules:\n" +
                "\n" +
                "    • Participants should come on time for Apti. round.\n" +
                "    • The use of mobile phone, calculator or any electronic devices is not allowed.\n" +
                "    • Carry a blue or black pen with you, if necessary you may also carry a writing pad with you.\n" +
                "    • College ID-card and entry fee receipt is compulsory.\n" +
                "    • There should not be any argument or violation of rules, otherwise the participant will be disqualified.\n" +
                "    • Any additional rules or modifications which exist will be communicated on the spot.\n" +
                "    • Judge’s decision will be final.\n" +
                "    • For any query, contact the event co-ordinator.\n" +
                " \n" +
                "\n" +
                "\n" +
                "Entry Fee: Rs. 50";

        rulesCardHidden2 = "Round 1:\n" +
                "\n" +
                "Aptitude test regarding general and technical based will be taken.\n" +
                "Participants will be shortlisted for round 2.\n" +
                "\n" +
                "Round 2:\n" +
                "\n" +
                "This round is called as ‘Picture Perception and Discussion Round (PPDR)’\n" +
                "In this round some pictures will be shown to the participants for 10sec.\n" +
                "The task is to write a short story about 10-15 lines according to condition given in picture.\n" +
                "In this round the reasoning ability of participant will be check \n" +
                "And selected participants will send for the final round.\n" +
                "\n" +
                "Round 3:\n" +
                "\n" +
                "This is the final round which is ‘Face to Face Interview’\n" +
                "The level of interview if of placement type so participants should prepare for that.\n" +
                "Judges will select final 3 winners.\n" +
                "\n" +
                "\n" +
                "Rules:\n" +
                "    • Participants should come on time for Apti. round.\n" +
                "    • The use of mobile phone, calculator or any electronic devices is not allowed.\n" +
                "    • Carry a blue or black pen with you, if necessary you may also carry a writing pad with you.\n" +
                "    • College ID-card and entry fee receipt is compulsory.\n" +
                "    • There should not be any argument or violation of rules, otherwise the participant will be disqualified.\n" +
                "    • Any additional rules or modifications which exist will be communicated on the spot.\n" +
                "    • Judge’s decision will be final.\n" +
                "    • For any query, contact the event co-ordinator\n" +
                "\n" +
                "\n" +
                "\n" +
                "Entry Fee: Rs. 50";

        rulesCardHidden3 = "Rounds:\n" +
                "\n" +
                "Their will be not specific rounds for this event.\n" +
                "On the first day participants have to make their model using material provided. \n" +
                "On the second day any modification in the vehicle is not allowed, only the execution of the model will be tested.\n" +
                "\n" +
                "\n" +
                "Rules:\n" +
                "\n" +
                "    • Maximum 2 participants are allowed in a team.\n" +
                "    • First day will be allotted for preparing of model within 4 hours only.\n" +
                "    • On second day, model should execute the load bearing task.\n" +
                "    • Use of mobile phones, laptop or any other electronic devices is prohibited.\n" +
                "    • No extra material will be provided and carrying of any extra material is banned.\n" +
                "    • Vehicle should be solely designed for carrying load and should dumped the same.\n" +
                "    • The size of vehicle must be in given size limit.\n" +
                "    • Vehicle design will also be taken under consideration while marking.\n" +
                "(It should look like a vehicle.)\n" +
                "    • Judges design will be final.\n" +
                "    • For any query, contact event co-ordinator.\n" +
                "\n" +
                "\n" +
                "Entry Fee: Rs. 300 /- ";

        prizeCardHidden0 = "1st     -Rs. 2500/-\n" +
                "2nd   -Rs. 1500/-\n" +
                "3rd   -Rs. 1000/-";

        prizeCardHidden1 = "1st    -Rs. 2500/-\n" +
                "2nd   -Rs. 1500/-\n" +
                "3rd    -Rs. 1000/-";

        prizeCardHidden2 = "1st    -Rs. 1500/-\n" +
                "2nd   -Rs. 1000/-\n" +
                "3rd    -Rs. 500/-";

        prizeCardHidden3 = "1st    -Rs. 2500/-\n" +
                "2nd   -Rs. 1500/-\n" +
                "3rd    -Rs. 1000/-";

        co_OrdinatorCardHidden0 = "";
        co_OrdinatorCardHidden1 = "";
        co_OrdinatorCardHidden2 = "";
        co_OrdinatorCardHidden3 = "";
    }
}

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
import com.official19.ajb.abinitio.eventpackage.civil;

public class CivilGame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    CardView RulesCard, PrizeCard, Co_OrdinatorCard;
    TextView Description,RulesCardHidden, PrizeCardHidden, Co_OrdinatorCardHidden;
    ImageView RulesArrow,PrizeArrow,Co_OrdinatorArrow;
    FloatingActionButton makeCall;
    String cordintor_no, descb0, descb1, descb2, descb3,
            rulesCardHidden0, rulesCardHidden1, rulesCardHidden2, rulesCardHidden3,
            prizeCardHidden0, prizeCardHidden1, prizeCardHidden2, prizeCardHidden3,
            co_OrdinatorCardHidden0, co_OrdinatorCardHidden1, co_OrdinatorCardHidden2, co_OrdinatorCardHidden3;
    ImageView event_logo;
    public int[] logos ={R.drawable.civillogo1,R.drawable.civillogo2,R.drawable.civillogo3,R.drawable.cicillogo4};


    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUI();

        setSupportActionBar(toolbar);

        Intent intent =getIntent();
        String event = intent.getStringExtra("Civil_Event");

        getSupportActionBar().setTitle(event);

        completeMechanical();

        switch (event)
        {
            case "Spaco Frame":
                Description.setText(descb0);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                event_logo.setImageResource(logos[0]);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:9860449876";
                break;

            case "Poster Presentation":
                Description.setText(descb1);
                event_logo.setImageResource(logos[1]);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:7038519854";
                break;

            case "Clad Clash":
                Description.setText(descb2);
                event_logo.setImageResource(logos[2]);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:7038034377";
                break;

            case "Treasure Hunt":
                Description.setText(descb3);
                event_logo.setImageResource(logos[3]);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
                cordintor_no="tel:7028777972";
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
            startActivity(new Intent(this, civil.class));
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
                if (ContextCompat.checkSelfPermission(CivilGame.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CivilGame.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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
        descb0 = "Speco frame is one of the new topic in civil engineering. This year Participant's will have to design and fabricate their own frames and test them for maximum load.";

        descb1 = "If you are innovative and want to change INDIA , then ABINITIO  2K18-19 is inviting you to release your potentials in the way of battle ground. Put down your brain and present something innovative ideas which are simple and effective. Complete the given task within time and the victory is yours.\n" +
                "\n" +
                "TOP  THREE  POSTERS  WILL  BE  SENT  TO  TOWN  PLANNING\n\n" +
                "TOPIC OF EVENT: - Poster making for smart village.";

        descb2= "This event will test participants designing abilities and civil and AutoCAD based knowledge.";

        descb3= "";

        //
        rulesCardHidden0 =
                "    •  Participants should complete their frame with all the guidelines and limitations provided by the management team.\n" +
                "    • Sticks and glue will be provided in limited quantity.\n" +
                "    • The frame will be tested on next day after making.\n" +
                "    • Time provided for frame making is 2 hrs.\n" +
                "    • Using material of other participants is also strictly prohibited.\n" +
                "    • The team should use only that material which is provided by organizer.\n" +
                "    • If other material is used rather than provided, then the team will be disqualified immediately.\n" +
                "    • The decision of the judges will be final depending upon the judging criteria.\n" +
                "\n" +
                "JUDGING CRITERIA:-\n" +
                "Frame will be judge by applying the load over plywood kept on top of frame.\n" +
                "The best estimated loaded capacity will be calculated i.e. Load/Self-weight.\n" +
                "The frame with maximum load to self weight ratio will be the winner.\n" +
                "[i.e. maximum load carrying capacity for minimum self weight.]\n" +
                "It should be according to problem statement.\n" +
                "\n" +
                "Note:-\n" +
                "On the spot registration will be accepted.\n" +
                "\n" +
                "\n" +
                "NO. OF PARTICIPANTS:-\n" +
                "    • Minimun 3 &Maximum 4 members per group.\n" +
                "    • Cost per group:- 150₹/-. ";

        rulesCardHidden1 = "(Maximum: - 2 participants) \n" +
                "THEME OF EVENT:- Identifying the problems and presenting innovative ideas and solution regarding smart village.\n" +
                "Example: waste management, rainwater harvesting, consumption of renewable sources, traffic management, health, welfare, food security, local business, electrification, education, etc.\n" +
                "RULES AND GUIDELINES:-\n" +
                "The competition will be conducted in two rounds:\n" +
                "ROUND 1:- \n" +
                "    1. Each poster should be of size A1, A2 or A3 only.\n" +
                "    2. The content of the poster should be appropriate to the theme.\n" +
                "    3. Every point to be conveyed by the student must be on a single poster.\n" +
                "    4.  Poster can be handmade or computerized.\n" +
                "    5. Paper/Print used should be of good quality.\n" +
                "    6. The best posters will be selected for the next round.\n" +
                "    7. The judgement will be based on following criteria:\n" +
                "-Originality of the concept\n" +
                "-Significance\n" +
                "-Presentation of the poster\n" +
                "-Visual appearance.\n" +
                " ROUND 2:-\n" +
                "    1. In this round the selected students should elaborate their ideas through power point presentation [time limit for presentation will be 10 min] or models.\n" +
                "    2. The decision made by the judges will be final.                                                                                 \n" +
                "\n" +
                "ENTRY FEES:- 100/- per group.";

        rulesCardHidden2 = "The competition will take place in 2 rounds.\n" +
                "    • 1st Round:\n" +
                "    • In the 1st round the participants will face an aptitude purely based on designing and civil engineering topics. The aptitude will be in pen and paper format i.e. MCQ’s format.\n" +
                "    • The highest scorers will proceed to the next round\n" +
                "    • 2nd Round:\n" +
                "    • In this round the participants will be given a line plan / problem statement which they will have to solve and obtain the dimensions of the given plan.\n" +
                "    • They will have to draw the Developed Plan (Ground Floor Plan i.e. 2D plan) of the given statement.\n" +
                "    • The time at which the individual student starts to perform will be recorded by the co-ordinator. Participants should complete the task given by the organisation.\n" +
                "    • Use of pen drives or any other hardware is not allowed.\n" +
                "    • Ready templates are not allowed.\n" +
                "    • Results declared by judges will be final.\n" +
                "\n" +
                "JUDGING CRITERIA:\n" +
                "    • Judging will be based on fulfilling the requirements of the problem statement\n" +
                " ( Proper Dimension, Prospect, Aspect)\n" +
                "    • The best design by the above criteria will be awarded as the winning design.\n" +
                "TIME LIMIT:\n" +
                "    • For 1st Round: Half Hour\n" +
                "    • For 2nd Round: One and Half Hour\n" +
                "NOTE:\n" +
                "    • On the spot registration will be accepted.\n" +
                "    • All  students  with  a  valid  identity  card  of their  respective educational  institutes  are  eligible  to  participate  in  the event\n" +
                "NO. OF PARTICIPANTS:\n" +
                "    • This is an individual competition.\n" +
                "    • Cost per individual :-50/-";

        rulesCardHidden3 = "DAY 1:\n" +
                "ELIMINATION ROUND: MOSAIC TILES.\n" +
                "\n" +
                "    • Each group will be given pieces of a mosaic puzzle which they have to solve.\n" +
                "    • Initially the picture will be shown to the groups for a limited amount of time;                         they have to memorize the picture to solve the puzzle\n" +
                "    • In the middle of the game , the groups will have two chances to \n" +
                "View the image for about 30 seconds.\n" +
                "    • The four groups that will complete the puzzle in the fastest amount of time will be qualified to the next round.\n" +
                "DAY 2:\n" +
                "ROUND 1: ANGRY BIRDS\n" +
                "\n" +
                "    • A setup of angry bird game will be arranged for the qualified four teams.\n" +
                "    • In this stage, all the four teams will perform simultaneously.\n" +
                "    • Any three teams who will qualify this stage first will qualify to the next round.\n" +
                "\n" +
                "ROUND 2:\n" +
                "    • The puzzle solved by the three teams will lead them to their respective destinations.\n" +
                "    • They will get a new clue/key at their destinations which they have to solve to reach the black hole i.e. round 3\n" +
                "    • The first two teams to reach the black hole will be qualified for the next round.\n" +
                "\n" +
                "ROUND 3:\n" +
                "    • In this round, the teams will go to a classroom with a small torch.\n" +
                "    • The classroom will be completely darkened by hanging black curtains and card sheets.\n" +
                "    • There will be maize of strings in the classroom which has to be followed by the team member of each team to know the final clue.\n" +
                "    • The clue has to be solved by the member who is stuck in the classroom.\n" +
                "    • The first one solving the clue will be declared as the winner and the doors will be opened.\n" +
                "\n" +
                "\n" +
                "    • All the puzzles/clues included in this event will be totally based on the basic engineering knowledge of students of all branches.";

        prizeCardHidden0 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden1 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden2 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden3 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";

        co_OrdinatorCardHidden0 = "Akshay Kandle\n" +
                "\tkandleakshay751@gmail.com\n" +
                "\tMobile no:-9860449876\n" ;

        co_OrdinatorCardHidden1 = "RAJTILAK  PRAMOD  RAUT\n" +
                "\trajtilakraut@gmail.com\n"+
                "\tMobile no:-7038519854\n";

        co_OrdinatorCardHidden2 = "Akashada Kale\n" +
                "\tkaleakashada@gmail.com\n" +
                "\tMobile No:-7038034377\n";

        co_OrdinatorCardHidden3 = "Pooja Hariram Chauhan\n" +
                "\tpooja28chavan@gmail.com\n"+
                "\tMobile No:-7028777972\n";
    }
}

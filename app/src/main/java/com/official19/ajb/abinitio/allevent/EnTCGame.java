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
import com.official19.ajb.abinitio.eventpackage.entc;

public class EnTCGame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    CardView RulesCard, PrizeCard, Co_OrdinatorCard;
    TextView Description,RulesCardHidden, PrizeCardHidden, Co_OrdinatorCardHidden;
    ImageView RulesArrow,PrizeArrow,Co_OrdinatorArrow;
    FloatingActionButton makeCall;
    String cordintor_no, descb0, descb1, descb2, descb3,
            rulesCardHidden0, rulesCardHidden1, rulesCardHidden2, rulesCardHidden3,
            prizeCardHidden0, prizeCardHidden1, prizeCardHidden2, prizeCardHidden3,
            co_OrdinatorCardHidden0, co_OrdinatorCardHidden1, co_OrdinatorCardHidden2, co_OrdinatorCardHidden3;
    ImageView event_logo;

    public int[] logos ={R.drawable.entclogo1,R.drawable.entclogo2,R.drawable.entclogo3,R.drawable.entclogo4};


    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setUI();

        setSupportActionBar(toolbar);

        Intent intent =getIntent();
        String event = intent.getStringExtra("EnTC_Event");

        getSupportActionBar().setTitle(event);

        completeMechanical();

        switch (event)
        {
            case "Spechien Sie Matlab":
                Description.setText(descb0);
                event_logo.setImageResource(logos[0]);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:9403846521";
                break;

            case "Electro-Spark":
                Description.setText(descb1);
                event_logo.setImageResource(logos[1]);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:9130535990";
                break;

            case "Utrix":
                Description.setText(descb2);
                event_logo.setImageResource(logos[2]);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:7218552510";
                break;

            case "Robox":
                Description.setText(descb3);
                event_logo.setImageResource(logos[3]);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
                cordintor_no="tel:7038222736";
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
            startActivity(new Intent(this, entc.class));
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
                if (ContextCompat.checkSelfPermission(EnTCGame.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(EnTCGame.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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
        descb0 = " 'MATLAB AND SIMULINK’ is a platform to create" +
                " a real world and time responses virtually. It is a" +
                " great tool for engineers as there is need to" +
                " solve problems that require complex" +
                " computation." +
                " Here is an opportunity to show and upgrade your skills through" +
                " competition.";

        descb1 = "If Electronics lives in you, then" +
                " ABINITIO 2K18-19 is inviting you to" +
                " release your potentials in the way of" +
                " battle ground. Put down your brain to" +
                " design and implement the circuits" +
                " which are simple & effective" +
                ". Complete the given task within time" +
                " limitation and the victory is yours.";

        descb2= "Microcontroller acts as brain of any" +
                " embedded system. In this participants will" +
                " gain an in-depth knowledge and" +
                " experience" +
                " in" +
                " programming" +
                " and" +
                " applications of μC.";

        descb3= "The platform for representing various" +
                " models of robots and creating the technical" +
                " environment & sharing of knowledge among" +
                " upcoming engineers. Here is an opportunity" +
                " to show and upgrade your skills through" +
                " competition.";

        //
        rulesCardHidden0 = "SOFTWARE VERSIONS:\n" +
                "1. MATLAB R2017a or above\n" +
                "Round 1: MCQ Test\n" +
                "\uF076 The first round includes the Test which consists of 30 multiple\n" +
                "choice questions based on MATLAB.\n" +
                "\uF076 Each question will be for one point.\n" +
                "\uF076 Number of Teams selected for Second Round will be based upon\n" +
                "total number of teams registered.\n" +
                "\uF076 If the two teams have same points then Test completion time will\n" +
                "be considered.\n" +
                "Round 2: ALT MATLAB (Arithmetic and Logical test)\n" +
                "\uF076 Here each participant team will be given a mathematical equation\n" +
                "or logical expression.\n" +
                "\uF076 If the two teams have same points then Task completion time will\n" +
                "be considered.\n" +
                "\uF076 5-7 teams will be shortlisted on the basis of correctness and time.\n" +
                "Round 3: DEEP ALT\n" +
                "\uF076 In this round complicated mathematical equation will be asked.\n" +
                "E.g.:- summation of sin(2*pi*t) etc. Winners will be decided on the\n" +
                "basis of speed and accuracy of the team.NOTE:\n" +
                "Based on the performance in all the three rounds the winner will\n" +
                "be decided.\n" +
                "Check the MATLAB Onramp Course.\n" +
                "SYLLABUS:\n" +
                "1. Basic Commands\n" +
                "2. Array creation and its operations\n" +
                "3. Plotting vectors\n" +
                "4. Logical operations and conditioning\n" +
                "5. Decision branching and looping\n" +
                "6. Mathematical operations\n" +
                "ELIGIBILITY:\n" +
                "All students with a valid identity card of their respective\n" +
                "educational institutes are eligible to participate in the event. Team\n" +
                "Specification: A team may consist of a maximum of 2 members. Students\n" +
                "from different educational institutes can form a team.\n" +
                "ENTRY FEE:\n" +
                "₹ 100 per Team (Max. 2 members)";

        rulesCardHidden1 = "Round 1:\n" +
                "\uF076 The first round includes the Test which consists of 30 multiple\n" +
                "choice questions.\n" +
                "\uF076 Each question will be for one point.\n" +
                "\uF076 Number of Teams selected for Second Round will be based upon\n" +
                "total number of teams registered.\n" +
                "\uF076 If the two teams have same points then Test completion time will\n" +
                "be considered.\n" +
                "Round 2:\n" +
                "\uF076 The second Round consists of Design of some basic circuits.\n" +
                "\uF076 The round also includes some oral questions related with Design\n" +
                "circuits.\n" +
                "\uF076 The second round is also for 30 points.\n" +
                "\uF076 If the two teams have same points then Task completion time will\n" +
                "be considered.\n" +
                "\uF076 The team which completes the task in specified time will be eligible\n" +
                "for Final Round.\n" +
                "Round 3:\n" +
                "\uF076 The round consist of Design and Implementation of circuit.\n" +
                "\uF076 This round has 40 points, 20 for designing circuit and specifying\n" +
                "components and 20 for Hardware implementation.\n" +
                "\uF076 Participants are requested to use the provided hardware carefully.\n" +
                "NOTE:\n" +
                "Based on the performance in all the three rounds the winner will\n" +
                "be decided.SYLLABUS:\n" +
                "1. BASIC ELECTRONICS:\n" +
                "\ta. Logic Gates\n" +
                "\tb. Operational Amplifiers\n" +
                "\tc. Regulated Power Supply\n" +
                "2. DIGITAL ELECTRONICS:\n" +
                "\ta. Multiplexer and Demultiplexer\n" +
                "\tb. Synchronous Counters and Asynchronous Counters\n" +
                "\tc. Adder, Subtractor and Comparator\n" +
                "3. INTEGRATED CIRCUITS\n" +
                "\ta. OP-AMP and its Linear and Non-Linear Applications\n" +
                "4. 8051 MICROCONTROLLER\n" +
                "\ta. Features, Architecture and Pin Functioning\n" +
                "ELIGIBILITY:\n" +
                "All students with a valid identity card of their respective\n" +
                "educational institutes are eligible to participate in the event. Team\n" +
                "Specification: A team may consist of a maximum of 2 members. Students\n" +
                "from different educational institutes can form a team.\n" +
                "ENTRY FEE:\n" +
                "₹ 100 per Team (Max. 2 members)";

        rulesCardHidden2 = "SOFTWARE VERSIONS:\n" +
                "1. Keil uVision4 or above\n" +
                "2. Proteus 8.4 or aboveRound 1:\n" +
                "\uF076 The first round includes the Test which consists of 30 multiple\n" +
                "choice questions based on microcontroller and embedded system.\n" +
                "\uF076 Each question will be for one point.\n" +
                "\uF076 Number of Teams selected for Second Round will be based upon\n" +
                "total number of teams registered.\n" +
                "\uF076 If the two teams have same points then Test completion time will\n" +
                "be considered.\n" +
                "Round 2:\n" +
                "\uF076 It will include the visualization and identification of electronics\n" +
                "components.\n" +
                "\uF076 If the two teams have same points then Task completion time will\n" +
                "be considered.\n" +
                "\uF076 The team which completes the task will be eligible for Final Round.\n" +
                "Round 3:\n" +
                "\uF076 In this round finalists have to solve a problem statement on Keil\n" +
                "and simulating it on Proteus software.\n" +
                "NOTE:\n" +
                "Based on the performance in all the three rounds the winner will\n" +
                "be decided.\n" +
                "SYLLABUS:\n" +
                "1. 8051 family\n" +
                "2. Instruction Set\n" +
                "3. Port Structure\n" +
                "4. Memory Organization\n" +
                "5. Software development tools\n" +
                "6. Communication protocols\n" +
                "7.RTOS\n" +
                "ELIGIBILITY:\n" +
                "All students with a valid identity card of their respective\n" +
                "educational institutes are eligible to participate in the event. Team\n" +
                "Specification: A team may consist of a maximum of 2 members. Students\n" +
                "from different educational institutes can form a team.\n" +
                "ENTRY FEE:\n" +
                "₹ 100 per Team (Max. 2 members)";

        rulesCardHidden3 = "\uF076 Represent your robot in the best way you can.\n" +
                "\uF076 No dimensions limitation.\n" +
                "\uF076 The students are allowed or free to use any material, hardware,\n" +
                "etc.\n" +
                "\uF076 Soft copy of detail information of the respective robot is\n" +
                "mandatory (maximum 10 pages).\n" +
                "\uF076 Robots of e-YANTRA, IRC, ROBOCON etc. are also allowed.\n" +
                "AWARDS:\n" +
                "1. JOSEPH ENGELBERGER (Father of ROBOTICS) AWARD\n" +
                "2. INNOVATIVE ROBOT\n" +
                "3. EFFICIENT ROBOT\n" +
                "ELIGIBILITY:\n" +
                "-All students with a valid identity card of their respective\n" +
                "-educational institutes are eligible to participate in the event. Team\n" +
                "-Specification: A team may consist of a maximum of 4 members. Students\n" +
                "-from different educational institutes can form a team.\n" +
                "ENTRY FEE:\n" +
                "₹ 200 per Team (Max. 4 members)";

        prizeCardHidden0 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden1 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden2 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";
        prizeCardHidden3 = "1st Prize\t:\n2nd Prize\t:\n3rd Prize\t:";

        co_OrdinatorCardHidden0 = "AJABE CHAITANYA SANJAY\n" +
                "\tcak00798@gmail.com\n"+
                "\tMobile no:-9403846521\n";

        co_OrdinatorCardHidden1 = "BORATE AADESH RAMBHAU\n" +
                "\taadeshborate5@gmail.com\n" +
                "\tMobile no:-9130535990\n";

        co_OrdinatorCardHidden2 = "KULKARNI REVATI ANAND\n" +
                "\tkulkarnirevti988@gmail.com\n" +
                "\tMobile no:-7218552510\n";

        co_OrdinatorCardHidden3 = "BORADE ASHLESHA MARUTI\n" +
                "\tashlesha14061998@gmail.com\n" +
                "\tMobile no:-7038222736\n";
    }
}

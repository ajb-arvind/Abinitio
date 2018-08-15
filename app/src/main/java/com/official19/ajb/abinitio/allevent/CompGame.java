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

    public int[] logos ={R.drawable.complogo1,R.drawable.complogo2,R.drawable.complogo3,R.drawable.complogo4,R.drawable.complogo5};


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
                event_logo.setImageResource(logos[0]);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:7028313579";
                break;

            case "Algorix":
                Description.setText(descb1);
                event_logo.setImageResource(logos[1]);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:9561580114";
                break;

            case "Search Master":
                Description.setText(descb2);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                event_logo.setImageResource(logos[2]);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:7889592130";
                break;

            case "Data Geeks":
                Description.setText(descb3);
                RulesCardHidden.setText(rulesCardHidden3);
                PrizeCardHidden.setText(prizeCardHidden3);
                event_logo.setImageResource(logos[3]);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden3);
                cordintor_no="tel:9767189564";
                break;

            case "Counter Strike":
                Description.setText(descb4);
                RulesCardHidden.setText(rulesCardHidden4);
                event_logo.setImageResource(logos[4]);
                PrizeCardHidden.setText(prizeCardHidden4);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden4);
                cordintor_no="tel:9403371495";
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
        descb0 = "An astonishing event of the geeks, for the geeks, by the geeks. C60 provides you a platform to elevate your skills of C and C++ programming languages. Scratch your mind to disentangle the crossword, debug the codes and decode the logic based activities.\n";

        descb1 = "Participants should be given problem statements and they have to solve problem statements efficiently in given time period using suitable algorithms and programming language knowledge on paper and also compile and run it using mentioned programming language.";

        descb2= "Do you think you are good in Surfing ?Do you think you know Internet ? Well here\n" +
                "is the chance to prove ! Search Master gives you an opportunity to prove your\n" +
                "abilities of exploring Internet skills. Get a chance to be Sherlock holmes and solve mysteries using Internet. Grab the chance and make most out of it !!\n";

        descb3= "Data Geeks is all about Machine Learning. The Machine learning is a science of getting computers to act without being explicitly programmed. In the past decade, machine learning has led to many remarkable inventions like self-driving cars, practical speech recognition, effective web search, and a vastly improved understanding of the human genome. Machine learning is so pervasive today that you probably use it dozens of times a day without knowing it. Many researchers also think it is the best way to make progress towards human-level AI. So we provide the platform for showcasing talents of young minds in the field of Machine Learning.";

        descb4="Make your team and come up to fight with our best. Hit the mighty to rule the game and play with the best we have. Let the click be your shots, plan for Counter Strike with us.\n" +
                "Counter strike gaming competition between two teams with 5 players each team to fight\n" +
                "against another team till the single comes up.\n";
        //
        rulesCardHidden0 = "ROUND 1\u200B : \n" +
                "Let us Quiz !!\n" +
                "Each Participant will be given the set of MCQ’S and logical questions to solve, to test their knowledge of C, CPP and basic concepts of computer. Participants with maximum scores would advance to the next round.\n" +
                "\n" +
                "ROUND 2\u200B :\n" +
                " Debug it !!\n" +
                "In this round, each participant will be provided with a code on an paper . This code will have a\n" +
                "minor error and participants are supposed to debug it without execution or compilation. Participants debugging it correctly would advance further.\n" +
                "\n" +
                "ROUND 3\u200B : \n" +
                "Code it!!\n" +
                "\n" +
                "Very basic yet challenging problem statements would be given to all the finalists and\n" +
                "they would have to code it on their desktops. The one who cracks it, uses some logic and comes up with the error free code becomes the winner.\n" +
                "All the levels are time bound. Depending upon the participation, each round will face\n" +
                "the elimination.\n" +
                "\n" +
                "\n" +
                "RULES: -\n" +
                "Individual participation only.\n" +
                "There will be 2 winners.\n" +
                "In case if none of the participants are able to execute the code then program with highest accuracy would be considered.\n" +
                "Any access to the internet and use of any electronic device is prohibited.\n" +
                "Any misbehaviour from the participants during the event may lead to disqualification.\n" +
                "In case of any inconvenience or doubts during the competition, participants are requested to seek the help of the volunteers’ present.\n" +
                "Rules would be changed without prior notice by judges or coordinators.\n" +
                "Decision of the judges will be final.\n" +
                "\n" +
                "\n" +
                "REGISTRATION FEE :- 100 Rs /-\n";

        rulesCardHidden1 = "ROUND 1:\n" +
                "Let us Quiz !!\n" +
                "\n" +
                " Each Participant will be given the set of MCQ’S to solve, to test their knowledge of algorithms and basic concepts of computer. Participants with maximum scores would advance to the next round.\n" +
                "\n" +
                "ROUND 2:\n" +
                " Code it !! \n" +
                "\n" +
                " In this round, each participant will be provided with a set of problem statements .\n" +
                "This code will have a particular algorithms and participants are supposed to code it\n" +
                "And execute it properly.Participants solving more problems would advance further.\n" +
                "\n" +
                "ROUND 3:\n" +
                " Unique Coding !!\n" +
                "  \n" +
                "  A very basic yet challenging  problem statement would be given to all the finalists and they would have to code. Each one would be given same problem. The one who cracks it, uses some logic and comes up with the error free code becomes the winner. All the levels are time bound.Depending upon the participation, each round will face the elimination.\n" +
                "\n" +
                "RULES :\n" +
                "\n" +
                "Only  C, C++, Java, Python2 and Python3 programming languages are used. \n" +
                "Max 2 members in team.\n" +
                "There will be 2 winners.\n" +
                "In case if none of the participants are able to execute the code then changing of program would be considered on the spot .\n" +
                "Any access to the internet and use of any electronic device is prohibited.\n" +
                "Any misbehaviour from the participants during the event may lead to disqualification.\n" +
                "In case of any inconvenience or doubts during the competition, participants are requested to seek the help of the volunteers’ present.\n" +
                "Rules would be changed without prior notice by judges or coordinators.\n" +
                "  YD(year drop) members of any college will not be allowed to participate.\n" +
                "Every participant is request to bring their College Identity card.\n" +
                " Id card will be checked at the time of registration.\n" +
                "Decision of the judges will be final.\n" +
                "\n" +
                "REGISTRATION FEE:- 100 Rs /-";

        rulesCardHidden2 = "Search master is Three round event . Each round is an elimination round.\n" +
                "\n" +
                "ROUND 1:-\n" +
                "In this round candidate have to solve 25 questions within given time duration.\n" +
                "Questions shall be from any field including puzzles and riddles and General Knowledge.\n" +
                "Participants are sorted for the Second round according to their performance.\n" +
                "ROUND 2:-\n" +
                "In this round sorted candidate have to solve 20 questions within given time\n" +
                "Duration. Top candidates are to be shortlisted for the final round.\n" +
                "ROUND 3:-\n" +
                "Surprize Round.\n" +
                "\n" +
                "CANDIDATE NOTE :-\n" +
                "1.  Internet will be provided .\n" +
                "2.  Mozilla firefox will be provided .\n" +
                "3.  Candidate can use any search engine as per their choice.\n" +
                "4.  One computer is alloted to each candidate\n" +
                ".5. In case of clash previous round performance                                                                                                                        will be taken into consideration.\n" +
                "6.  Use of unfair means will lead to immediate disqualification .\n" +
                "7.  On the spot Registration will be accepted.\n" +
                "8.  Coordinators decision will be the last decision.\n" +
                "9.  YD(year drop) members of any college will not be allowed to participate.\n" +
                "10. Every participant is request to bring their College Identity card.\n" +
                "11. Id card will be checked at the time of registration.\n" +
                "12. Violation of rules lead you to disqualify!!!\n" +
                "\n" +
                "REGISTRATION FEE:- 50 Rs /-\n";

        rulesCardHidden3 = " Supervised learning Model should be implemented.  Standard training dataset will be provided at the start of the event. Train your model on the given data-set. Test set will also be provided at the start of the event. Upload the test-set answers in CSV file on the server, and the team with the highest test score wins. If two teams tie on the test score the team with the early submission would be the winner. Trained kernel and code should be submitted on the server as well. \n" +
                "\n" +
                "\n" +
                "\n" +
                "RULES: -\n" +
                "6 hours’ time limit.\n" +
                "Max Team size 4.\n" +
                "The team should bring their own laptops.\n" +
                "Minimum hardware requirement for laptops. (i3 4th     generation, 4GB ram).\n" +
                "Participants can upload test answer any number of time during 6 hours’ period.\n" +
                "Test score greater than 60% will be accepted otherwise rejected, 20-minute time will be penalized to the particular team. \n" +
                "Participants are free to use any framework.\n" +
                "2 Winners (1 Winner and 1 runner-up) will be selected.\n" +
                "\n" +
                "REGISTRATION FEES :- 500 Rs /- (per team)\n";

        rulesCardHidden4="Maximum team size is 5.\n" +
                "Equipments other than that of provided will not be allowed during the game.\n" +
                "Participants are expected to follow the game rules and timing provided by the coordinators.  Participants are mandatory to leave the workplace as soon as they finish the game.\n" +
                "Same version of the game will be provided to all participant teams.\n" +
                "2 participant teams whose names has been called by Judges will only be Allowed to enter the room at a time. Interference of any person apart from those 2 teams will result in Disqualification of that team.\n" +
                "Replacement of any participant is Not Allowed. i.e. only those players will be Allowed whose names are given at the time of Registration.\n" +
                "Teams Without Registration Receipt and Identity Cards(carrying each participant) will Not be  Allowed.\n" +
                "Decisions given by judges would be Final and Not Flexible.\n" +
                "Only for first round if team is knocked out they can re-register by paying same entry fee again.\n" +
                "Map names will be displayed 1 hour before the round 1 starts.\n" +
                "            \n" +
                " Note:YD members of any institute are not allowed to participate in the competition.\n" +
                "\n" +
                "REGISTRATION FEE:- 250 Rs /- (PER TEAM)\n";

        prizeCardHidden0 = "";
        prizeCardHidden1 = "";
        prizeCardHidden2 = "";
        prizeCardHidden3 = "";
        prizeCardHidden4 = "";


        co_OrdinatorCardHidden0 = "Shrutika Karande\n" +
                "\tspkarande98@gmail.com\n"+
                "\tMobile no :- 9139330893\n"+
                "Anjali Hande\n" +
                "\tanjalihande98@gmail.com\n"+
                "\tMobile no :- 7028313579\n";

        co_OrdinatorCardHidden1 = "Harshal Ingle\n" +
                "\tharshalingle517@gmail.com\n"+
                "\tMobile no :- 9561580114\n";

        co_OrdinatorCardHidden2 = "Laraib Mushtaq\n" +
                "\tlmushtaq10@gmail.com\n"+
                "\tMobile no :- 7889592130\n";

        co_OrdinatorCardHidden3 = "Pratik Patil\n" +
                "\tspkarande98@gmail.com\n"+
                "\tMobile no :- 9767189564\n";

        co_OrdinatorCardHidden4 = "Sofia Shaikh\n" +
                "\tsofia23sy@gmail.com\n"+
                "\tMobile no :- 9403371495\n";
    }
}

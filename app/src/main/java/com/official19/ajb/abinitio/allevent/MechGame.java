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
import com.official19.ajb.abinitio.eventpackage.mechanical;

public class MechGame extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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

        completeMechanical();

        setSupportActionBar(toolbar);

        Intent intent =getIntent();
        String event = intent.getStringExtra("Mech_Event");

        getSupportActionBar().setTitle(event);

        switch (event)
        {
            case "RC Nitro Racing":
                Description.setText(descb0);
                RulesCardHidden.setText(rulesCardHidden0);
                PrizeCardHidden.setText(prizeCardHidden0);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden0);
                cordintor_no="tel:9370088262";
                break;

            case "Consilio":
                Description.setText(descb1);
                RulesCardHidden.setText(rulesCardHidden1);
                PrizeCardHidden.setText(prizeCardHidden1);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden1);
                cordintor_no="tel:9284705198";
                break;

            case "The Catapult":
                Description.setText(descb2);
                RulesCardHidden.setText(rulesCardHidden2);
                PrizeCardHidden.setText(prizeCardHidden2);
                Co_OrdinatorCardHidden.setText(co_OrdinatorCardHidden2);
                cordintor_no="tel:8830678511";
                break;

            case "Linkage and Gear":
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
            startActivity(new Intent(this, mechanical.class));
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
                if (ContextCompat.checkSelfPermission(MechGame.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MechGame.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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
        descb0 = "-Life is a race which has been started before birth with 300 millions.\n" +
                "-So put some nitromethane in your brain.\n" +
                "-Accelerate the speed of piston for thinking to have a journey of obstacle full life with lot of kinetic energy full of thriller experience.\n" +
                "-Bring out your technical knowledge and have the racers moto. And be a part of RC NITRO RACING \uD83C\uDFC1 with ABINITIO 2k17-18";

        descb1 = "-The participants have to put forth the skills of designing in 3D to bring out the technical design on CATIA.\n" +
                "-Participants knowledge and understanding of design  softwares.\n" +
                "-Each participant has to go through 3 rounds namely MCQ round, Solid modling.";

        descb2= "-The catapult is a ballistic device used to launch a projectile to a great distance.\n " +
                "-Participants have to build, calibrate and fire their own free-standing (not hand-held) trajectory device that is capable of propelling a tennis ball. ";

        descb3= "The event aims to test the knowledge & understanding of participants about gears and linkages and their interrelationship.\n" +
                "-The participants will be provided with the material and they have to assemble it to perform the designated task.";

        //
        rulesCardHidden0 = "\tInquest:\n" +
                "-The cars will be inspected by the organizers for checking all the requirements mentioned in specifications and to avoid the entries of readymade RC Nitro cars.\n" +
                "-The readymade cars will not be entertained in any condition\n" +
                "\tRound 1:- Durato:\n" +
                "This round consist of time trial. The selected teams from synopsis and inquest are allowed to have a journey on a track.\n" +
                "-The best lap time will considered for ranking of the Round\n" +
                "\tRound 2:- Roaring\n" +
                "-This round will be consist of 3 matches viz., Semifinal 1, Semifinal 2 and play off.\n" +
                "-Semifinal 1 and 2 will be among 2 teams from each group and the winning teams will be qualified for the final.\n" +
                "-The rest two teams will offered the play off match and the winning team will be selected for Final.\n" +
                "\tFINALS:\n" +
                "The final race will be taken in three teams selected from third round and the first and second will be announced as winner and runner up respectively.\n" +
                "\tSURPRIZO:-\n" +
                "Tug of war: This round is fun game round in which any team can challenge to any team and the tug of war is being played in between that teams. The best performer among those will be awarded by the special prize and certificates.\n" +
                "Cross the limit: In this round the contestant will be given certain challenge by co-ordinater and the best performer will be awarded by special prizes and certificates.\n" +
                "\n" +
                "SPECIFICATIONS:-\n" +
                "\t• VEHICLE DIMENSIONS:\n" +
                "-Machine should fit in a box of dimensions 650 mm x 500 mm x 400 mm (lxbxh) at any time during the race.\n" +
                "-The external device which is used to control the machine is not included in the size constraint.\n" +
                "-Antennae are exempt from the height restriction.\n"+
                "\t• ENGINE:\n" +
                "-Maximum piston displacement allowed is upto 4.6 cc.\n" +
                "-The car should be powered by only one IC engine.\n" +
                "-Any machine which uses DC Motors for propulsion will be disqualified. However, DC motors and servos can be used for steering mechanisms or any other control mechanisms, apart from propulsion.\n" +
                "\n" +
                "\t• FUEL:\n" +
                "-The percentage of nitromethane should not exceed 20% by volume in the fuel.\n" +
                "-Readymade fuel can be used.\n" +
                "\t• RADIO CONTROLLERS:\n" +
                "-The machine has to be necessarily controlled by a wireless remote control system.\n" +
                "-Note: You may use clutch mechanism between the engine and the wheel, cooling mechanism to prevent overheating of the engine and air filters as dirt might cause serious problems to the engine for better performance.\n" +
                "\t• POWER SUPPLY:\n" +
                "-The machine must have an on-board power supply to provide power to any mechanism requiring electric power not exceeding 12 V.\n" +
                "\n" +
                "\t• STEERING MECHANISM:\n" +
                "The entire steering mechanism has to be fabricated by the participants i.e. any part connected to the steering part rigidly has to be fabricated by the participants; failing to do so the team will be disqualified. However the helm joint, knuckle arm, studs and wheel hub can be ready-made.\n" +
                "\t• SUSPENSION MECHANISM:\n" +
                "The suspension mechanism has to be fabricated by the participants except the shock absorbers.\n" +
                "-The suspension tower and the suspension arms have to be fabricated by the participants.\n" +
                "\n" +
                "\t• BRAKES:\n" +
                "The brake mechanism must be disc brakes only. The disc pads used must be made by participants.\n" +

                "\t• FABRICATED PARTS:\n" +
                "The chassis, Suspensions system, Steering mechanism and Brakes. The machine must not be made from Lego parts, or any ready-made assembly kits other than the parts mentioned above. Readily available chassis layouts\n" +
                "are not allowed. Any machine found having a ready-made chassis will be disqualified.\n" +

                "Gear box assembly, Differentials (if used) Suspension springs, Shock absorbers Tires and wheels (You are advised to use tires of good width for better performance on dirt tracks). Clutch System, Brake System, Engine, Carburetor, Servo Motors, Wheel hub.\n" +
                "ARENA DETAILS:\n" +
                "The race track will be a combination of on road and off road tracks with many obstacles. Participants are advised to use proper suspension and tyres to endure the bumps. Check points will be provided on track where the machine can restart, in case of a disturbance. Details about track will be uploaded on ABINITIO website not the track.\n" +
                "\n" +
                "\tRULES:\n" +
                "    • Each team should be consist of a minimum of two members and a maximum of five members.\n" +
                "    • All teams must be present on specified date for inspection, along with their registration receipt. This is to ensure that the machine has been made according to the given specifications.\n" +
                "    • Participants must use remote with frequency of band spectrum 2.4 GHz only. No power supply will be given on the track.\n" +
                "    • Team members are not permitted to touch either their machines or those of their opponents once the race begins (unless there is a need to lift the machine, two chances only). The penalty for doing so on invalid grounds is disqualification.\n" +
                "    • Teams are prohibited from purposefully damaging the machine of the opponent team. If found guilty, the concerned team will be disqualified.\n" +
                "    • If the machine is found unsafe to run on the track, that team will be disqualified from the race. The organizers’ decision will be final and binding to all in this respect. No damage to the track will be tolerated and if found\n" +
                "    • guilty, the responsible team will be disqualified. 8. The vehicles are not allowed to leave any loose parts or any extra part on any part of the arena.\n" +
                "    • Any vehicle disintegrating during the race will be disqualified. The vehicle must remain intact throughout the race. Once the race gets started, the participants must complete the race.";

        rulesCardHidden1 = "Round 1:-\n" +
                "-Duration: 1 hr\n" +
                "-General questions on design will be asked. \n" +
                "\n" +
                "Round 2:-\n" +
                "-Duration: 30 min\n" +
                "-The participant has to draft an assembly given to them on the software. Marks will be allotted according to the amount of details shown on the draft. \n" +
                "\n" +
                "Round 3:-\n" +
                "-Duration: 1 hr.\n" +
                "-Problem statement will be given on the spot. Participants have to study the same and prepare a CAD model within the stipulated time. \n" +
                "\n" +
                "JUDGING CRITERIA: -\n" +
                "-50 Marks are allotted for completion within time.\n" +
                "-30 Marks are allotted for accuracy in part designing.\n" +
                "-5 marks deduction for each mistake\n" +
                "-Depending upon number of participants in Round 1, no. of participants in Round 2 may change.                            \n" +
                "      \n" +
                "BONUS MARKS: -\n" +
                "-10 Bonus Marks will be given if Drafting is completed within 7.5min.\n" +
                "-20 Bonus Marks will be given if Assembly is completed within 20 min.\n" +
                "-10 Bonus Marks will  be given if assembly is completed within 30min.";

        rulesCardHidden2 = "Round 1:\n" +
                "       -Technical inspection of the catapult.\n" +
                "       -Questions related to the design and mechanism used will be asked by the judges.\n" +
                "\n" +
                "Round 2:\n" +
                "       -Testing the catapult.\n" +
                "       -The catapult which covers maximum length of projectile will be awarded maximum points.\n" +
                "\n" +
                "Round 3:\n" +
                "       -A target will be placed at a certain distance.\n" +
                "       -The goal of the participants is to hit the target.\n" +
                "       -The one to reach the closest to the target will get the maximum points.\n" +
                "NOTE:\n" +
                "-Based on the performance in all the three rounds the winner will be decided.\n" +
                "\n" +
                "\n" +
                "SPECIFICATIONS:\n" +
                "       -The device should fit in a cube of 50cm*.\n" +
                "       -The catapult can be made of any material.\n" +
                "       -A regular tennis ball is going to be used in the event.\n" +
                "       -No electrical components to be used.\n" +
                "\n" +
                "JUDGING CRITERIA:-\n" +
                "\t-50 marks are allotted for aptitude test. Participants passing the aptitude will go further to round 2.\n" +
                "\t-Round 2 will be judged on the basis of accuracy, optimization and space utilization. Judgement will not take place on the basis of time.\n" +
                "\t-Round 3 will be judged on the basis of the end result of the three rounds and the time taken by teams to complete the round 3 problem statement.\n" +
                "\n\nENTRY FEE:\n" +
                "    • 100 per Team (Max. 2 members)\n";

        rulesCardHidden3 = "Round 1:\n" +
                "\t-Duration: 1 hr\n" +
                "\t-Aptitude test based on basic knowledge about gears, drivetrains and linkages.\n" +
                "\n" +
                "Round 2 \n" +
                "\t-Duration: 1 hr\n" +
                "\t-The participants will be given a task. They have to perform the same with the material provided (gears,links)\n" +
                "\t-(Ex: converting reciprocating motion into rotary motion or vice versa.)\n" +
                "\n" +
                "Round 3:\n" +
                "\t-Designing of drive-train based on the problem statement)\n" +
                "\n" +
                "SPECIFICATION:\n" +
                "\t-For round 1, participant need to have a good knowledge about gears, linkages and various drivetrains\n" +
                "\t-For round 2, participants will be provided with plastic gear and linkage. Using your knowledge and skills participants have to perform the designated task.\n" +
                "\t-For round 3, participants will be given a problem statement. They have design a drive train using their knowledge to satisfy the given conditions.\n" +
                "\n" +
                "JUDGING CRITERIA:-\n" +
                "\t-50 marks are allotted for aptitude test. Participants passing the aptitude will go further to round 2.\n" +
                "\t-Round 2 will be judged on the basis of accuracy, optimization and space utilization. Judgement will not take place on the basis of time.\n" +
                "\t-Round 3 will be judged on the basis of the end result of the three rounds and the time taken by teams to complete the round 3 problem statement.\n";

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

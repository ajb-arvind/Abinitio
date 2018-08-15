package com.official19.ajb.abinitio.other;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.eventpackage.computer;

public class gcoearaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView CollegeImage;
    TextView CollegeText;

    String aboutCollege = "Government college of engineering and research, Avasari(Kh),Pune  is one of the prestigious institute in the Maharashtra.\n" +
            " The college is located in pollution free environment and conducive ambience, about 65 km North of Pune, on Pune-Nashik highway (NH-50) and 65 km from holy shrine Bhimashankar, in the land of Maratha warrior Chhatrapati Shivaji Maharaj.\n" +
            " College campus is spread over 50 acre area with huge academic buildings along with a separate administrative and workshop buildings, a separate residential zone with quarters for faculty and staff and hostels. The college is approved by All India Council for Technical Education, New Delhi and is affiliated to Savitribai Phule Pune University. The college also runs various social, cultural as well as technical clubs.\n" +
            " Directorate of Technical Education, Maharashtra State, Mumbai controls institute through its Regional office at Pune.";

    String aboutAbinito = "Abinitio is the state level, annual technical festival of Government College of Engineering & Research, Avasari(Kh.), Pune. Since its inception in 2009, Abinitio has grown manifold to become one of the best platforms for young minds to think, innovate and showcase their talents. Abinitio means 'the beginning ' . This event is the beginning of new trends in technical field in our college \n" +
            "Being a  student-organized event , we believe in practical learning. Now, in our Abinitio'18 we have 25 events, both technical and non-technical, divided over 6 departments. We aim to spread state of art technology across all demographics, which we accomplish by conducting various events.\n" +
            "Abinitio receives a footfall of more than 1500 every year. \n" +
            "With the new edition of Abinitio , we aspire to broaden our horizons and vitalize plenteous inventive brains framing the future. We invite you to share our vision and become part of it.\n";

    String campusString = "Abinitio’s Campus Ambassador Program is a program which shapes students from various colleges \n" +
            "across the state to become efficient managers and creative leaders. Ambassadors not only acquire \n" +
            "leadership skills/entrepreneurial qualities during the program, but also gain a social recognition. We call \n" +
            "for ambassadors to support their constituencies, and educate them about the powerful role played by technical events.\n" +
            "\uF0D8 Why Become Campus Ambassador?\n" +
            " Being a representative of ABINITIO, GCOEARA you will have the opportunity to:\n" +
            "\uF0B7  Understand and explore various technical and marketing issues encountered, in depth.\n" +
            "\uF0B7 Improve your creativity and management skills and gain work experience.\n" +
            "\uF0B7 Build great network contacts, along with other budding minds across the nation, by \n" +
            "collaborating and sharing ideas through our platform.\n" +
            "\uF0B7 An opportunity to improve your communication and managerial skills by \n" +
            "interacting with people coming from diverse fields and from various colleges across India.\n" +
            "\uF0D8 Responsibilities:\n" +
            "\uF0B7 Publicity: \n" +
            " Putting up posters of ABINITIO'18 on college bulletins and notice boards within 2-3 days \n" +
            "of receiving them. \n" +
            "\uF0B7 Participation:\n" +
            " Ensure keen Participation of your College in various Events conducted by ABINITIO'18\n" +
            "in your College or City.\n" +
            "\uF0B7 Social Media:\n" +
            " Publicising the events of Abinitio by sharing the posts on various social media platforms \n" +
            "like Whatsapp, Facebook, and Instagram.\n" +
            "\uF0B7 Tasks: \n" +
            "To help our publicity teams to bring entries from your college.\n" +
            "Perks :\n" +
            "You'll get an official digital certificate of appreciation.\n" +
            "\n" +
            "Contact : -\n" +
            "\n" +
            "Publicity head :\n" +
            "Pooja Chavan (7028777972)\n" +
            "Girish Deshpande\n" +
            "(8793887580)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcoeara);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUI();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent=getIntent();
        String Number=intent.getStringExtra("Gcoeara");

        switch (Number)
        {
            case "0":
                CollegeImage.setImageResource(R.drawable.principal);
                CollegeText.setText("");
                break;


            case "1":
                CollegeImage.setImageResource(R.drawable.college);
                CollegeText.setText(aboutCollege);
                getSupportActionBar().setTitle("About College");
                break;

            case "2":
                CollegeImage.setImageResource(R.drawable.ab);
                CollegeText.setText(aboutAbinito);
                getSupportActionBar().setTitle("Abinitio");
                break;

            case "3":
                CollegeImage.setImageResource(R.drawable.campusimage);
                CollegeText.setText(campusString);
                getSupportActionBar().setTitle("Campus Ambassador");
                break;
        }
    }

    void setUI(){
        CollegeImage = (ImageView)findViewById(R.id.ivCollegeImage);
        CollegeText = (TextView)findViewById(R.id.tvCollegeText);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        MainActivity.navigation(this ,id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

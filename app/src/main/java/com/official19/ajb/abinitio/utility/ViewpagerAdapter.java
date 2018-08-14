package com.official19.ajb.abinitio.utility;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.official19.ajb.abinitio.R;
import com.official19.ajb.abinitio.allevent.CivilGame;
import com.official19.ajb.abinitio.allevent.CompGame;
import com.official19.ajb.abinitio.allevent.EnTCGame;
import com.official19.ajb.abinitio.allevent.GameActivity;
import com.official19.ajb.abinitio.allevent.InstruGame;
import com.official19.ajb.abinitio.allevent.MechGame;

public class ViewpagerAdapter extends PagerAdapter {

    public ImageView EventImage;
    public TextView EventName;
    public TextView EventDescribe;
    public int[] logos;
    public Context mcontext;
    public LayoutInflater layoutInflater;
    public String[] titlearray,descriptionarray;
    public String department;

    public ViewpagerAdapter(Context context,String[] title,String[] description, String department,int[] logos)
    {
        this.mcontext = context;
        titlearray = title;
        descriptionarray = description;
        this.logos=logos;
        this.department = department;
    }

    @Override
    public int getCount() {
        return titlearray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int i) {
        layoutInflater = (LayoutInflater)mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.event_cardview,container,false);

        EventImage=(ImageView)view.findViewById(R.id.ivEventImage);
        EventName=(TextView)view.findViewById(R.id.tvEventName);
        EventDescribe=(TextView)view.findViewById(R.id.tvEventDescribe);

        EventName.setText(titlearray[i]);
        EventDescribe.setText(descriptionarray[i]);
        EventImage.setImageResource(logos[i]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (department){
                    case "Automobile":
                        SwitchAuto(i);
                        break;

                    case "Civil":
                        SwitchCivil(i);
                        break;

                    case "Computer":
                        SwitchComp(i);
                        break;

                    case "EnTC":
                        SwitchEntc(i);
                        break;

                    case "Instrumentation":
                        SwitchInstru(i);
                        break;

                    case "Mechanical":
                        SwitchMech(i);
                        break;

                }
            }
        });

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.invalidate();
    }

    public void SwitchAuto(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Auto 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, GameActivity.class);
                intent0.putExtra("Auto_Event","Lathe War");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "Auto 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, GameActivity.class);
                intent1.putExtra("Auto_Event","Vehicle Troubleshooting");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "Auto 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, GameActivity.class);
                intent2.putExtra("Auto_Event","Mock Placement");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "Auto 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, GameActivity.class);
                intent3.putExtra("Auto_Event","Model Making");
                mcontext.startActivity(intent3);
                break;
        }
    }

    public void SwitchCivil(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Civil 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, CivilGame.class);
                intent0.putExtra("Civil_Event","Spaco Frame");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "Civil 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, CivilGame.class);
                intent1.putExtra("Civil_Event","Poster Presentation");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "Civil 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, CivilGame.class);
                intent2.putExtra("Civil_Event","Clad Clash");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "Civil 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, CivilGame.class);
                intent3.putExtra("Civil_Event","Treasure Hunt");
                mcontext.startActivity(intent3);
                break;
        }
    }

    public void SwitchComp(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Comp 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, CompGame.class);
                intent0.putExtra("Comp_Event","C60");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "Comp 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, CompGame.class);
                intent1.putExtra("Comp_Event","Algorix");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "Comp 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, CompGame.class);
                intent2.putExtra("Comp_Event","Search Master");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "Comp 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, CompGame.class);
                intent3.putExtra("Comp_Event","Data Geeks");
                mcontext.startActivity(intent3);
                break;

            case 4:
                Toast.makeText(mcontext, "Comp 5", Toast.LENGTH_SHORT).show();
                Intent intent4= new Intent(mcontext, CompGame.class);
                intent4.putExtra("Comp_Event","Counter Strike");
                mcontext.startActivity(intent4);
                break;
        }
    }

    public void SwitchEntc(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "EnTC 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, EnTCGame.class);
                intent0.putExtra("EnTC_Event","Spechien Sie Matlab");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "EnTC 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, EnTCGame.class);
                intent1.putExtra("EnTC_Event","Electro-Spark");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "EnTC 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, EnTCGame.class);
                intent2.putExtra("EnTC_Event","Utrix");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "EnTC 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, EnTCGame.class);
                intent3.putExtra("EnTC_Event","Robox");
                mcontext.startActivity(intent3);
                break;
        }
    }

    public void SwitchInstru(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Instru 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, InstruGame.class);
                intent0.putExtra("Instru_Event","Robosoccer");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "Instru 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, InstruGame.class);
                intent1.putExtra("Instru_Event","PLC Master");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "Instru 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, InstruGame.class);
                intent2.putExtra("Instru_Event","Quiz");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "Instru 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, InstruGame.class);
                intent3.putExtra("Instru_Event","Block Warrior");
                mcontext.startActivity(intent3);
                break;
        }
    }

    public void SwitchMech(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Mech 1", Toast.LENGTH_SHORT).show();
                Intent intent0= new Intent(mcontext, MechGame.class);
                intent0.putExtra("Mech_Event","RC Nitro Racing");
                mcontext.startActivity(intent0);
                break;

            case 1:
                Toast.makeText(mcontext, "Mech 2", Toast.LENGTH_SHORT).show();
                Intent intent1= new Intent(mcontext, MechGame.class);
                intent1.putExtra("Mech_Event","Consilio");
                mcontext.startActivity(intent1);
                break;

            case 2:
                Toast.makeText(mcontext, "Mech 3", Toast.LENGTH_SHORT).show();
                Intent intent2= new Intent(mcontext, MechGame.class);
                intent2.putExtra("Mech_Event","The Catapult");
                mcontext.startActivity(intent2);
                break;

            case 3:
                Toast.makeText(mcontext, "Mech 4", Toast.LENGTH_SHORT).show();
                Intent intent3= new Intent(mcontext, MechGame.class);
                intent3.putExtra("Mech_Event","Linkage and Gear");
                mcontext.startActivity(intent3);
                break;
        }
    }

}

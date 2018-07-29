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
import com.official19.ajb.abinitio.allevent.GameActivity;

public class ViewpagerAdapter extends PagerAdapter {

    public ImageView EventImage;
    public TextView EventName;
    public TextView EventDescribe;
    public Context mcontext;
    public LayoutInflater layoutInflater;
    public String[] titlearray,descriptionarray;
    public String department;

    public ViewpagerAdapter(Context context,String[] title,String[] description, String department)
    {
        this.mcontext = context;
        titlearray = title;
        descriptionarray = description;
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
        EventImage.setImageResource(R.drawable.automobile);

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
                mcontext.startActivity(new Intent(mcontext, GameActivity.class));
                break;

            case 1:
                Toast.makeText(mcontext, "Auto 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "Auto 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "Auto 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void SwitchCivil(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Civil 1", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(mcontext, "Civil 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "Civil 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "Civil 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void SwitchComp(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Comp 1", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(mcontext, "Comp 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "Comp 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "Comp 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void SwitchEntc(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "EnTC 1", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(mcontext, "EnTC 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "EnTC 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "EnTC 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void SwitchInstru(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Instru 1", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(mcontext, "Instru 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "Instru 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "Instru 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void SwitchMech(final int i){
        switch (i){
            case 0:
                Toast.makeText(mcontext, "Mech 1", Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(mcontext, "Mech 2", Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(mcontext, "Mech 3", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(mcontext, "Mech 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}

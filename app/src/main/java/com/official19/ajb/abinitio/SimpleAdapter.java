package com.official19.ajb.abinitio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;
    private TextView title,description,click;
    private String[] titlearray,descriptionarray;
    private ImageView imageView;

    public SimpleAdapter(Context context,String[] title,String[] description)
    {
        mcontext = context;
        titlearray = title;
        descriptionarray = description;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return titlearray.length;
    }

    @Override
    public Object getItem(int i) {
        return titlearray[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view ==null)
        {
            view = layoutInflater.inflate(R.layout.list_content_main,null);
        }

        title=(TextView)view.findViewById(R.id.tvTitle);
        imageView=(ImageView)view.findViewById(R.id.ivMain);
        description=(TextView)view.findViewById(R.id.tvDescription);
        click=(TextView)view.findViewById(R.id.tvClick);

        if (titlearray[i].equalsIgnoreCase("Timetable")){
            title.setText("Timetable");
            description.setText("Description 1");
            imageView.setImageResource(R.drawable.calender);
        }else if (titlearray[i].equalsIgnoreCase("Events")){
            title.setText("Events");
            description.setText("Description 2");
            imageView.setImageResource(R.drawable.book);
        }else if (titlearray[i].equalsIgnoreCase("Coordinators")){
            title.setText("Coodinators");
            description.setText("Description 3");
            imageView.setImageResource(R.drawable.contact);
        }else if (titlearray[i].equalsIgnoreCase("Settings")){
            title.setText("Settings");
            description.setText("Description 4");
            imageView.setImageResource(R.drawable.settings);
        }


        switch (titlearray[i]) {
            case "Automobile":
                title.setText("Aftokinitio");
                imageView.setImageResource(R.drawable.automobile);
                break;

            case "Civil":
                title.setText("Civiclan");
                imageView.setImageResource(R.drawable.civil2);
                break;

            case "Computer":
                title.setText("Codegenesis");
                imageView.setImageResource(R.drawable.comp);
                break;

            case "EnTC":
                title.setText("Technolite");
                imageView.setImageResource(R.drawable.entc2);
                break;

            case "Instrumentation":
                title.setText("Niyantrana");
                imageView.setImageResource(R.drawable.instrumentation);
                break;

            case "Mechanical":
                title.setText("Mechtrix");
                imageView.setImageResource(R.drawable.mechanical);
                break;
        }

        return view;
    }
}
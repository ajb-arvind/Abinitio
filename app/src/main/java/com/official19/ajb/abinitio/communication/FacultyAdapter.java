package com.official19.ajb.abinitio.communication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.official19.ajb.abinitio.R;

public class FacultyAdapter extends BaseAdapter {

    private Context mcontext;
    private LayoutInflater layoutInflater;
    private TextView Name,Contact;
    private String[] Namearray,Contactarray;
    private ImageView imageView;

    public FacultyAdapter(Context mcontext, String[] namearray, String[] contactarray) {
        this.mcontext = mcontext;
        Namearray = namearray;
        Contactarray = contactarray;
        layoutInflater = LayoutInflater.from(mcontext);
    }

    @Override
    public int getCount() {
        return Namearray.length;
    }

    @Override
    public Object getItem(int i) {
        return Namearray[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if (view ==null)
        {
            view = layoutInflater.inflate(R.layout.list_content_contact,null);
        }

        Name=(TextView)view.findViewById(R.id.tvFacultyName);
        Contact=(TextView)view.findViewById(R.id.tvFacultyContact);
        imageView=(ImageView)view.findViewById(R.id.ivFaculty);

        Name.setText(Namearray[i]);
        Contact.setText(Contactarray[i]);
        imageView.setImageResource(R.drawable.laraib);

        /*switch (Namearray[i]) {
            case "Arvind":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.arvind);
                break;

            case "Dheeraj":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.dheeraj);
                break;

            case "Laraib":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.laraib);
                break;

            case "Kiran":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.kiran);
                break;

            case "Digambar":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.digambar);
                break;

            case "Devesh":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.devesh);
                break;

            case "Swapnil":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.swapnil);
                break;

            case "Rushi":
                Name.setText(Namearray[i]);
                Contact.setText(Contactarray[i]);
                imageView.setImageResource(R.drawable.rushi);
                break;
        }*/


        return view;

    }
}

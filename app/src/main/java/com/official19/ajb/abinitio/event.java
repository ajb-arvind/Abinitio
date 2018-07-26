package com.official19.ajb.abinitio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class event extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        listView=(ListView)findViewById(R.id.lvMain);
        setupListView();
    }

    public void setupListView()
    {
        String[] title = getResources().getStringArray(R.array.Departments);

        SimpleAdapter simpleAdapter = new SimpleAdapter(event.this,title);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mcontext;
        private LayoutInflater layoutInflater;
        private TextView title,click;
        private String[] titlearray;
        private ImageView imageView;

        public SimpleAdapter(Context context,String[] title)
        {
            mcontext = context;
            titlearray = title;
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
            click=(TextView)view.findViewById(R.id.tvClick);
            imageView=(ImageView)view.findViewById(R.id.tvDescription);

            switch (titlearray[i])
            {
                case "Automobile":
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.automobile);
                    break;

                case "Civil":
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.civil2);
                    break;

                case "Computer":
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.comp);
                    break;

                case "EnTC":
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.entc2);
                    break;

                case "Instrumentation" :
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.instrumentation);
                    break;

                case "Mechanical":
                    title.setText(titlearray[i]);
                    imageView.setImageResource(R.drawable.mechanical);
                    break;
            }

            return view;
        }
    }
}

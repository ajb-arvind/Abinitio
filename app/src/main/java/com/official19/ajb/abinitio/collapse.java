package com.official19.ajb.abinitio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class collapse extends AppCompatActivity {

    Toolbar toolbar_collapse;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapse);
        toolbar_collapse = (Toolbar)findViewById(R.id.toolbarCollapsse);
        //listView=(ListView)findViewById(R.id.lvCollapse);

        //setupListView();

        setSupportActionBar(toolbar_collapse);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setTitle("");
    }

    private void setupListView()
    {

        final String[] title = getResources().getStringArray(R.array.Title);
        String[] description  = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(collapse.this,title,description);
        listView.setAdapter(simpleAdapter);

    }
}

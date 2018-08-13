package com.official19.ajb.abinitio.other;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.official19.ajb.abinitio.MainActivity;
import com.official19.ajb.abinitio.R;

import java.util.ArrayList;

public class gallary extends AppCompatActivity {

    public ViewPager viewPager;
    RecyclerView recyclerView;
    ArrayList<Integer> images =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_abi);

        addImages();

        viewPager=(ViewPager)findViewById(R.id.vpMain);
        recyclerView=(RecyclerView)findViewById(R.id.rvListView);

        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(this,images);
        viewPager.setAdapter(viewPagerAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView=(RecyclerView)findViewById(R.id.rvListView);

        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter recyclerViewAdapter =new RecyclerViewAdapter(this,images);
        recyclerView.setAdapter(recyclerViewAdapter);


    }

    public void addImages()
    {
        images.add(R.drawable.ab1);
        images.add(R.drawable.ab2);
        images.add(R.drawable.ab3);
        images.add(R.drawable.ab4);
        images.add(R.drawable.ab5);
        images.add(R.drawable.ab6);
        images.add(R.drawable.ab7);
        images.add(R.drawable.ab8);

    }

    public class ViewPagerAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater layoutInflater;
        ArrayList<Integer> images ;
        public ImageView imageView;


        public ViewPagerAdapter(Context context,ArrayList<Integer> images ) {
            this.context = context;
            this.images=images;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.content_gallery_abi,container,false);
            imageView=(ImageView)view.findViewById(R.id.ivEvent);

            imageView.setImageResource(images.get(position));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerView.getVisibility()==view.VISIBLE) {
                        recyclerView.setVisibility(view.GONE);
                        //startActivity(new Intent(context,TimetableActivity.class));
                    }
                    else {
                        recyclerView.setVisibility(view.VISIBLE);
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
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
    {
        Context mcontext;
        ArrayList<Integer> images ;
        LayoutInflater layoutInflater;

        public RecyclerViewAdapter(Context context,ArrayList<Integer> images )
        {
            this.mcontext=context;
            this.images=images;
            layoutInflater =LayoutInflater.from(mcontext);
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= layoutInflater.inflate(R.layout.image,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            holder.imageList.setImageResource(images.get(position));
            holder.imageList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewPager.setCurrentItem(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            public ImageView imageList;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageList=(ImageView)itemView.findViewById(R.id.ivGallery);
            }
        }
    }

    @Override
    public void onBackPressed() {

            startActivity(new Intent(gallary.this, MainActivity.class));
    }
}

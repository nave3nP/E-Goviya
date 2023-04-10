package com.project.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import androidx.appcompat.app.AppCompatActivity;

import com.project.myapplication.databinding.ActivityVideoListsBinding;

public class VideoLists extends AppCompatActivity{
    ActivityVideoListsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVideoListsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] names={"Before Farming","Plantation","Maintain","Harvesting"};
        int[] images={R.drawable.before,R.drawable.planting,R.drawable.maintain,R.drawable.harvesting};
        String[] videoids={"Zid9-aFBSlU","FSABgTZVy_g","sBHzvzJT4cE","sw9tC1vzRPM"};

        GridAdapter gridAdapter=new GridAdapter(VideoLists.this,names,images,videoids);
        binding.gridView.setAdapter(gridAdapter);

        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String vidid = videoids[i];
                Intent intent = new Intent(VideoLists.this,VideoPlayer.class);
                intent.putExtra("Video_ID",vidid);
                startActivity(intent);
            }
        });

    }
}
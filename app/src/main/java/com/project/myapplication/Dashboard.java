package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class Dashboard extends AppCompatActivity {
    Button mapbtn;
    Button button2;

    Button tempButton;

    Button converterBtn,profitBtn;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        videoView=findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.dashvideo);
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.seekTo(0);
                videoView.start();
            }
        });

        mapbtn=findViewById(R.id.mapbtn);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Dashboard.this,MapsActivity.class);
                startActivity(intent);

            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,VideoLists.class);
                startActivity(intent);
            }
        });
        tempButton =findViewById(R.id.tempbtn);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,TempMeasure.class);
                startActivity(intent);
            }
        });

        converterBtn = findViewById(R.id.converter);
        converterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,ConverterList.class);
                startActivity(intent);
            }
        });

        profitBtn = findViewById(R.id.ProfitCal);
        profitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,ProfitCal.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.start(); // added
        videoView.resume(); // added
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause(); // added
    }

}

package com.project.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConverterList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_list);

        Button areaBtn,weightBtn,capacityBtn;

        areaBtn = findViewById(R.id.areaBtnn);
        areaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(ConverterList.this, AreaConverter.class);
                startActivity(intent);
            }
        });

        weightBtn = findViewById(R.id.weightBtn);
        weightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(ConverterList.this,WeightConverter.class);
                startActivity(intent);
            }
        });

        capacityBtn = findViewById(R.id.capacityBtn);
        capacityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(ConverterList.this,VolumeConverter.class);
                startActivity(intent);
            }
        });

    }
}
package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class WeightConverter extends AppCompatActivity {

    EditText kilo,busalInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);

        kilo = findViewById(R.id.kilo);
        busalInput= findViewById(R.id.busal);

        busalInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String busalText = busalInput.getText().toString().trim();
                if (!busalText.isEmpty()) {
                    try {
                        double busals = Double.parseDouble(busalText);
                        double kilos = convertBusalToKilo(busals);
                        kilo.setText(String.valueOf(kilos));
                    } catch (NumberFormatException e) {
                        // Handle parsing error if the input is not a valid number
                        kilo.setText("");
                    }
                } else {
                    kilo.setText("");
                }

            }
        });


    }

    private double convertBusalToKilo(double busals){
        return busals/20.87;

    }
}
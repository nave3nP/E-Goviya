package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class VolumeConverter extends AppCompatActivity {
    EditText galloonInput,litreInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_converter);
        galloonInput = findViewById(R.id.galoonInput);
        litreInput = findViewById(R.id.kilo);

        galloonInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String gallonText = galloonInput.getText().toString().trim();
                if (!gallonText.isEmpty()) {
                    try {
                        double gallons = Double.parseDouble(gallonText);
                        double liters = convertGallonsToLiters(gallons);
                        litreInput.setText(String.valueOf(liters));
                    } catch (NumberFormatException e) {
                        // Handle parsing error if the input is not a valid number
                        litreInput.setText("");
                    }
                } else {
                    litreInput.setText("");
                }
            }
        });

    }
    public double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public double convertGallonsToLiters(double gallons) {
        return gallons / 0.264172;
    }
}
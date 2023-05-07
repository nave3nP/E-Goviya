package com.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class TempMeasure extends AppCompatActivity implements SensorEventListener {
    private TextView textView,tempTips;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTemperatureSensorAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_measure);

        textView = findViewById(R.id.tempShow);
        tempTips = findViewById(R.id.tempTips);
        sensorManager =(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!= null){
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);
            isTemperatureSensorAvailable= true;

        }else {
            textView.setText("Error getting Data!");
            tempTips.setText(" ");
            isTemperatureSensorAvailable= false;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText(sensorEvent.values[0]+" °C");

        if(sensorEvent.values[0]<=15){
            tempTips.setText("Dress in layers to trap in warmth and protect against the cold\n\n" +
                    "Protect your extremities by wearing gloves, a warm hat, and insulated boots\n\n" +
                    "Take frequent breaks in a warm, dry location to give your body a chance to warm up\n\n" +
                    "Stay hydrated by drinking plenty of fluids, even if you don't feel thirsty\n\n" +
                    "Keep moving to generate body heat\n\n" +
                    "Be prepared with a fully stocked first aid kit and emergency supplies\n\n" +
                    "Know the signs and symptoms of hypothermia and frostbite, and seek medical attention immediately if necessary.");
        }else {
            tempTips.setText("Wear lightweight, loose-fitting clothing made of breathable fabric, such as cotton or linen, to stay cool and allow sweat to evaporate\n\n"+
                    "Use sunscreen with a high SPF and wear a wide-brimmed hat to protect your skin from the sun's harmful rays\n\n"+
                            "Drink plenty of water and other hydrating fluids to prevent dehydration and heat exhaustion\n\n"+
                            "Take frequent breaks in a shaded or air-conditioned area to cool down and rest\n\n"+
                            "Use cooling towels or misting fans to lower your body temperature\n"

                    );
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
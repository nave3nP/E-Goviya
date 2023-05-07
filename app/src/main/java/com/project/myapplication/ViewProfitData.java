package com.project.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ViewProfitData extends AppCompatActivity {

    private TableLayout tableLayout;
    private DatabaseHelper appDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profit_data);

        tableLayout = findViewById(R.id.table_layout);
        appDb = new DatabaseHelper(this);

        Cursor results = appDb.getAllData();
        if (results.getCount() == 0) {
            showMessage("Error Message", "No Data Found!");
            return;
        }
        while (results.moveToNext()){
            TableRow row = new TableRow(this);

            TextView idTextView = new TextView(this);
            idTextView.setText(results.getString(0));
            row.addView(idTextView);

            TextView timeTextView = new TextView(this);
            timeTextView.setText(results.getString(1));
            row.addView(timeTextView);

            TextView plantSeedsTextView = new TextView(this);
            plantSeedsTextView.setText(results.getString(2));
            row.addView(plantSeedsTextView);

            TextView costTextView = new TextView(this);
            costTextView.setText(results.getString(3));
            row.addView(costTextView);

            TextView harvestTextView = new TextView(this);
            harvestTextView .setText(results.getString(4));
            row.addView(harvestTextView );

            TextView incomeTextView = new TextView(this);
            incomeTextView.setText(results.getString(5));
            row.addView(incomeTextView);

            TextView profitTextView = new TextView(this);
            profitTextView.setText(results.getString(6));
            row.addView(profitTextView);

            tableLayout.addView(row);
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}


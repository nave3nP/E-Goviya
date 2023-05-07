package com.project.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfitCal extends AppCompatActivity {
    DatabaseHelper appDb;
    EditText editDate,editPlantWeight,editCost,editIncome,editHarvest,editID;
    Button addDataBtn,updateDataBtn,deleteDataBtn,viewDataBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profit_cal);

        appDb = new DatabaseHelper(this);

        //Define input elements and buttons


        editDate = findViewById(R.id.editTextDate);
        editPlantWeight = findViewById(R.id.editPlantSeed);
        editCost = findViewById(R.id.costText);
        editIncome = findViewById(R.id.incomeText);
        editHarvest = findViewById(R.id.harvestText);
        editID = findViewById(R.id.editTextNumber);

        addDataBtn = findViewById(R.id.addDetailsBtn);
        updateDataBtn = findViewById(R.id.editBtn);
        deleteDataBtn = findViewById(R.id.deleteBtn);
        viewDataBtn = findViewById(R.id.viewBtn);

        addData();
        updateData();
        deleteData();
        viewAll();


    }

    public void addData(){
        addDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float convertedCost = Float.valueOf(editCost.getText().toString());
                Float convertedIncome = Float.valueOf(editIncome.getText().toString());

                boolean isInserted = appDb.insertData(editDate.getText().toString(),editPlantWeight.getText().toString(),
                        convertedCost,editHarvest.getText().toString(),convertedIncome);
                if(isInserted==true)
                    Toast.makeText(ProfitCal.this, "Details Added!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ProfitCal.this, "Details Adding Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateData(){
        updateDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float convertedCost = Float.valueOf(editCost.getText().toString());
                Float convertedIncome = Float.valueOf(editIncome.getText().toString());

                boolean isUpdate = appDb.updateData(editID.getText().toString(),editDate.getText().toString(),editPlantWeight.getText().toString(),
                        convertedCost,editHarvest.getText().toString(),convertedIncome);
                if(isUpdate==true)
                    Toast.makeText(ProfitCal.this, "Data Updated Success", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ProfitCal.this, "Data Updated failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteData(){
        deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedatarows = appDb.deleteData(editID.getText().toString());
                if (deletedatarows>0)
                    Toast.makeText(ProfitCal.this, "Data deleted success!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ProfitCal.this, "Data deleting failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void viewAll(){
        viewDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor results = appDb.getAllData();
                if(results.getCount()==0){
                    showMessage("Error Message","No Data Found!");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (results.moveToNext()){
                    buffer.append("ID :" +results.getString(0)+ "\n");
                    buffer.append("Date :" +results.getString(1)+ "\n");
                    buffer.append("Plant seed weight(Kg) :" +results.getString(2)+ "\n");
                    buffer.append("Cost(Rs.) :" +results.getString(3)+ "\n");
                    buffer.append("Harvest(Kg) :" +results.getString(4)+ "\n");
                    buffer.append("Income(Rs.) :" +results.getString(5)+ "\n");
                    buffer.append("Profit(Rs.) :" +results.getString(6)+ "\n\n");

                    showMessage("List of Data :", buffer.toString());
                }
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


}
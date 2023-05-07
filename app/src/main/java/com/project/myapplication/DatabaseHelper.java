package com.project.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Crop Summary";
    public static final String TABLE_NAME="profitTable";
    public static final String COL_1="ID";
    public static final String COL_2="TIME";
    public static final String COL_3="PLANT_SEEDS";
    public static final String COL_4="COST";
    public static final String COL_5="HARVEST";
    public static final String COL_6="INCOME";
    public static final String COL_7="PROFIT";





    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TIME TEXT, PLANT_SEEDS REAL, COST REAL, HARVEST REAL, INCOME REAL, PROFIT REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String date, String plantSeeds,Float cost, String harvest, Float income){
        Float profit= income - cost;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,plantSeeds);
        contentValues.put(COL_4,cost);
        contentValues.put(COL_5,harvest);
        contentValues.put(COL_6,income);
        contentValues.put(COL_7,profit);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String id, String date, String plantSeeds,Float cost, String harvest, Float income){
        SQLiteDatabase db = this.getWritableDatabase();
        Float profit= income - cost;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,plantSeeds);
        contentValues.put(COL_4,cost);
        contentValues.put(COL_5,harvest);
        contentValues.put(COL_6,income);
        contentValues.put(COL_7,profit);

        db.update(TABLE_NAME,contentValues,"id = ?", new String[] {id});
        return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("Select * from " + TABLE_NAME,null);
        return result;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"id = ?", new String[] {id});
    }
}

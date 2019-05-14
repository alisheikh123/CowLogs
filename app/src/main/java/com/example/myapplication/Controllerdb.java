package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Controllerdb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="SqliteListviewDB";
    public Controllerdb(Context applicationcontext) {
        super(applicationcontext, DATABASE_NAME, null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table to insert data
        String query;
        query = "CREATE TABLE IF NOT EXISTS UserDetails(Id INTEGER PRIMARY KEY AUTOINCREMENT,Username VARCHAR,Mailid VARCHAR,Age VARCHAR,condition VARCHAR,cudate INTEGER,longitunal INTEGER,latitude INTEGER);";

        db.execSQL(query);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ,herefordquery;
        query = "DROP TABLE IF EXISTS UserDetails";

        db.execSQL(query);

        onCreate(db);
    }
}

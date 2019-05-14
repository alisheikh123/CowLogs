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
        String query,herefordquery;
        query = "CREATE TABLE IF NOT EXISTS UserDetails(Id INTEGER PRIMARY KEY AUTOINCREMENT,Username VARCHAR,Mailid VARCHAR,Age VARCHAR);";
        /*herefordquery = "CREATE TABLE IF NOT EXISTS hereuser(Id INTEGER PRIMARY KEY AUTOINCREMENT,Username VARCHAR,Mailid VARCHAR,Age VARCHAR);";*/
        db.execSQL(query);
        /*db.execSQL(herefordquery);
*/

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ,herefordquery;
        query = "DROP TABLE IF EXISTS UserDetails";
        /*herefordquery = "DROP TABLE IF EXISTS hereuser";*/
        db.execSQL(query);
        /*db.execSQL(herefordquery);*/
        onCreate(db);
    }
}

package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowdataListview extends AppCompatActivity {
    Controllerdb controllerdb = new Controllerdb(this);
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> MailId = new ArrayList<String>();
    private ArrayList<String> Age = new ArrayList<String>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata_listview);
        lv = (ListView) findViewById(R.id.listid);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menuitem, menu);

        return true;



    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.profile:

          startActivity(new Intent(this, ProfileFragment.class
          ));

                return true;
            case R.id.Send:

                /*   startActivity(new Intent(this, About.class));*/

                return true;
            case R.id.save:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Database not saved");
                builder.setMessage("Save entries to DB First ? ");
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        saveResult();
                        ShowdataListview.super.onBackPressed();
                    }
                });
                builder.setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ShowdataListview.super.onBackPressed();
                    }
                });
                builder.show();


                return true;

            default:

                return super.onOptionsItemSelected(item);

        }



    }

    private void saveResult() {
    }



    @Override
    protected void onResume() {
        displayData();
        super.onResume();
    }
    private void displayData() {
        db = controllerdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  UserDetails",null);
        Id.clear();
        Name.clear();
        MailId.clear();
        Age.clear();
        if (cursor.moveToFirst()) {
            do {
                Id.add(cursor.getString(cursor.getColumnIndex("Id")));
                Name.add(cursor.getString(cursor.getColumnIndex("Username")));
                MailId.add(cursor.getString(cursor.getColumnIndex("Mailid")));
                Age.add(cursor.getString(cursor.getColumnIndex("Age")));
            } while (cursor.moveToNext());
        }
        CustomAdapter ca = new CustomAdapter(ShowdataListview.this,Id, Name,MailId,Age);
        lv.setAdapter(ca);
        //code to set adapter to populate list
        cursor.close();
    }
}
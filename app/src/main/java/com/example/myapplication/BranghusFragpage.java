package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class BranghusFragpage extends AppCompatActivity implements View.OnClickListener {
    Controllerdb db =new Controllerdb(this);
    SQLiteDatabase database;
    Spinner spinner;
    EditText Name,Mail,Age;
    Button Submitdatabtn,Showdatabtn,pre,home;
    String[] items = new String[]{"Poor", "Average", "Good"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brangus_frag_page);
        spinner = findViewById(R.id.spinAnimal);
        Name= (EditText) findViewById(R.id.etName);
        Mail= (EditText) findViewById(R.id.etMailid);
        Age= (EditText) findViewById(R.id.etAge);
        Submitdatabtn= (Button) findViewById(R.id.btnSave);
        Showdatabtn=(Button) findViewById(R.id.btnShow);
        Submitdatabtn.setOnClickListener(this);
        Showdatabtn.setOnClickListener(this);
        home =findViewById(R.id.nextbtn);
        pre = findViewById(R.id.prebtn);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        spinner.setAdapter(adapter);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BranghusFragpage.this, MainFragPage.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BranghusFragpage.this, MainFragPage.class);
                startActivity(intent);
            }
        });
    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure? This will delete all entries");
        builder.setMessage("Save entries to DB first? ");
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                saveResult();
               BranghusFragpage.super.onBackPressed();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                BranghusFragpage.super.onBackPressed();
            }
        });
        builder.show();
    }

    private void saveResult() {
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.btnSave)
        {
            database=db.getWritableDatabase();
            database.execSQL("INSERT INTO UserDetails(Username,Mailid,Age)VALUES('"+Name.getText()+"','"+Mail.getText()+"','"+Age.getText()+"')" );
            Toast.makeText(this,"Data Inserted To Sqlite Database",Toast.LENGTH_LONG).show();
        }
        else  if(v.getId()==R.id.btnShow)
        {
            Intent intent=new Intent(this,ShowdataListview.class);
            startActivity(intent);

        }
    }
}

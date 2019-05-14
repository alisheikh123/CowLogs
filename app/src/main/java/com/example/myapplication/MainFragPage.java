package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainFragPage extends AppCompatActivity {
        Button ang,bra,sh,here,brng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment_page);
        ang = findViewById(R.id.angusbtn);
        here =findViewById(R.id.herebtn);
        bra=findViewById(R.id.brahmanbtn);
        sh =findViewById(R.id.shorbtn);
        brng =findViewById(R.id.branbtn);
        ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainFragPage.this, AngusFragpage.class);
                startActivity(i);
            }
        });
        here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainFragPage.this, HerefordFragpage.class);
                startActivity(i);
            }
        });
        bra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainFragPage.this, BrahmanFragpage.class);
                startActivity(i);
            }
        });
        sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainFragPage.this, ShorthanFragPage.class);
                startActivity(i);
            }
        });
        brng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainFragPage.this, BranghusFragpage.class);
                startActivity(i);
            }
        });
    }
}

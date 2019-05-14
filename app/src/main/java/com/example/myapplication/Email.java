package com.example.myapplication;

import android.content.Intent;
import android.drm.DrmStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
        private EditText too,subs,mesage;
        private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        too = findViewById(R.id.to);
        subs = findViewById(R.id.sub);
        mesage = findViewById(R.id.msg);
        send = findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendmail();
            }
        });


    }
    private void sendmail(){
        String ToList = too.getText().toString();
        String SubList = subs.getText().toString();
        String []Recep = ToList.split(",");
        String msgs = mesage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,Recep);
        intent.putExtra(Intent.EXTRA_SUBJECT,SubList);
        intent.putExtra(Intent.EXTRA_TEXT,msgs);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose from here"));



    }
}

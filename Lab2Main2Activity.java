package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView ttv1,ttv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ttv1=(TextView)findViewById(R.id.tv1);
        ttv2=(TextView)findViewById(R.id.tv2);
        Intent i = getIntent();
        String name=i.getStringExtra("name");
        String roll=i.getStringExtra("dep");
        ttv1.setText(name);
        ttv2.setText(roll);
    }
}

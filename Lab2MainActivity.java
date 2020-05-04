package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
Button bt;
EditText etname,etroll;
Spinner lv;
    String [] deptArray= {"CSE","EC","BT","IT","MT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(Spinner)findViewById(R.id.listView);
        etname=(EditText)findViewById(R.id.EtName);
        etroll=(EditText)findViewById(R.id.EtRoll);
        bt=(Button)findViewById(R.id.Btsubmit);

        ArrayAdapter<String> myadapter= new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,deptArray);
        lv.setAdapter(myadapter);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,rollno,dep;
                name=etname.getText().toString();
                rollno=etroll.getText().toString();
                dep=lv.getSelectedItem().toString();
                Intent i= new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("name",name);
                i.putExtra("roll",rollno);
                i.putExtra("dep",dep);
                startActivity(i);
            }
        });



    }
}

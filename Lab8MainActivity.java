package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button Btread, Btwrie, Btclear;
    EditText et;
    private String filename = "myfile.txt";
    private String filepath = "MyFileStorage";
    File myFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btclear=(Button)findViewById(R.id.Btclear);
        Btwrie=(Button)findViewById(R.id.Btwrite);
        Btread=(Button)findViewById(R.id.Btread);
        et=(EditText)findViewById(R.id.et);

        myFile= new File(getExternalFilesDir(filepath),filename);

        Btwrie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message=et.getText().toString();
                try{
                    FileOutputStream fout = new FileOutputStream(myFile);
                    fout.write(message.getBytes());
                } catch (IOException e) {
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });

        Btread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message;
                String buf = "";
                try
                {
                    //File f = new File("\\sdcard\\myfile.txt");
                    FileInputStream fin = new FileInputStream(myFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                    while ((message = br.readLine()) != null)
                    {
                        buf += message;
                    }
                    et.setText(buf);
                    br.close();
                    fin.close();
                    Toast.makeText(getBaseContext(),"Data Recived from SDCARD",Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Btclear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                et.setText("");
            }
        });
    }
}

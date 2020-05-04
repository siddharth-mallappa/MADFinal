package com.example.lab5and6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button BtInsert,BtDelete,BtUpdate,BtDisplay;
    EditText EtName, EtMarks;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtInsert=(Button)findViewById(R.id.BtInsert);
        BtDelete=(Button)findViewById(R.id.BtDelete);
        BtUpdate=(Button)findViewById(R.id.BtUpdate);
        BtDisplay=(Button)findViewById(R.id.BtDisplay);
        EtMarks=(EditText)findViewById(R.id.EtStudentMarks);
        EtName=(EditText)findViewById(R.id.EtStudentName);
        builder = new AlertDialog.Builder(this);
        myDB= new DatabaseHelper(this);

        BtInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check=myDB.insert_record(EtName.getText().toString(),Integer.parseInt(EtMarks.getText().toString()));
                if (check==true)
                    Toast.makeText(getBaseContext(),"Success",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        });

        BtDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = myDB.display_all_records();
                if(c.getCount()==0) {
                    //show message

                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("ID:"+c.getString(0)+"\n");
                    buffer.append("NAME:"+c.getString(1)+"\n");
                    buffer.append("MARKS:"+c.getString(2)+"\n"+"\n");
                }
                builder.setMessage(buffer.toString()) .setTitle("STUDENT INFORMATION")
                .setCancelable(true);
                builder.show();

                //Setting message manually and performing action on button click




            }

        });
        BtUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.update_record(EtName.getText().toString(),Integer.parseInt(EtMarks.getText().toString()));
                builder.setMessage("Successfully updated") .setTitle("Status")
                        .setCancelable(true);
                builder.show();

            }
        });
        BtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.delete_record(EtName.getText().toString());
                builder.setMessage("Successfully Deleted") .setTitle("Status")
                        .setCancelable(true);
                builder.show();



            }
        });



        }

    }


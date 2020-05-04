package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;
    int hr,min;
    public static boolean state=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker= (TimePicker) findViewById(R.id.timePicker);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                hr=hourOfDay;
                min=minute;
                String msg= "SET TIME"+hr+min;
                Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
            }
        });
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(state==true)
                        stopTimer();
                    else
                        Toast.makeText(getApplicationContext(),"Alarm not yet set",Toast.LENGTH_SHORT).show();

                } else {

                    setTimer();
                }
            }
        });

    }


    public void setTimer(){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Calendar cal_alarm = Calendar.getInstance();


        Intent i = new Intent(MainActivity.this, AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis(), pendingIntent);


    }
    public  void stopTimer(){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(MainActivity.this, AlarmReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);
        alarmManager.cancel(pendingIntent);
        Ringtone r = AlarmReciever.ringtone;
        r.stop();
        Toast.makeText(getApplicationContext(),"Alarm OFF",Toast.LENGTH_SHORT).show();
    }




}

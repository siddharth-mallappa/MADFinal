package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.button);
        et=(EditText)findViewById(R.id.editText);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                msg= et.getText().toString();
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,4,i,0);
                Notification notification = new Notification.Builder(MainActivity.this).
                        setContentTitle("Message").setContentText(msg).setSmallIcon(R.mipmap.ic_launcher).
                        setContentIntent(pendingIntent).build();
                notification.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                nm.notify(4,notification);


            }
        });


    }
}

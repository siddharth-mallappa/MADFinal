package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReciever extends BroadcastReceiver {
    public static Ringtone ringtone;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"WAKE THE FUCK UP",Toast.LENGTH_LONG).show();

        Uri alramUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alramUri==null){
           alramUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        MainActivity.state=true;
        ringtone = RingtoneManager.getRingtone(context,alramUri);
        ringtone.play();
    }
}

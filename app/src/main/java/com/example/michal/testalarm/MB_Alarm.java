package com.example.michal.testalarm;

import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.SystemClock;

import static android.app.AlarmManager.*;


/**
 * Created by michal on 5.9.2017.
 */

public class MB_Alarm {

    private AlarmManager alarmMgr = null;
    private PendingIntent alarmIntent = null;

    public MB_Alarm() {}

    public void setSimpleTimer(Context context){
/*
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intentReceiverAlarm, 0);

        alarmMgr.set(AlarmManager.RTC_WAKEUP,
                SystemClock.elapsedRealtime() + 3 * 1000, alarmIntent);
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MB_ReceiverAlarm.class);
        intent.putExtra("onetime", Boolean.FALSE);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        //After after 5 seconds
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 5 , alarmIntent);
*/

        /*
        int i = 3;
        Intent intent = new Intent(context, MB_ReceiverAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);
        */


        // Set the alarm to start at approximately 2:00 p.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 14);

        // With setInexactRepeating(), you have to use one of the AlarmManager interval
        // constants--in this case, AlarmManager.INTERVAL_DAY.
        alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, alarmIntent);
    }


}

package com.example.michal.testalarm;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.VibrationEffect;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
import java.util.Calendar;
import android.os.Vibrator;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by michal on 3.9.2017.
 */

public class MB_ReceiverAlarm extends BroadcastReceiver {

    MediaPlayer mplayer = null;
    private static Boolean use_toast = false;
    private static Boolean use_vibrator = false;
    private static Boolean use_notify = false;
    private static Boolean use_sound = false;

    public static void setUseToast(Boolean useToast) {
        use_toast = useToast;
    }

    public static void setUseVibrator(Boolean useVibrator) {
        use_vibrator = useVibrator;
    }

    public static void setUseNotify(Boolean useNotify) {
        use_notify = useNotify;
    }

    public static void setUseSound(Boolean useSound) {
        use_sound = useSound;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {

            if(use_toast)
                Toast.makeText(context, "MY ALARM :)", Toast.LENGTH_LONG).show();

            if(use_vibrator) {
                Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(2000);
            }

            if(use_notify) {

                // use System.currentTimeMillis() to have a unique ID for the pending intent
                PendingIntent pIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

                // build notification
                // the addAction re-use the same intent to keep the example short
                Notification n  = new Notification.Builder(context)
                        .setContentTitle("New mail from " + "test@gmail.com")
                        .setContentText("Subject")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent)
                        .setAutoCancel(true).getNotification();;


                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(0, n);

                Toast.makeText(context, "MY Notify :)", Toast.LENGTH_LONG).show();
            }

            if(use_sound) {

                Uri uriRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

                if(uriRingtone == null){
                    // alert is null, using backup
                    uriRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                    // I can't see this ever being null (as always have a default notification)
                    // but just incase
                    if(uriRingtone == null) {
                        // alert backup is null, using 2nd backup
                        uriRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                    }
                }

                if(uriRingtone != null){
                    mplayer = MediaPlayer.create(context.getApplicationContext(), uriRingtone);
                    mplayer.setLooping(false);
                    mplayer.start();
                }

            }

        //}

    }
}

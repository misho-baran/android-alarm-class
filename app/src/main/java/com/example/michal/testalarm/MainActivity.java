package com.example.michal.testalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.CheckBox;



public class MainActivity extends AppCompatActivity  implements OnClickListener {

    private Button btn_exit = null;
    private Button btn_run = null;
    private TextView textView_info = null;
    private CheckBox checkBox_toast = null;
    private CheckBox checkBox_vibrate = null;
    private CheckBox checkBox_notify= null;
    private CheckBox checkBox_sound = null;
    private MB_Alarm alarm = null;

    private void initComponents() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView_info = (TextView) findViewById(R.id.textView_info);

        btn_run = (Button) findViewById(R.id.btn_AlarmActivity);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        checkBox_toast = (CheckBox) findViewById(R.id.checkBox_toast);
        checkBox_vibrate = (CheckBox) findViewById(R.id.checkBox_vibrate);
        checkBox_notify = (CheckBox) findViewById(R.id.checkBox_notify);
        checkBox_sound = (CheckBox) findViewById(R.id.checkBox_sound);

        btn_run.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
        checkBox_toast.setOnClickListener(this);
        checkBox_vibrate.setOnClickListener(this);
        checkBox_notify.setOnClickListener(this);
        checkBox_sound.setOnClickListener(this);

        alarm = new MB_Alarm();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.btn_AlarmActivity:
                textView_info.setText("Alarm activated...");

                alarm.setSimpleTimer(this.getApplicationContext());
                //Intent intentMainTabActivity = new Intent(this, MaintabActivity.class);
                //startActivity(intentMainTabActivity);
                break;

            case R.id.btn_exit:
                // this.finishAndRemoveTask();
                finish();
                System.exit(0);
                break;

            case R.id.checkBox_toast:
                if(checkBox_toast.isChecked())
                {
                    MB_ReceiverAlarm.setUseToast(true);
                }else{
                    MB_ReceiverAlarm.setUseToast(false);
                }
                break;

            case R.id.checkBox_vibrate:
                if(checkBox_vibrate.isChecked())
                {
                    MB_ReceiverAlarm.setUseVibrator(true);
                }else{
                    MB_ReceiverAlarm.setUseVibrator(false);
                }
                break;

            case R.id.checkBox_notify:
                if(checkBox_notify.isChecked())
                {
                    MB_ReceiverAlarm.setUseNotify(true);
                }else{
                    MB_ReceiverAlarm.setUseNotify(false);
                }
                break;

            case R.id.checkBox_sound:
                if(checkBox_sound.isChecked())
                {
                    MB_ReceiverAlarm.setUseSound(true);
                }else{
                    MB_ReceiverAlarm.setUseSound(false);
                }
                break;

            default:
                break;
        }

    }



}

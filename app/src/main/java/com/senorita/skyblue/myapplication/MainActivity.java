package com.senorita.skyblue.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static boolean flag = false;

    public static Timer timer ;

    public static TimerTask singer;
    private CheckBox chkPk;
    public static boolean isPkFan = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag = true;
        addListenerOnChkIos();
    }


    public void addListenerOnChkIos() {

        chkPk = (CheckBox) findViewById(R.id.chkIos);

        chkPk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    isPkFan = true;
                    Toast.makeText(MainActivity.this,
                            "Power Mode Activated", Toast.LENGTH_LONG).show();
                }else{
                    isPkFan = false;
                    Toast.makeText(MainActivity.this,
                            "Power Mode DeActivated", Toast.LENGTH_LONG).show();
                }

            }
        });

    }


    public void sendMessage(View view) {
        // Do something in response to button
         Button testButton = (Button) findViewById(R.id.start);
        if(flag){
            flag=!flag;
            timer = new Timer();
            Context context =getApplicationContext();
            singer = new SongTimer(context,isPkFan);
            timer.scheduleAtFixedRate(singer,0,  30000);
            testButton.setText("Stop Journey");

        }else{
            flag=!flag;
            timer.cancel();
            timer.purge();
            singer.cancel();
            testButton.setText("Start Journey");
        }

    }





}

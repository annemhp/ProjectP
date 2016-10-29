package com.senorita.skyblue.lele;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static boolean flag = false;

    public static Timer timer ;

    public static TimerTask singer;
    private ImageButton powerMode ;
    public static boolean isPkFan = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag = true;
        addListenerOnChkIos();
    }


    public void addListenerOnChkIos() {
        powerMode = (ImageButton) findViewById(R.id.imageButton);
        powerMode.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                powerMode.setEnabled(false);
                if (!isPkFan) {
                    isPkFan = true;
                    Toast.makeText(MainActivity.this,
                            "Power Mode Activated", Toast.LENGTH_LONG).show();
                }else{
                    isPkFan = false;
                    Toast.makeText(MainActivity.this,
                            "Power Mode DeActivated", Toast.LENGTH_LONG).show();
                }
                powerMode.setEnabled(true);

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

package com.senorita.skyblue.lele;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public static boolean notPlaying = false;

    public static Timer timer ;

    public static TimerTask singer;
    private ImageButton powerMode ;
    public static boolean isPkFan = false;
    private RelativeLayout mainLayout ;
    public static Button testButton ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notPlaying = true;
        addListenerOnChkIos();
        mainLayout= (RelativeLayout) findViewById(R.id.layout);
         testButton = (Button) findViewById(R.id.start);
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
                    mainLayout.setBackgroundResource(R.drawable.bg_power);
                    Toast.makeText(MainActivity.this,
                            "Power Mode Activated", Toast.LENGTH_LONG).show();
                }else{
                    isPkFan = false;
                    mainLayout.setBackgroundResource(R.drawable.lele_bg);
                    Toast.makeText(MainActivity.this,
                            "Power Mode DeActivated", Toast.LENGTH_LONG).show();
                }
                if (!notPlaying){
                    stop();
                    play();
                }

                powerMode.setEnabled(true);

            }
        });

    }


    public void sendMessage(View view) {
        // Do something in response to button


        if(notPlaying){
            play();
        }else{
            stop();
        }



    }


    public void play(){
        notPlaying =!notPlaying;
        timer = new Timer();
        Context context =getApplicationContext();
        singer = new SongTimer(context,isPkFan);
        timer.scheduleAtFixedRate(singer,0,  30000);
        testButton.setText("Stop Journey");


    }


    public void stop(){
        notPlaying =!notPlaying;
        timer.cancel();
        timer.purge();
        singer.cancel();
        testButton.setText("Start Journey");

    }


}

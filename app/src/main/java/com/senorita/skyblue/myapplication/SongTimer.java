package com.senorita.skyblue.myapplication;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by seshasayanaannam on 10/18/16.
 */
public class SongTimer extends TimerTask {

    private static Context context=null;
    private static ArrayList<MediaPlayer>  items , pkItems , finalList;
    private static MediaPlayer  current ;
    public static boolean isPkFan = false;




    public SongTimer(Context context,boolean isPkFan) {

        this.context =context;
        MediaPlayer mediaPlayer;
        items = new ArrayList<MediaPlayer>();
        pkItems = new ArrayList<MediaPlayer>();


        mediaPlayer = MediaPlayer.create(context, R.raw.a_1);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_2);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_3);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_4);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_5);
        items.add(mediaPlayer);



        mediaPlayer = MediaPlayer.create(context, R.raw.pk_1);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_2);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_3);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_4);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_5);
        pkItems.add(mediaPlayer);
    if(isPkFan){
        finalList= pkItems;
    }else{
        finalList= items;
    }


    }




    @Override
    public void run() {
        current=    finalList.get(getRandomNumberInRange(0,4));
        current.start();
    }

    @Override
    public boolean cancel() {
        if(current.isPlaying()){
            current.stop();
        }
        return super.cancel();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

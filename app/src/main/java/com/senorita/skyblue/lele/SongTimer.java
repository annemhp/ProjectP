package com.senorita.skyblue.lele;

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
    private static  MediaPlayer  current=null;
    public static boolean isPkFan = false;
    public static  int ind =0;




    public SongTimer(Context context,boolean isPkFan) {
        ind =getRandomNumberInRange(0,19);

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


        mediaPlayer = MediaPlayer.create(context, R.raw.a_6);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_7);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_8);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_9);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_10);
        items.add(mediaPlayer);


        mediaPlayer = MediaPlayer.create(context, R.raw.a_11);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_12);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_13);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_14);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_15);
        items.add(mediaPlayer);

        mediaPlayer = MediaPlayer.create(context, R.raw.a_16);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_17);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_18);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_19);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_20);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_21);
        items.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.a_22);
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
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_6);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_7);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_8);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_9);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_10);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_11);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_12);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_13);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_14);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_15);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_16);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_17);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_18);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_19);
        pkItems.add(mediaPlayer);
        mediaPlayer = MediaPlayer.create(context, R.raw.pk_20);
        pkItems.add(mediaPlayer);
    if(isPkFan){
        finalList= pkItems;
    }else{
        finalList= items;
    }


    }




    @Override
    public void run() {
        if(ind==20){
            ind = 0;
        }
        current=    finalList.get(ind++);
        if(!current.isPlaying()) {
            current.start();
        }
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

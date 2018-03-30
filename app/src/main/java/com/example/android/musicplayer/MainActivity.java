package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.the_magic);
    }

    public void playMusic(View view)
    {
        try
        {
            mp.start();
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
    }

    public void pauseMusic(View view)
    {
        if(mp.isPlaying())
        {
            mp.pause();
        }
    }

    public void stopMusic(View view)
    {
        if(mp.isPlaying())
        {
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.the_magic);
        }
    }


}

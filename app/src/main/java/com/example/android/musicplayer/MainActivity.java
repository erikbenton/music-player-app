package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.the_magic);

        Button playButton  = (Button)findViewById(R.id.play_button);
        Button pauseButton = (Button)findViewById(R.id.pause_button);
        Button stopButton  = (Button)findViewById(R.id.stop_button);


        /**
         * Adding onClick listener for playing music
         */
        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                playMusic();
            }
        });

        /**
         * Adding onClick listener for pausing music
         */
        pauseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pauseMusic();
            }
        });

        /**
         * Adding onClick listener for stopping music
         */
        stopButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                stopMusic();
            }
        });

    }

    public void playMusic()
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

    public void pauseMusic()
    {
        if(mp.isPlaying())
        {
            mp.pause();
        }
    }

    public void stopMusic()
    {
        if(mp.isPlaying())
        {
            mp.stop();
            mp = MediaPlayer.create(this, R.raw.the_magic);
        }
    }


}

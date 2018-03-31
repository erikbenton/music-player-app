package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.the_magic);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast toast=Toast.makeText(getApplicationContext(),"I'm done!",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

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

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(mp != null)
        {
            mp.release();
            mp = null;
        }
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

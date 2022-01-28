package com.example.jaman.onnline;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Channel1 extends AppCompatActivity {

    Button b_play;
    Button c_play;
    Button d_play;


    MediaPlayer mediaPlayer;

    boolean prepared = false;
    boolean started = false;

    String stream =  "http://118.179.219.244:8000/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel1);


        c_play = (Button)findViewById(R.id.c_play);
        c_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Channel1.this,Channel2.class);
                startActivity(i);
            }
        });

        d_play = (Button)findViewById(R.id.d_play);
        d_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Channel1.this,Channel10.class);
                startActivity(i);
            }
        });

        b_play = (Button)findViewById(R.id.b_play);
        b_play.setEnabled(false);
        b_play.setText("LOADING");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        new PlayerTask().execute(stream);

        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started){
                    started = false;
                    mediaPlayer.pause();
                    b_play.setText("PLAY");
                }
                else{
                    started = true;
                    mediaPlayer.start();
                    b_play.setText("PAUSE");
                }
            }
        });
    }

     class PlayerTask extends AsyncTask<String,Void,Boolean>{

         @Override
         protected Boolean doInBackground(String... strings) {

             try {
                 mediaPlayer.setDataSource(strings[0]);
                 mediaPlayer.prepare();
                 prepared = true;
             } catch (IOException e) {
                 e.printStackTrace();
             }

             return prepared;
         }

         @Override
         protected void onPostExecute(Boolean aBoolean) {
             super.onPostExecute(aBoolean);
             b_play.setEnabled(true);
             b_play.setText("PLAY");
         }

     }

    @Override
    protected void onPause() {
        super.onPause();
        if(started){
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(started){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(prepared){
            mediaPlayer.release();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}

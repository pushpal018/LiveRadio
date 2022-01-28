package com.example.jaman.onnline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run(){

                Intent radioIntent = new Intent(MainActivity.this,RadioActivity.class);
                startActivity(radioIntent);
                finish();
            }

        },SPLASH_TIME_OUT);
    }
}
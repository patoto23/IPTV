package com.example.user.iptv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by User on 8/30/2017.
 */

public class StartupActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_main);

        int secondsDelayed = 1;
             new Handler().postDelayed(new Runnable() {
                public void run() {
                  startActivity(new Intent(StartupActivity.this, ActivityB.class));
                    finish();
            }
    }, secondsDelayed * 5000);
 }


}
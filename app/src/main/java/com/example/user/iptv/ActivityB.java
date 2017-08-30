package com.example.user.iptv;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

public class ActivityB extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//    private static final int STOPSPLASH = 0;
//    private static final long SPLASHTIME = 3000;
//    private ImageView splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Spinner channelDropdown = (Spinner)findViewById(R.id.channelSpinner);
        setSupportActionBar(toolbar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.channel_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        channelDropdown.setAdapter(adapter);
        channelDropdown.setOnItemSelectedListener(this);

//        splash = (ImageView) findViewById(R.id.splashscreen);
//        Message msg = new Message();
//        msg.what = STOPSPLASH;
//        splashHandler.sendMessageDelayed(msg, SPLASHTIME);



        //String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
        //String vidAddress = "http://r.gslb.lecloud.com/live/hls/201706223000000b899/desc.m3u8";
        //String vidAddress = "udp://@224.010.020.033:1234";



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void streamVideo(String vidAddress){

        Uri vidUri = Uri.parse(vidAddress);
        VideoView vidView = (VideoView)findViewById(R.id.myVideo);
        vidView.setVideoURI(vidUri);
        vidView.start();
    }


//    private Handler splashHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case STOPSPLASH:
//                    //remove SplashScreen from view
//                    splash.setVisibility(View.GONE);
//                    break;
//            }
//            super.handleMessage(msg);
//        }
//    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position , long id) {


        switch (position){

            case 0:
                //Select Channel
                //streamVideo("d");
                break;
            case 1:
                //ABSCBN
                streamVideo("http://r.gslb.lecloud.com/live/hls/201706223000000b899/desc.m3u8");
                break;
            case 2:
                //KC HD
                streamVideo("http://www.kalibocable.net/images/KaliboCable.m3u");
                break;
            case 3:
                //GMA
                streamVideo("http://midnightiptvstreams.ddns.net:5050/live/tommy1/tommy1/62064.ts");
                break;
            case 4:
                //TV5
                streamVideo("http://tv.best.iptv.uno:8080/live/FreeTech/tDdQHz9241/16511.ts");
                break;
            case 5:
                streamVideo("D:\\torrents\\Dragon Ball Super - Season 1\\Dragon Ball Super 1.mp4");
                break;
            case 6:
                streamVideo("D:\\torrents\\Dragon Ball Super - Season 1\\Dragon Ball Super 1.mp4");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}

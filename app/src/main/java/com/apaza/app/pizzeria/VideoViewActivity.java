package com.apaza.app.pizzeria;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.content.Intent;
import android.view.View.OnClickListener;

public class VideoViewActivity extends AppCompatActivity {

    private VideoView videoView;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView = (VideoView) findViewById(R.id.videoview);
        videoView.setMediaController(new MediaController(this));
//        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pizza_hut));
        videoView.start();
        controlador();
    }

    public void controlador(){
        imagen = (ImageView)findViewById(R.id.imageViewBoton);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), SpinnerActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}


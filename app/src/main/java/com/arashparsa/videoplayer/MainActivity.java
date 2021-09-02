package com.arashparsa.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

public class MainActivity extends AppCompatActivity {

    //VideoView videoView;
    ExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //simple Video Player
    /*    videoView = findViewById(R.id.videoView_main);
        videoView.setVideoPath("https://hajifirouz3.cdn.asset.aparat.com/aparat-video/4a479e06549f68cdabe1fdb70e8a91fd37131234-480p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjVkYzY1YzRkZDMzMGM4NjBlYTM5MTcwYjIwZjU5M2NkIiwiZXhwIjoxNjMwNTgzMTUxLCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.a205Rnh4WkqaVvTnnPrGrK2yKw3Uy4uw9o_ks6VCSSw");
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
            }
        });


        videoView.seekTo(15000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }*/

        //exo player
        PlayerView playerView = findViewById(R.id.videoView_main);
        exoPlayer = new SimpleExoPlayer.Builder(this).build();
        //deprecated
        /*  DataSource.Factory factory = new DefaultDataSourceFactory(this, Util.getUserAgent(this,getString(R.string.app_name)));
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(factory).createMediaSource(Uri.parse("https://hajifirouz3.cdn.asset.aparat.com/aparat-video/4a479e06549f68cdabe1fdb70e8a91fd37131234-480p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjVkYzY1YzRkZDMzMGM4NjBlYTM5MTcwYjIwZjU5M2NkIiwiZXhwIjoxNjMwNTgzMTUxLCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.a205Rnh4WkqaVvTnnPrGrK2yKw3Uy4uw9o_ks6VCSSw"));
        exoPlayer.prepare(mediaSource);
        exoPlayer.setPlayWhenReady(true);
        */

        MediaItem mediaItem = MediaItem.fromUri(Uri.parse("https://hajifirouz3.cdn.asset.aparat.com/aparat-video/4a479e06549f68cdabe1fdb70e8a91fd37131234-480p.mp4?wmsAuthSign=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjVkYzY1YzRkZDMzMGM4NjBlYTM5MTcwYjIwZjU5M2NkIiwiZXhwIjoxNjMwNTgzMTUxLCJpc3MiOiJTYWJhIElkZWEgR1NJRyJ9.a205Rnh4WkqaVvTnnPrGrK2yKw3Uy4uw9o_ks6VCSSw"));
        // Set the media item to be played.
        exoPlayer.setMediaItem(mediaItem);
        // Prepare the player.
        exoPlayer.prepare();
        // Start the playback.
        exoPlayer.play();
        playerView.setPlayer(exoPlayer);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exoPlayer.release();
    }
}
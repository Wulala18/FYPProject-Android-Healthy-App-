package com.example.fitnessapp.Functions.WorkoutCategories.AbsDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessapp.Functions.WorkoutCategories.YoutubeConfigs;
import com.example.fitnessapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;

public class BicycleKicks  extends YouTubeBaseActivity implements  YouTubePlayer.OnInitializedListener,YouTubePlayer.PlaybackEventListener,YouTubePlayer.PlayerStateChangeListener{

    com.google.android.youtube.player.YouTubePlayerView myoutube;
    String VIDEO_ID ="9FGilxCbdz8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bicycle_kicks);

        myoutube = findViewById(R.id.bkvideo);
        myoutube.initialize(YoutubeConfigs.getApiKey(),this);
    }

    public void bk_btn(View view) {
        startActivity(new Intent(getApplicationContext(), Absworkout.class));
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(this);
        youTubePlayer.setPlaybackEventListener(this);

        if(!b)
        {
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {

    }
}
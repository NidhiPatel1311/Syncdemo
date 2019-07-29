package com.example.tech_5.syncdemo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimDemoActivity extends AppCompatActivity {

    private static final String TAG = AnimDemoActivity.class.getSimpleName();

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_demo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.album2);
    }

    public void zoom(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        mImageView.startAnimation(animation1);
    }

    public void move(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        mImageView.startAnimation(animation1);
    }

    public void blink(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        mImageView.startAnimation(animation1);
    }

    public void slideUp(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        mImageView.startAnimation(animation1);
    }

    public void fade(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mImageView.startAnimation(animation1);
    }

    public void fadeout(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        mImageView.startAnimation(animation1);
    }

    public void slideDown(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        mImageView.startAnimation(animation1);
    }

    public void crossfade(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        mImageView.startAnimation(animation1);
    }

    public void rotate(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        mImageView.startAnimation(animation1);
    }
    public void together(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
        mImageView.startAnimation(animation1);
    }
    public void bounce(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        mImageView.startAnimation(animation1);
    }
    public void sequential(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential);
        mImageView.startAnimation(animation1);
    }
}

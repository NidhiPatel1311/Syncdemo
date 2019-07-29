package com.example.tech_5.syncdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class VectorActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);

        mImageView = (ImageView)findViewById(R.id.imageView);
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.path_morph);
        mImageView.startAnimation(hyperspaceJumpAnimation);
    }

}
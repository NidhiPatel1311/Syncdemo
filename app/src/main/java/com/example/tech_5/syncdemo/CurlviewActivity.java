package com.example.tech_5.syncdemo;

import android.support.v7.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;


public class CurlviewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curlview);
        PageCurlView pageCurlView = (PageCurlView) findViewById(R.id.pagecurl_view);

        List<Integer> pages_id = new ArrayList<>();
        pages_id.add(R.drawable.album1);
        pages_id.add(R.drawable.album2);

        pageCurlView.setCurlView(pages_id);
        pageCurlView.setCurlSpeed(55);

    }
}

package com.example.tech_5.syncdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;


public class SpinActivity extends AppCompatActivity {

    ProgressBar progressBar,progressBar1;
    Button  invisibleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spin);

        progressBar =(ProgressBar) findViewById(R.id.SpinKit);
        progressBar1 =(ProgressBar) findViewById(R.id.SpinKit2);

        Wave wave = new Wave();
        WanderingCubes wanderingCubes= new WanderingCubes();
        RotatingPlane rotatingPlane = new RotatingPlane();
        DoubleBounce doubleBounce= new DoubleBounce();
        Pulse pulse = new Pulse();
        ChasingDots chasingDots = new ChasingDots();
        ThreeBounce threeBounce = new ThreeBounce();
        Circle circle = new Circle();
        CubeGrid cubeGrid = new CubeGrid();
        FadingCircle fadingCircle = new FadingCircle();
        FoldingCube foldingCube = new FoldingCube();
        RotatingCircle rotatingCircle = new RotatingCircle();

//        progressBar.setIndeterminateDrawable(threeBounce);
//        progressBar1.setIndeterminateDrawable(circle);

//        progressBar.setIndeterminateDrawable(fadingCircle);
//        progressBar1.setIndeterminateDrawable(foldingCube);

//        progressBar.setIndeterminateDrawable(pulse);
//        progressBar1.setIndeterminateDrawable(doubleBounce);

//        progressBar.setIndeterminateDrawable(wave);
//        progressBar1.setIndeterminateDrawable(wanderingCubes);

        progressBar.setIndeterminateDrawable(cubeGrid);
        progressBar1.setIndeterminateDrawable(rotatingPlane);

        invisibleBtn= (Button) findViewById(R.id.Btn);

        invisibleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.INVISIBLE);
                progressBar1.setVisibility(View.INVISIBLE);
            }
        });

    }
}

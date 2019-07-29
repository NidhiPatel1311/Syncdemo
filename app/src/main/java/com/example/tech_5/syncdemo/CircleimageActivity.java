package com.example.tech_5.syncdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class CircleimageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circleimage);

        CircularImageView circularImageView = (CircularImageView)findViewById(R.id.yourCircularImageView);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorGreyLight));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);

//        String str = "<a>This is a  <font color='blue'> blue text</font> and this is a <font color='red'> red text</font> </a>";
//
//        TextView textView = (TextView)findViewById(R.id.text);
//        textView.setText(Html.fromHtml(str, Html.FROM_HTML_MODE_COMPACT));
    }


}

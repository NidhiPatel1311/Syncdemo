package com.example.tech_5.syncdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import com.example.tech_5.syncdemo.Helper.PrefManager;


public class SmsdetailActivity extends AppCompatActivity {

  //  private Toolbar toolbar;
    private PrefManager pref;
    private TextView name, email, mobile;
    Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsdetail);

     //   toolbar = (Toolbar) findViewById(R.id.toolbar);
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        mobile = (TextView) findViewById(R.id.mobile);
        btnSignOut=findViewById(R.id.btn_sign_out);

        // enabling toolbar
//               setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        pref = new PrefManager(getApplicationContext());


        // Checking if user session
        // if not logged in, take user to sms screen
        if (!pref.isLoggedIn()) {
            logout();
        }

        // Displaying user information from shared preferences
        HashMap<String, String> profile = pref.getUserDetails();
        name.setText("Name: " + profile.get("name"));
        email.setText("Email: " + profile.get("email"));
        mobile.setText("Mobile: " + profile.get("mobile"));

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.clearSession();
                startActivity(new Intent(SmsdetailActivity.this,SmsActivity.class));
                finish();
            }
        });
    }

    private void logout() {
        pref.clearSession();

        Intent intent = new Intent(SmsdetailActivity.this, SmsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);

        finish();
    }

}

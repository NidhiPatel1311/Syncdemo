package com.example.tech_5.syncdemo;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;

public class Animationdemo extends AppCompatActivity {

    Cursor mCursor;
    int mIdColumn;
    int mLookupKeyColumn;
    Uri mContactUri;
    QuickContactBadge mBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationdemo);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("");

//        mBadge = (QuickContactBadge) findViewById(R.id.quickbadge);
//
//        mIdColumn = mCursor.getColumnIndex(ContactsContract.Contacts._ID);
//        // Gets the LOOKUP_KEY index
//        mLookupKeyColumn = mCursor.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY);
//        // Gets a content URI for the contact
//        mContactUri =
//                ContactsContract.Contacts.getLookupUri(
//                        mCursor.getLong(mIdColumn),
//                        mCursor.getString(mLookupKeyColumn)
//                );
//        mBadge.assignContactUri(mContactUri);
    }

    public void springclk(View view) {
        Intent intent = new Intent(getApplicationContext(), SpringAnimationdemo.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void democlk(View view) {
        Intent intent = new Intent(getApplicationContext(), AnimDemoActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void vectorclk(View view) {
        Intent intent = new Intent(getApplicationContext(), VectorActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
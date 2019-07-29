package com.example.tech_5.syncdemo;


import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.tech_5.syncdemo.Adapter.NameAdapter;
import com.example.tech_5.syncdemo.Helper.SQLiteHandler;
import com.example.tech_5.syncdemo.Helper.SessionManager;
import com.example.tech_5.syncdemo.Model.Name;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import android.widget.Toolbar;

@SuppressWarnings("ALL")
public class
MainActivity extends AppCompatActivity implements View.OnClickListener {



    public static final String URL_SAVE_NAME = "https://purposeofliving.000webhostapp.com/ionic/saveName.php";
    private DatabaseHelper db;

    private Button buttonSave;
    private EditText editTextName;
    private EditText editTextMobile,editTextEmail,editTextCity;
    private ListView listViewNames;

    private List<Name> names;

    public static final int NAME_SYNCED_WITH_SERVER = 1;
    public static final int NAME_NOT_SYNCED_WITH_SERVER = 0;

    public static final String DATA_SAVED_BROADCAST = "com.example.tech_5.datasaved";

    private BroadcastReceiver broadcastReceiver;

    private NameAdapter nameAdapter;

    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;

    private SQLiteHandler db1;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Welcome");

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);

        //btnLogout = (Button) findViewById(R.id.btnLogout);

        // SqLite database handler
        db1 = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db1.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);

        // Logout button click event
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                logoutUser();
//            }
//        });


    //     registerReceiver(new NetworkStateChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


        db = new DatabaseHelper(this);
        names = new ArrayList<>();

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextMobile = (EditText) findViewById(R.id.editTextMobile);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextCity = (EditText) findViewById(R.id.editTextCity);
        listViewNames = (ListView) findViewById(R.id.listViewNames);

        //adding click listener to button
        buttonSave.setOnClickListener(this);

        //calling the method to load all the stored names
        loadNames();

        //the broadcast receiver to update sync status
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                //loading the names again
                loadNames();
            }


        };

        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.registerReceiver(new NetworkStateChecker(), intentFilter);
        //registering the broadcast receiver to update sync status
//        registerReceiver(broadcastReceiver, new IntentFilter(DATA_SAVED_BROADCAST));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {

        case R.id.btnLogout:
                    logoutUser();
            return true;
    }
        return(super.onOptionsItemSelected(item));
    }
//    @Override
//    public void onResume(){
//        super.onResume();
//        registerReceiver(new NetworkStateChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//    }
//
//    @Override
//    public void onPause() {
//        unregisterReceiver(new NetworkStateChecker());
//        super.onPause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(broadcastReceiver !=null) {
//
//            this.unregisterReceiver(new NetworkStateChecker());
//        }
//    }



    private void logoutUser() {
        session.setLogin(false);

        db1.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void loadNames() {
        names.clear();
        Cursor cursor = db.getNames();
        if (cursor.moveToFirst()) {
            do {
                Name name = new Name(
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)),cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME1)),cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME2)),cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME3)),
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_STATUS))
                );
                names.add(name);
            } while (cursor.moveToNext());
        }

        nameAdapter = new NameAdapter(this, R.layout.names, names);
        listViewNames.setAdapter(nameAdapter);
    }

    /*
     * this method will simply refresh the list
     * */
    private void refreshList() {
        nameAdapter.notifyDataSetChanged();
    }

    /*
     * this method is saving the name to there server
     * */
    private void saveNameToServer() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving Name...");
        progressDialog.show();

        final String name = editTextName.getText().toString().trim();
        final String mobileno = editTextMobile.getText().toString().trim();
        final String emailid = editTextEmail.getText().toString().trim();
        final String city = editTextCity.getText().toString().trim();
  //     final int status = 0;


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SAVE_NAME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                //if there is a success
                                //storing the name to sqlite with status synced
                                saveNameToLocalStorage(name,mobileno,emailid,city, NAME_SYNCED_WITH_SERVER);

                            }
                            else {
                                //if there is some error
                                //saving the name to sqlite with status unsynced
                             saveNameToLocalStorage(name,mobileno,emailid,city, NAME_NOT_SYNCED_WITH_SERVER);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        //on error storing the name to sqlite with status unsynced
                        saveNameToLocalStorage(name,mobileno,emailid,city, NAME_NOT_SYNCED_WITH_SERVER);
                    }
                }
                ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("mobileno", mobileno);
                params.put("emailid", emailid);
                params.put("city", city);
   //           params.put("status", status);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    //saving the name to local storage
    private void saveNameToLocalStorage(String name, String mobileno, String emailid, String city, int status) {
        editTextName.setText("");
        editTextMobile.setText("");
        editTextEmail.setText("");
        editTextCity.setText("");

        db.addName(name,mobileno,emailid,city,status);
        Name n = new Name(name,mobileno,emailid,city,status);
        names.add(n);
        refreshList();
    }

    @Override
    public void onClick(View view) {
        saveNameToServer();
    }

    public void directoryBtnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MainDetailActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}

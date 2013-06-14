package com.nighthawkapps.android2do;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;


public class todoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        Context context = (Context) this;
        SharedPreferences sharedPref = context.getSharedPreferences(
        getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPref.edit();
        //editor.putInt(getString(R.string.loggedin), 0);
        //editor.commit();
        int defaultValue = 0;
        int loggedin = sharedPref.getInt(getString(R.string.loggedin), defaultValue);

        if (loggedin == 0){
            Intent login = new Intent(this,Login.class);
            startActivity(login);
        }
        else{
            setContentView(R.layout.activity_main);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo, menu);
        return true;
    }
    
}

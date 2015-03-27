package com.mygymcompanion.mygymcompanion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

/**
 * Created by Jordan on 22/03/2015.
 */
public class StatsActivity extends ActionBarActivity {
    //few views with data from sharedpreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        display();
    }

    public void display() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String fullLog = "";
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String s = entry.toString();
            if ((s.contains("Day")) && (s.contains(">"))) {
                String[] workoutEntry = s.split(">=");


                fullLog = fullLog + workoutEntry[1] + "\n\n";

            }
        }
        EditText editText = (EditText) findViewById(R.id.historyText);
        if (fullLog == "") {
            editText.setText("No workouts have been completed yet!");
        } else {
            editText.setText(fullLog);
        }

    }
}

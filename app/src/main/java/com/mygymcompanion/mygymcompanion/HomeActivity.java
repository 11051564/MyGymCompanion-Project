package com.mygymcompanion.mygymcompanion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
 * Created by Jordan on 22/03/2015.
 */
public class HomeActivity extends ActionBarActivity {

    private Button buttonReset, buttonStats, buttonWorkout, buttonBMI, buttonMachines, buttonEditWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final SharedPreferences.Editor editor = settings.edit();

        Boolean firstTime = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean("FirstLaunch", true);
        if(firstTime) {
            Intent myIntent = new Intent(HomeActivity.this, FirstActivity.class);
            HomeActivity.this.startActivity(myIntent);
        }

        //reset app data
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                editor.clear();
                editor.commit();

                Toast.makeText(HomeActivity.this, "App data reset", Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(HomeActivity.this, FirstActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });

        //do when button stats pressed
        buttonStats = (Button) findViewById(R.id.buttonStats);
        buttonStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomeActivity.this, StatsActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });


        //do when button machines pressed
        buttonMachines = (Button) findViewById(R.id.buttonMachines);
        buttonMachines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomeActivity.this, MachinesActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });

        //do when button bmi pressed
        buttonBMI = (Button) findViewById(R.id.buttonBMI);
        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomeActivity.this, BMIActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });

        //do when button edit workout pressed
        buttonEditWorkout = (Button) findViewById(R.id.buttonEditWorkout);
        buttonEditWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomeActivity.this, EditWorkoutActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });

        //do when button workout pressed
        buttonWorkout = (Button) findViewById(R.id.buttonWorkout);
        buttonWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomeActivity.this, WorkoutActivity.class);
                HomeActivity.this.startActivity(myIntent);
            }
        });
    }
}

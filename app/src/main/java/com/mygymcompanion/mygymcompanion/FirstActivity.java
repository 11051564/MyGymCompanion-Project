package com.mygymcompanion.mygymcompanion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;


public class FirstActivity extends ActionBarActivity {
    private RadioGroup radioGroup;
    private Button buttonSubmit;
    String gender = "male", workoutPref = "fitness";
    int workoutDiff = 1;

    int age, difficultyRate = 0, iBase10 = 10;

    int bicepCurlkg = 6, abCrunchkg = 3, calfPresskg = 15, legPresskg = 15,
            benchPresskg = 20, shoulderPresskg = 6;

    int bicepCurlReps = 10, abCrunchReps = 8, calfPressReps = 6, legPressReps = 15,
            benchPressReps = 8, shoulderPressReps = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //do when button stats pressed
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                beginAlgorithm();
            }
        });
    }

    private void beginAlgorithm() {
        //save settings to internal storage then launch WorkoutActivity
        Context context = getApplicationContext();

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();

        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
        EditText editTextHeight = (EditText) findViewById(R.id.editTextHeight);

        editor.putBoolean("FirstLaunch", false);
        editor.putString("Day", "one");
        editor.putString("daysWorkedOut", "0");
        editor.putString("FirstName", editTextName.getText().toString());
        editor.putString("Age", editTextAge.getText().toString());
        editor.putString("Weight", editTextWeight.getText().toString());
        editor.putString("Height", editTextHeight.getText().toString());
        //editor.putString("Difficulty", workoutDiff);
        editor.putString("Preference", workoutPref);
        editor.putString("Gender", gender);
        editor.apply();

        createWorkout();

        Toast toastConfirm = Toast.makeText(context, "Created Workout Plan!", Toast.LENGTH_LONG);
        toastConfirm.show();

        Intent myIntent = new Intent(FirstActivity.this, HomeActivity.class);
        FirstActivity.this.startActivity(myIntent);
    }

    public void createWorkout() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        Context context = getApplicationContext();

        EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
        String s = editTextAge.getText().toString();
        age = Integer.valueOf(s);

        if (age < 16) {
            difficultyRate += 1;
            setWeightValues();
            setRepValues();

            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "15," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "10," + difficultyRate);
                    editor.putString("Plank@", "30 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "20 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "15" + difficultyRate);
                    editor.putString("Push Ups@", "15," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    //editor.putString("Plank", "30 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    //editor.putString("Treadmill", "20 minutes");
                    //editor.putString("Stairmaster", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "15," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "10," + difficultyRate);
                    editor.putString("Plank@", "30 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "20 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age < 20) {
            difficultyRate += 2;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "20," + difficultyRate);
                    editor.putString("Push Ups@", "15," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "7 minutes");
                    editor.putString("Treadmill@", "22 minutes");
                    editor.putString("Stairmaster@", "7 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",1");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",1");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",1");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "20," + difficultyRate);
                    editor.putString("Push Ups@", "15," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    //editor.putString("Plank", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "7 minutes");
                    //editor.putString("Treadmill", "22 minutes");
                    //editor.putString("Stairmaster", "7 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "20," + difficultyRate);
                    editor.putString("Push Ups@", "15," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "7 minutes");
                    editor.putString("Treadmill@", "22 minutes");
                    editor.putString("Stairmaster@", "7 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age < 25) {
            difficultyRate += 3;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "25," + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    editor.putString("Plank@", "50 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "8 minutes");
                    editor.putString("Treadmill@", "24 minutes");
                    editor.putString("Stairmaster@", "8 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",1");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",1");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",1");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;

                case "strength":
                    //editor.putString("Star Jumps", "25" + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    //editor.putString("Plank", "50 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "8 minutes");
                    //editor.putString("Treadmill", "24 minutes");
                    //editor.putString("Stairmaster", "8 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "25," + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    editor.putString("Plank@", "50 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "8 minutes");
                    editor.putString("Treadmill@", "24 minutes");
                    editor.putString("Stairmaster@", "8 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age < 30) {
            difficultyRate += 4;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "35," + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    editor.putString("Plank@", "60 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "10 minutes");
                    editor.putString("Treadmill@", "24 minutes");
                    editor.putString("Stairmaster@", "8 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;

                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "35" + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    //editor.putString("Plank", "60 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "10 minutes");
                    //editor.putString("Treadmill", "24 minutes");
                    //editor.putString("Stairmaster", "8 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "35," + difficultyRate);
                    editor.putString("Push Ups@", "20," + difficultyRate);
                    editor.putString("Sit Ups@", "20," + difficultyRate);
                    editor.putString("Plank@", "60 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "10 minutes");
                    editor.putString("Treadmill@", "24 minutes");
                    editor.putString("Stairmaster@", "8 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age < 50) {
            difficultyRate += 3;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "25," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "10 minutes");
                    editor.putString("Stairmaster@", "6 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",1");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",1");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",1");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;

                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "25" + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    //editor.putString("Plank", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    //editor.putString("Treadmill", "10 minutes");
                    //editor.putString("Stairmaster", "6 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "25," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "40 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "10 minutes");
                    editor.putString("Stairmaster@", "6 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age > 49) {
            difficultyRate += 2;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "10," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "5 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",1");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",1");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",1");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;

                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "10" + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    //editor.putString("Plank", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    //editor.putString("Treadmill", "5 minutes");
                    //editor.putString("Stairmaster", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "10," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plan@k", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "5 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        } else if (age > 49) {
            difficultyRate += 0;
            setWeightValues();
            setRepValues();
            switch (workoutPref) {
                case "fitness":
                    //mat exercises
                    editor.putString("Star Jumps@", "10," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "5 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    //editor.putString("Bicep Curl", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",1");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",1");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",1");
                    //editor.putString("Bench Press", benchPresskg + "," + benchPressReps + ",2");
                    //editor.putString("Shoulder Press", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "strength":
                    //mat exercises
                    //editor.putString("Star Jumps", "10" + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    //editor.putString("Plank", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    //editor.putString("Treadmill", "5 minutes");
                    //editor.putString("Stairmaster", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
                case "both":
                    //mat exercises
                    editor.putString("Star Jumps@", "10," + difficultyRate);
                    editor.putString("Push Ups@", "10," + difficultyRate);
                    editor.putString("Sit Ups@", "15," + difficultyRate);
                    editor.putString("Plank@", "20 seconds");
                    //exercise machines
                    editor.putString("Rowing@", "5 minutes");
                    editor.putString("Treadmill@", "5 minutes");
                    editor.putString("Stairmaster@", "5 minutes");
                    //strength machines
                    editor.putString("Bicep Curl@", bicepCurlkg + "," + bicepCurlReps + ",2");
                    editor.putString("Ab Crunch@", abCrunchkg + "," + abCrunchReps + ",2");
                    editor.putString("Calf Press@", calfPresskg + "," + calfPressReps + ",2");
                    editor.putString("Leg Press@", legPresskg + "," + legPressReps + ",2");
                    editor.putString("Bench Press@", benchPresskg + "," + benchPressReps + ",2");
                    editor.putString("Shoulder Press@", shoulderPresskg + "," + shoulderPressReps + ",2");
                    break;
            }
        }

        editor.commit();
    }

    public void setWeightValues() {
        if (gender == "male") {
            difficultyRate += 5;
            if (workoutPref == "strength" || workoutPref =="both") {
                workoutDiff = 10;
            }

            bicepCurlkg += ((difficultyRate*2) + workoutDiff);
            abCrunchkg += ((difficultyRate*2.2) + workoutDiff);
            calfPresskg += ((difficultyRate*2.7) + workoutDiff);
            legPresskg += ((difficultyRate*4) + workoutDiff);
            benchPresskg += ((difficultyRate*4) + workoutDiff);
            shoulderPresskg += ((difficultyRate*2) + workoutDiff);

        } else {
            difficultyRate += 2;
            if (workoutPref == "strength" || workoutPref =="both") {
                workoutDiff = 3;
            }

            bicepCurlkg += ((difficultyRate*0.8) + workoutDiff);
            abCrunchkg += ((difficultyRate*0.7) + workoutDiff);
            calfPresskg += ((difficultyRate*1.2) + workoutDiff);
            legPresskg += ((difficultyRate*2) + workoutDiff);
            benchPresskg += ((difficultyRate*2) + workoutDiff);
            shoulderPresskg += ((difficultyRate*0.7) + workoutDiff);

        }


    }
    public void setRepValues() {
        if (age < 19) { } else if (age < 35) {
            if (workoutDiff == 1) {
                bicepCurlReps += 2;
                abCrunchReps += 2;
                calfPressReps += 2;
                legPressReps += 2;
                benchPressReps += 2;
                shoulderPressReps += 1;
            } else if (workoutDiff == 2) {
                bicepCurlReps += 2;
                abCrunchReps += 3;
                calfPressReps += 1;
                legPressReps += 4;
                benchPressReps += 5;
                shoulderPressReps += 3;
            } else if (workoutDiff == 3) {
                bicepCurlReps += 4;
                abCrunchReps += 6;
                calfPressReps += 7;
                legPressReps += 6;
                benchPressReps += 7;
                shoulderPressReps += 7;
            }
        } else if (age < 50) {
            if (workoutDiff == 1) {
                bicepCurlReps = 1;
                abCrunchReps = 1;
                calfPressReps = 1;
                legPressReps = 1;
                benchPressReps = 1;
                shoulderPressReps = 1;
            } else if (workoutDiff == 2) {
                bicepCurlReps = 2;
                abCrunchReps = 2;
                calfPressReps = 2;
                legPressReps = 2;
                benchPressReps = 2;
                shoulderPressReps = 2;
            } else if (workoutDiff == 3) {
                bicepCurlReps += 3;
                abCrunchReps += 3;
                calfPressReps += 3;
                legPressReps += 3;
                benchPressReps += 3;
                shoulderPressReps += 3;
            }
        } else {

        }

    }

    public void radioButtonOnClick(View view) {

        Context context = getApplicationContext();
        CharSequence mText = "Male selected";
        CharSequence fText = "Female selected";

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.Male:
                if (checked) {
                    gender = "male";
                    break;
                }

            case R.id.Female:
                if (checked) {
                    gender = "female";
                    break;
                }

            case R.id.Fitness:
                if (checked) {
                    workoutPref = "fitness";
                    break;
                }

            case R.id.Strength:
                if (checked) {
                    workoutPref = "strength";
                    break;
                }
            case R.id.Both:
                if (checked) {
                    workoutPref = "both";
                    break;
                }
            case R.id.Easy:
                if (checked) {
                    workoutDiff = 1;
                    break;
                }
            case R.id.Medium:
                if (checked) {
                    workoutDiff = 3;
                    break;
                }
            case R.id.Hard:
                if (checked) {
                    workoutDiff = 5;
                    break;
                }
        }

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}

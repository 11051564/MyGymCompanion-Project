package com.mygymcompanion.mygymcompanion;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by Jordan on 21/03/2015.
 */
public class WorkoutActivity extends ActionBarActivity {

    int workouts = 0;
    int workoutCount = 0;
    int starjumps, starjumpsreps;
    String typeIncrease = "";
    Boolean starjump = false, pushup = false, situp = false, plank = false, rowing = false,
            treadmill = false, stairmaster = false, bicepcurl = false, abcrunch = false,
            calfpress = false, legpress = false, benchpress = false, shoulderpress = false;
    private Button btnCompleteWorkout, btnStarchange, btnStarchangeminus, starrepplus, starrepminus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        checkboxListeners();
        displayWorkout();

        btnCompleteWorkout = (Button) findViewById(R.id.btnCompleteWorkout);
        btnStarchange = (Button) findViewById(R.id.starchange);
        btnStarchangeminus = (Button) findViewById(R.id.staramountminus);
        starrepplus = (Button) findViewById(R.id.starrepplus);
        starrepminus = (Button) findViewById(R.id.starrepminus);
        Button pushupamountplus = (Button) findViewById(R.id.pushupamountplus);
        Button pushupamountminus = (Button) findViewById(R.id.pushupamountminus);
        Button pushuprepplus = (Button) findViewById(R.id.pushuprepplus);
        Button pushuprepminus = (Button) findViewById(R.id.pushuprepminus);
        Button situpamountplus = (Button) findViewById(R.id.situpamountplus);
        Button situpamountminus = (Button) findViewById(R.id.situpamountminus);
        Button situprepplus = (Button) findViewById(R.id.situprepplus);
        Button situprepminus = (Button) findViewById(R.id.situprepminus);
        Button plankplus = (Button) findViewById(R.id.plankplus);
        Button plankminus = (Button) findViewById(R.id.plankminus);
        Button rowingplus = (Button) findViewById(R.id.rowingplus);
        Button rowingminus = (Button) findViewById(R.id.rowingminus);
        Button treadmillplus = (Button) findViewById(R.id.treadmillplus);
        Button treadmillminus = (Button) findViewById(R.id.treadmillminus);
        Button stairmasterminus = (Button) findViewById(R.id.stairmasterminus);
        Button stairmasterplus = (Button) findViewById(R.id.stairmasterplus);

        Button bicepweightplus = (Button) findViewById(R.id.bicepweighplus);
        Button bicepweightminus = (Button) findViewById(R.id.bicepweightminus);
        Button biceprepplus = (Button) findViewById(R.id.biceprepplus);
        Button biceprepminus = (Button) findViewById(R.id.biceprepminus);
        Button bicepsetplus = (Button) findViewById(R.id.bicepsetsplus);
        Button bicepsetminus = (Button) findViewById(R.id.bicepsetsminus);

        Button calfweightplus = (Button) findViewById(R.id.calfweightplus);
        Button calfweightminus = (Button) findViewById(R.id.calfweightminus);
        Button calfrepplus = (Button) findViewById(R.id.calfrepplus);
        Button calfrepminus = (Button) findViewById(R.id.calfrepminus);
        Button calfsetplus = (Button) findViewById(R.id.calfsetplus);
        Button calfsetminus = (Button) findViewById(R.id.calfsetminus);

        Button abcrunchweightplus = (Button) findViewById(R.id.abcrunchweighplus);
        Button abcrunchweightminus = (Button) findViewById(R.id.abcrunchweightminus);
        Button abcrunchrepplus = (Button) findViewById(R.id.abcrunchplus);
        Button abcrunchrepminus = (Button) findViewById(R.id.abcrunchminus);
        Button abcrunchsetplus = (Button) findViewById(R.id.abcrunchsetsplus);
        Button abcrunchsetminus = (Button) findViewById(R.id.abcrunchsetminus);

        Button legweightplus = (Button) findViewById(R.id.legweightplus);
        Button legweightminus = (Button) findViewById(R.id.legweightminus);
        Button legrepplus = (Button) findViewById(R.id.legrepplus);
        Button legrepminus = (Button) findViewById(R.id.legrepminus);
        Button legsetplus = (Button) findViewById(R.id.legsetplus);
        Button legsetminus = (Button) findViewById(R.id.legsetminus);

        Button benchweightplus = (Button) findViewById(R.id.benchweightplus);
        Button benchweightminus = (Button) findViewById(R.id.benchweightminus);
        Button benchrepplus = (Button) findViewById(R.id.benchrepplus);
        Button benchrepminus = (Button) findViewById(R.id.benchrepminus);
        Button benchsetplus = (Button) findViewById(R.id.benchsetplus);
        Button benchsetminus = (Button) findViewById(R.id.benchsetminus);

        Button shoulderweightplus = (Button) findViewById(R.id.shoulderweightplus);
        Button shoulderweightminus = (Button) findViewById(R.id.shoulderweightminus);
        Button shoulderrepplus = (Button) findViewById(R.id.shoulderrepsplus);
        Button shoulderrepminus = (Button) findViewById(R.id.shoulderrepsminus);
        Button shouldersetplus = (Button) findViewById(R.id.shouldersetsplus);
        Button shouldersetminus = (Button) findViewById(R.id.shouldersetsminus);

        btnStarchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Star Jumps";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        btnStarchangeminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Star Jumps";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        starrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Star Jumps";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        starrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Star Jumps";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        /////////
        pushupamountplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Push Ups";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        pushupamountminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Push Ups";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        pushuprepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Push Ups";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        pushuprepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Push Ups";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        situpamountplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Sit Ups";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        situpamountminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Sit Ups";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        situprepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Sit Ups";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        situprepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Sit Ups";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        plankplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Plank";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        plankminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Plank";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        rowingplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Rowing";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        rowingminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Rowing";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        treadmillplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Treadmill";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        treadmillminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Treadmill";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        stairmasterplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Stairmaster";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        stairmasterminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Stairmaster";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        bicepweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        bicepweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        biceprepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        biceprepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        bicepsetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        bicepsetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bicep Curl";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        calfweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        calfweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        calfrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        calfrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        calfsetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        calfsetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Calf Press";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
       ////////////////
        abcrunchweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        abcrunchweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        abcrunchrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        abcrunchrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        abcrunchsetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        abcrunchsetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Ab Crunch Press";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        legweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        legweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        legrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        legrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        legsetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        legsetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Leg Press";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        benchweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        benchweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        benchrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        benchrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        benchsetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        benchsetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Bench Press";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////
        shoulderweightplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 1;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        shoulderweightminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 1;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        shoulderrepplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 2;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        shoulderrepminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 2;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        shouldersetplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 3;
                int valueID = 1;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        shouldersetminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                typeIncrease = "Shoulder Press";
                int valueCount = 3;
                int valueID = 2;
                increaseDecreaseValue(valueCount, valueID);
            }
        });
        ////////////////

        btnCompleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                completeWorkout();
            }
        });

    }

    public void boo(View v) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String s = entry.toString();
            Toast.makeText(WorkoutActivity.this, s, Toast.LENGTH_LONG).show();
        }
    }

    public void increaseDecreaseValue(int valueCount, int valueID) {
        //increaseDecrease3Values -->
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();


        //begin searching sharedpreferences
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {

            String s = entry.toString();
            //Toast.makeText(WorkoutActivity.this, s, Toast.LENGTH_LONG).show();
            if (s.contains(typeIncrease)) {
                int mValue = 0, mValue2 = 0, mValue3 = 0;

                if (s.contains("seconds")) {

                    String[] workoutEntry = s.split("@=");
                    String s2 = workoutEntry[1];
                    String[] s3 = s2.split(" ");
                    String amounttmp = s3[0];
                    mValue = Integer.parseInt(amounttmp);

                } else if (s.contains("minutes")) {

                    String[] workoutEntry = s.split("@=");
                    String s2 = workoutEntry[1];
                    String[] s3 = s2.split(" ");
                    String amounttmp = s3[0];
                    mValue = Integer.parseInt(amounttmp);

                } else {

                    String[] workoutEntry = s.split("@=");
                    String s2 = workoutEntry[1];
                    String[] s3 = s2.split(",");

                    String amounttmp = s3[0];
                    String repstmp = s3[1];
                    String setstmp = "";

                    mValue = Integer.parseInt(amounttmp);
                    mValue2 = Integer.parseInt(repstmp);

                    if (valueCount == 3) { setstmp = s3[2]; }
                    if (valueCount == 3) { mValue3 = Integer.parseInt(setstmp); }
                }

                switch(valueCount) {
                    case 1:
                        switch(valueID) {
                            case 1:
                                mValue = mValue + 1;
                                break;
                            case 2:
                                mValue = mValue - 1;
                                break;
                        }
                        break;
                    case 2:
                        switch(valueID) {
                            case 1:
                                mValue2 = mValue2 + 1;
                                break;
                            case 2:
                                mValue2 = mValue2 - 1;
                                break;
                        }
                    case 3:
                        switch(valueID) {
                            case 1:
                                mValue3 = mValue3 + 1;
                                break;
                            case 2:
                                mValue3 = mValue3 - 1;
                                break;
                        }
                }

                String setValue, setValue2, setValue3;

                switch(typeIncrease) {
                    case "Star Jumps":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.txtStarJumps);
                            txt.setText(setValue);
                            editor.putString("Star Jumps@", setValue + "," + setValue2);
                          }
                          else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.txtStarJumpsReps);
                            txt.setText(setValue2);
                            editor.putString("Star Jumps@", setValue + "," + setValue2);
                        }
                        break;
                    case "Push Ups":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountPushUps);
                            txt.setText(setValue);
                            editor.putString("Push Ups@", setValue + "," + setValue2);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.amountPushUpsReps);
                            txt.setText(setValue2);
                            editor.putString("Push Ups@", setValue + "," + setValue2);
                        }
                        break;
                    case "Sit Ups":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        //Toast.makeText(WorkoutActivity.this, setValue + " " + setValue2, Toast.LENGTH_LONG).show();
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountSitUps);
                            txt.setText(setValue);
                            editor.putString("Sit Ups@", setValue + "," + setValue2);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.amountSitUpsReps);
                            txt.setText(setValue2);
                            editor.putString("Sit Ups@", setValue + "," + setValue2);
                        }
                        break;
                    case "Plank":
                        setValue = Integer.toString(mValue);
                        TextView txtp = (TextView) findViewById(R.id.amountPlank);
                        txtp.setText(setValue + " seconds");
                        editor.putString("Plank@", setValue + " seconds");
                        break;
                    case "Rowing":
                        setValue = Integer.toString(mValue);
                        TextView txtr = (TextView) findViewById(R.id.amountRowing);
                        txtr.setText(setValue + " minutes");
                        editor.putString("Rowing@", setValue + " minutes");
                        break;
                    case "Treadmill":
                        setValue = Integer.toString(mValue);
                        TextView txtt = (TextView) findViewById(R.id.amountTreadmill);
                        txtt.setText(setValue + " minutes");
                        editor.putString("Treadmill@", setValue + " minutes");
                        break;
                    case "Stairmaster":
                        setValue = Integer.toString(mValue);
                        TextView txts = (TextView) findViewById(R.id.amountStairmaster);
                        txts.setText(setValue + " minutes");
                        editor.putString("Stairmaster@", setValue + " minutes");
                        break;
                    case "Bicep Curl":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountBicepCurl);
                            txt.setText(setValue);
                            editor.putString("Bicep Curl@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.BicepCurlReps);
                            txt.setText(setValue2);
                            editor.putString("Bicep Curl@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.BicepCurlSets);
                            txt.setText(setValue3);
                            editor.putString("Bicep Curl@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                    case "Ab Crunch":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountAbCrunch);
                            txt.setText(setValue);
                            editor.putString("Ab Crunch@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.AbCrunchReps);
                            txt.setText(setValue2);
                            editor.putString("Ab Crunch@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.AbCrunchSets);
                            txt.setText(setValue3);
                            editor.putString("Ab Crunch@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                    case "Calf Press":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountCalfPress);
                            txt.setText(setValue);
                            editor.putString("Calf Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.CalfPresReps);
                            txt.setText(setValue2);
                            editor.putString("Calf Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.CalfPressSets);
                            txt.setText(setValue3);
                            editor.putString("Calf Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                    case "Leg Press":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountLegPress);
                            txt.setText(setValue);
                            editor.putString("Leg Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.amountLegPressRep);
                            txt.setText(setValue2);
                            editor.putString("Leg Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.legPressSets);
                            txt.setText(setValue3);
                            editor.putString("Leg Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                    case "Bench Press":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.amountBenchPress);
                            txt.setText(setValue);
                            editor.putString("Bench Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.BenchPressRep);
                            txt.setText(setValue2);
                            editor.putString("Bench Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.BenchPressSets);
                            txt.setText(setValue3);
                            editor.putString("Bench Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                    case "Shoulder Press":
                        setValue = Integer.toString(mValue);
                        setValue2 = Integer.toString(mValue2);
                        setValue3 = Integer.toString(mValue3);
                        if (valueCount == 1) {
                            TextView txt = (TextView) findViewById(R.id.ShoulderPress);
                            txt.setText(setValue);
                            editor.putString("Shoulder Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 2) {
                            TextView txt = (TextView) findViewById(R.id.ShoulderPressReps);
                            txt.setText(setValue2);
                            editor.putString("Shoulder Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        else if (valueCount == 3) {
                            TextView txt = (TextView) findViewById(R.id.ShoulderPressSets);
                            txt.setText(setValue3);
                            editor.putString("Shoulder Press@", setValue + "," + setValue2 + "," + setValue3);
                        }
                        break;
                }
                editor.commit();
            }
        }
    }

    public void completeWorkout() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = settings.edit();

        String daysWorkedOut = settings.getString("daysWorkedOut","0");
        int daysWorked = Integer.parseInt(daysWorkedOut);
        daysWorked = daysWorked + 1;
        daysWorkedOut = Integer.toString(daysWorked);
        editor.putString("daysWorkedOut", daysWorkedOut);

        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String workoutData = "Workout # " + daysWorkedOut + " -- " + date + "\nCompleted:\n";

        int passcount = 0;
        if (starjump == true) { workoutData = workoutData + " - Star Jumps\n"; passcount = passcount + 1; }
        if (pushup == true) { workoutData = workoutData + " - Push Ups\n"; passcount = passcount + 1; }
        if (situp == true) { workoutData = workoutData + " - Sit\n"; passcount = passcount + 1; }
        if (plank == true) { workoutData = workoutData + " - Plank\n"; passcount = passcount + 1; }
        if (rowing == true) { workoutData = workoutData + " - Rowing\n"; passcount = passcount + 1; }
        if (treadmill == true) { workoutData = workoutData + " - Treadmill\n"; passcount = passcount + 1;}
        if (stairmaster == true) { workoutData = workoutData + " - Stairmaster\n"; passcount = passcount + 1;}
        if (bicepcurl == true) { workoutData = workoutData + " - Bicep Curl\n"; passcount = passcount + 1; }
        if (abcrunch == true) { workoutData = workoutData + " - Ab Crunch\n"; passcount = passcount + 1; }
        if (calfpress == true) { workoutData = workoutData + " - Calf Press\n"; passcount = passcount + 1; }
        if (legpress == true) { workoutData = workoutData + " - Leg Press\n"; passcount = passcount + 1; }
        if (shoulderpress == true) { workoutData = workoutData + " - Shoulder Press\n"; passcount = passcount + 1; }
        if (benchpress == true) { workoutData = workoutData + " - Bench Press\n"; passcount = passcount + 1; }

        if (passcount == 0) { workoutData = workoutData + " - none!\n"; }

        String strDay = "Day " + daysWorkedOut + ">";
        editor.putString(strDay, workoutData);
        editor.commit();

        TextView txt5 = (TextView) findViewById(R.id.textView5);
        TextView txt6 = (TextView) findViewById(R.id.textView6);
        txt5.setVisibility(View.VISIBLE);
        txt6.setVisibility(View.VISIBLE);
        txt5.setText(workoutData);

        //Toast.makeText(WorkoutActivity.this, strDay + daysWorkedOut, Toast.LENGTH_LONG).show();
    }

    public void workoutplus() {
        workoutCount = workoutCount + 1;
        Toast.makeText(WorkoutActivity.this, workoutCount + "/" + workouts + " Complete!", Toast.LENGTH_SHORT).show();
    }

    public void workoutminus() {
        workoutCount = workoutCount - 1;
        Toast.makeText(WorkoutActivity.this, workoutCount + "/" + workouts + " Complete!", Toast.LENGTH_SHORT).show();
    }

    public void checkboxListeners() {

        CheckBox checkBoxstarjumps = (CheckBox) findViewById(R.id.checkBoxStarJumps);
        CheckBox checkBoxpushup = (CheckBox) findViewById(R.id.checkBoxPushUp);
        CheckBox checkBoxsitup = (CheckBox) findViewById(R.id.checkBoxSitUp);
        CheckBox checkBoxplank = (CheckBox) findViewById(R.id.checkBoxPlank);
        CheckBox checkBoxrowing = (CheckBox) findViewById(R.id.checkBoxRowing);
        CheckBox checkBoxtreadmill = (CheckBox) findViewById(R.id.checkBoxTreadmill);
        CheckBox checkBoxstairmaster = (CheckBox) findViewById(R.id.checkBoxStairmaster);
        CheckBox checkBoxbicepcurl = (CheckBox) findViewById(R.id.checkBoxBicepCurl);
        CheckBox checkBoxabcrunch = (CheckBox) findViewById(R.id.checkBoxAbCrunch);
        CheckBox checkBoxcalfpress = (CheckBox) findViewById(R.id.checkBoxCalfPress);
        CheckBox checkBoxlegpress = (CheckBox) findViewById(R.id.checkBoxLegPress);
        CheckBox checkBoxbenchpress = (CheckBox) findViewById(R.id.checkBoxBenchPress);
        CheckBox checkBoxshoulderpress = (CheckBox) findViewById(R.id.checkBoxShoulderPress);

        checkBoxstarjumps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheckStarJumps =(LinearLayout)findViewById(R.id.layoutCheckStarJumps);
                if (isChecked) {
                    layoutCheckStarJumps.setBackgroundColor(Color.parseColor("#ff4aff24"));
                    starjump = true;
                    workoutplus();
                } else if (!isChecked) {
                    layoutCheckStarJumps.setBackgroundColor(Color.parseColor("#ffff6d64"));
                    starjump = false;
                    workoutminus();
                }
            }
        });
        checkBoxstarjumps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheckStarJumps =(LinearLayout)findViewById(R.id.layoutCheckStarJumps);
                if (isChecked) {
                    layoutCheckStarJumps.setBackgroundColor(Color.parseColor("#ff4aff24"));
                    starjump = true;
                    workoutplus();
                } else if (!isChecked) {
                    layoutCheckStarJumps.setBackgroundColor(Color.parseColor("#ffff6d64"));
                    starjump = false;
                    workoutminus();
                }
            }
        });
        checkBoxpushup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheckPushUps =(LinearLayout)findViewById(R.id.layoutCheckPushUps);
                if (isChecked) {
                    workoutplus();
                    pushup = true;
                    layoutCheckPushUps.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    pushup = false;
                    layoutCheckPushUps.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxsitup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheckSitUps =(LinearLayout)findViewById(R.id.layoutCheckSitUps);
                if (isChecked) {
                    workoutplus();
                    situp = true;
                    layoutCheckSitUps.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    situp = false;
                    layoutCheckSitUps.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxplank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck2 =(LinearLayout)findViewById(R.id.layoutCheckPlank);
                if (isChecked) {
                    workoutplus();
                    plank = true;
                    layoutCheck2.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    plank = false;
                    layoutCheck2.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxrowing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck3 =(LinearLayout)findViewById(R.id.layoutCheckRowing);
                if (isChecked) {
                    workoutplus();
                    rowing = true;
                    layoutCheck3.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    rowing = false;
                    layoutCheck3.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxtreadmill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck4 =(LinearLayout)findViewById(R.id.layoutCheckTreadmill);
                if (isChecked) {
                    workoutplus();
                    treadmill = true;
                    layoutCheck4.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    treadmill = false;
                    layoutCheck4.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxstairmaster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck5 =(LinearLayout)findViewById(R.id.layoutCheckStairmaster);
                if (isChecked) {
                    workoutplus();
                    stairmaster = true;
                    layoutCheck5.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    stairmaster = false;
                    layoutCheck5.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxbicepcurl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck6 =(LinearLayout)findViewById(R.id.layoutCheckBicepCurl);
                if (isChecked) {
                    workoutplus();
                    bicepcurl = true;
                    layoutCheck6.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    bicepcurl = false;
                    layoutCheck6.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxabcrunch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck7 =(LinearLayout)findViewById(R.id.layoutCheckAbCrunch);
                if (isChecked) {
                    workoutplus();
                    abcrunch = true;
                    layoutCheck7.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    abcrunch = false;
                    layoutCheck7.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxcalfpress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck8 =(LinearLayout)findViewById(R.id.layoutCheckCalfPress);
                if (isChecked) {
                    workoutplus();
                    calfpress = true;
                    layoutCheck8.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    calfpress = false;
                    layoutCheck8.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxlegpress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck9 =(LinearLayout)findViewById(R.id.layoutCheckLegPress);
                if (isChecked) {
                    workoutplus();
                    legpress = true;
                    layoutCheck9.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    legpress = false;
                    layoutCheck9.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxbenchpress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck10 =(LinearLayout)findViewById(R.id.layoutCheckBenchPress);
                if (isChecked) {
                    workoutplus();
                    benchpress = true;
                    layoutCheck10.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    benchpress = false;
                    layoutCheck10.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
        checkBoxshoulderpress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                LinearLayout layoutCheck11 =(LinearLayout)findViewById(R.id.layoutCheckShoulderPress);
                if (isChecked) {
                    workoutplus();
                    shoulderpress = true;
                    layoutCheck11.setBackgroundColor(Color.parseColor("#ff4aff24"));
                } else if (!isChecked) {
                    workoutminus();
                    shoulderpress = false;
                    layoutCheck11.setBackgroundColor(Color.parseColor("#ffff6d64"));
                }
            }
        });
    }

    public void displayWorkout() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String workoutPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Preference", "");

        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
             String s = entry.toString();
             if (s.contains("@")) {
                 String[] workoutEntry = s.split("@=");
                 //String s2 = workoutEntry[1];
                 switch (workoutEntry[0]) {
                    case "Star Jumps":
                        workouts += 1;
                        displayStarJumps(workoutEntry[1]);
                        break;
                    case "Push Ups":
                        workouts += 1;
                        displayPushUps(workoutEntry[1]);
                        break;
                    case "Sit Ups":
                        workouts += 1;
                        displaySitUps(workoutEntry[1]);
                        break;
                    case "Plank":
                        workouts += 1;
                        displayPlank(workoutEntry[1]);
                        break;
                    case "Rowing":
                        workouts += 1;
                        displayRowing(workoutEntry[1]);
                        break;
                    case "Treadmill":
                        workouts += 1;
                        displayTreadmill(workoutEntry[1]);
                        break;
                    case "Stairmaster":
                        workouts += 1;
                        displayStairmaster(workoutEntry[1]);
                        break;
                    case "Bicep Curl":
                        workouts += 1;
                        displayBicepCurl(workoutEntry[1]);
                        break;
                    case "Ab Crunch":
                        workouts += 1;
                        displayAbCrunch(workoutEntry[1]);
                        break;
                    case "Calf Press":
                        workouts += 1;
                        displayCalfPress(workoutEntry[1]);
                        break;
                    case "Leg Press":
                        workouts += 1;
                        displayLegPress(workoutEntry[1]);
                        break;
                    case "Bench Press":
                        workouts += 1;
                        displayBenchPress(workoutEntry[1]);
                        break;
                    case "Shoulder Press":
                        workouts += 1;
                        displayShoulderPress(workoutEntry[1]);
                        break;
                }
            }
        }
    }

    private int returnAmount(String[] toSplit) {
        int a = Integer.parseInt(toSplit[0]);
        return a + 1;
    }

    private int returnReps(String[] toSplit) {
        int r = Integer.parseInt(toSplit[2]);
        return r + 1;
    }

    private int returnSets(String[] toSplit) {
        int s = Integer.parseInt(toSplit[3]);
        return s + 1;
    }

    public void displayStarJumps(String mValue) {
        LinearLayout starjumps_block =(LinearLayout)findViewById(R.id.starjumps_block);
        starjumps_block.setVisibility(View.VISIBLE);

        //Toast.makeText(WorkoutActivity.this, mValue, Toast.LENGTH_LONG).show();

        TextView txtA = (TextView) findViewById(R.id.txtStarJumps);
        TextView txtR = (TextView) findViewById(R.id.txtStarJumpsReps);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];

        txtA.setText(a);
        txtR.setText(r);
    }

    public void displayPushUps(String mValue) {
        LinearLayout pushups_block =(LinearLayout)findViewById(R.id.pushups_block);
        pushups_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountPushUps);
        TextView txtR = (TextView) findViewById(R.id.amountPushUpsReps);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];

        txtA.setText(a);
        txtR.setText(r);
    }

    public void displaySitUps(String mValue) {
        LinearLayout situps_block =(LinearLayout)findViewById(R.id.situps_block);
        situps_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountSitUps);
        TextView txtR = (TextView) findViewById(R.id.amountSitUpsReps);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];

        txtA.setText(a);
        txtR.setText(r);
    }

    public void displayPlank(String mValue) {
        LinearLayout plank_block =(LinearLayout)findViewById(R.id.plank_block);
        plank_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountPlank);
        String a = mValue;
        txtA.setText(a);
        String[] a2 = a.split(" ");

    }

    public void displayRowing(String mValue) {
        LinearLayout rowing_block =(LinearLayout)findViewById(R.id.rowing_block);
        rowing_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountRowing);
        String a = mValue;
        txtA.setText(a);
    }

    public void displayTreadmill(String mValue) {
        LinearLayout treadmill_block =(LinearLayout)findViewById(R.id.treadmill_block);
        treadmill_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.tread111);
        String a = mValue;
        txtA.setText(a);
    }

    public void displayStairmaster(String mValue) {
        LinearLayout stairmaster_block =(LinearLayout)findViewById(R.id.stairmaster_block);
        stairmaster_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountStairmaster);
        String a = mValue;
        txtA.setText(a);
    }

    public void displayBicepCurl(String mValue) {
        LinearLayout bicepcurl_block =(LinearLayout)findViewById(R.id.bicepcurl_block);
        bicepcurl_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountBicepCurl);
        TextView txtR = (TextView) findViewById(R.id.BicepCurlReps);
        TextView txtS = (TextView) findViewById(R.id.BicepCurlSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

    public void displayAbCrunch(String mValue) {
        LinearLayout abcrunch_block =(LinearLayout)findViewById(R.id.abcrunch_block);
        abcrunch_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountAbCrunch);
        TextView txtR = (TextView) findViewById(R.id.AbCrunchReps);
        TextView txtS = (TextView) findViewById(R.id.AbCrunchSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

    public void displayCalfPress(String mValue) {
        LinearLayout calfpress_block =(LinearLayout)findViewById(R.id.calfpress_block);
        calfpress_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountCalfPress);
        TextView txtR = (TextView) findViewById(R.id.CalfPresReps);
        TextView txtS = (TextView) findViewById(R.id.CalfPressSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

    public void displayLegPress(String mValue) {
        LinearLayout legpress_block =(LinearLayout)findViewById(R.id.legpress_block);
        legpress_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountLegPress);
        TextView txtR = (TextView) findViewById(R.id.amountLegPressRep);
        TextView txtS = (TextView) findViewById(R.id.legPressSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

    public void displayBenchPress(String mValue) {
        LinearLayout benchpress_block =(LinearLayout)findViewById(R.id.benchpress_block);
        benchpress_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.amountBenchPress);
        TextView txtR = (TextView) findViewById(R.id.BenchPressRep);
        TextView txtS = (TextView) findViewById(R.id.BenchPressSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

    public void displayShoulderPress(String mValue) {
        LinearLayout shoulderpress_block =(LinearLayout)findViewById(R.id.shoulderpress_block);
        shoulderpress_block.setVisibility(View.VISIBLE);

        TextView txtA = (TextView) findViewById(R.id.ShoulderPress);
        TextView txtR = (TextView) findViewById(R.id.ShoulderPressReps);
        TextView txtS = (TextView) findViewById(R.id.ShoulderPressSets);

        String[] split = mValue.split(",");
        String a = split[0];
        String r = split[1];
        String s = split[2];

        txtA.setText(a);
        txtR.setText(r);
        txtS.setText(s);
    }

}

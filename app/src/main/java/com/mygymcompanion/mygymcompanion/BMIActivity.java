package com.mygymcompanion.mygymcompanion;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Jordan on 22/03/2015.
 */
public class BMIActivity extends ActionBarActivity {

    Button buttonCalculate;
    int weight;
    double height, BMI;
    String strWeight, strHeight;
    TextView txtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        EditText txtHeight = (EditText) findViewById(R.id.txtHeight);
        EditText txtWeight = (EditText) findViewById(R.id.txtWeight);

        //This is where we output the result (create an empty textview in xml where you want it to show)


        strWeight = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Weight", "0");
        strHeight = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Height", "0");

        txtWeight.setText(strWeight);
        txtHeight.setText(strHeight);

        //do when button stats pressed
        buttonCalculate = (Button) findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onButtonClick();
            }
        });
    }

    public void onButtonClick() {
        EditText txtHeight = (EditText) findViewById(R.id.txtHeight);
        EditText txtWeight = (EditText) findViewById(R.id.txtWeight);
        TextView resultText = (TextView) findViewById(R.id.txtresult);
        //Basically gets the weight and height from text field and converts to float.
        float weight = Float.parseFloat(txtWeight.getText().toString());
        float height = Float.parseFloat(txtHeight.getText().toString());
        float BMI = calculate(weight, height);

        String bmiDefinition = bmiDescription(BMI);

        resultText.setText(BMI + bmiDefinition);

    }

    private float calculate(float weight, float height) {
        height = height / 100;
        //return (float) Math.round((weight / (height * height)) * 10) / 10;
        return (float) (weight / (height * height) * 10) / 10;
        //Return as float and rounds it to nearest integer
    }

    private String bmiDescription(float BMI) {
        if (BMI < 18.6) {
            return ", this classes you as Underweight";
        } else if (BMI < 25) {
            return ", this classes you as \'Normal\'";
        } else if (BMI < 30) {
            return ", this classes you as \'Overweight\'";
        } else {
            return ", this classes you as \'Obese\'";
        }
    }
}
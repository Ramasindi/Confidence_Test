package com.example.confidencetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // method for handling submit answers button
    String enteredName;
    int points = 0;
    int pointsFirst = 0;
    int pointsSecond = 0;
    int pointsThird = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitAnswers(View v) {
        EditText userName = findViewById(R.id.name_of_the_user);
        enteredName = userName.getText().toString();
        EditText userLikes = findViewById(R.id.what_user_likes_about_themselves);
        int whatUserLikes = userLikes.getText().toString().length();
        int pointsOfWhatUserLikes = 0;
        if (whatUserLikes == 0) {
            pointsOfWhatUserLikes = 0;
        } else if (whatUserLikes < 50) {
            pointsOfWhatUserLikes = 3;
        } else if (whatUserLikes < 80) {
            pointsOfWhatUserLikes = 5;
        } else if (whatUserLikes >= 80) {
            pointsOfWhatUserLikes = 8;
        }


        CheckBox threeM = findViewById(R.id.three_months_check);
        boolean threeMChecked = threeM.isChecked();
        CheckBox sixM = findViewById(R.id.six_months_check);
        boolean sixMChecked = sixM.isChecked();
        CheckBox twelveM = findViewById(R.id.twelve_months_check);
        boolean twelveMChecked = twelveM.isChecked();
        CheckBox nextYears = findViewById(R.id.few_years_check);
        boolean nextYearsChecked = nextYears.isChecked();
        futureGoals(threeMChecked, sixMChecked, twelveMChecked, nextYearsChecked);
        points = points + pointsFirst + pointsSecond + pointsThird + pointsOfWhatUserLikes;
        display(points);
        points = 0;
        pointsFirst = 0;
        pointsSecond = 0;
        pointsThird = 0;

    }
//method for displaying
    public void display(int score) {
        TextView confidenceScore = findViewById(R.id.confidence_results);
        if (score < 30) {
            confidenceScore.setText(enteredName + " is\n" + score + "% confident.\nYour confidence is bad.");
        } else if (score < 50) {
            confidenceScore.setText(enteredName + " is\n" + score + "% confident.\nYour confidence is good.");
        } else if (score < 70) {
            confidenceScore.setText(enteredName + " is\n" + score + "% confident.\nYour confidence is excellent.");
        } else if (score >= 70) {
            confidenceScore.setText(enteredName + " is\n" + score + "% confident.\nYour confidence is satisfactory.");
        }


    }
//method for checking if user is ok by the way they look
    public void firstRadioButtonClicked(View view) {
        int tempPoint = 0;
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_1a:
                if (checked)
                    tempPoint = 16;

                break;
            case R.id.radio_1b:
                if (checked)
                    tempPoint = 4;

                break;
            case R.id.radio_1c:
                if (checked)
                    tempPoint = 3;

                break;
            case R.id.radio_1d:
                if (checked)
                    tempPoint = 2;

                break;

        }
        points = tempPoint;
    }
// method for checking if user feel hopeless
    public void secondRadioButtonClicked(View view) {
        // Is the button now checked?
        int tempPoint = 0;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_2a:
                if (checked)
                    tempPoint = 2;
                break;
            case R.id.radio_2b:
                if (checked)
                    tempPoint = 10;
                break;

        }
        pointsFirst = tempPoint;
    }
//method for checking if the user feels little or not
    public void thirdRadioButtonClicked(View view) {
        // Is the button now checked?
        int tempPoint = 0;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_3a:
                if (checked)
                    tempPoint = 2;
                break;
            case R.id.radio_3b:
                if (checked)
                    tempPoint = 10;
                break;

        }
        pointsSecond = tempPoint;
    }
//method for checking if is easy for the user to tell someone when they are not happy
    public void fourthRadioButtonClicked(View view) {
        // Is the button now checked?
        int tempPoint = 0;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_4a:
                if (checked)
                    tempPoint = 10;
                break;
            case R.id.radio_4b:
                if (checked)
                    tempPoint = 2;
                break;

        }
        pointsThird = tempPoint;
    }

    //method for checking checked checkboxes
    public int futureGoals(boolean threeMonth, boolean sixMonth, boolean twelveMonth, boolean nextYears) {
        if (threeMonth == true) {
            points = points + 4;
        }
        if (sixMonth == true) {
            points = points + 4;
        }
        if (twelveMonth == true) {
            points = points + 4;
        }
        if (nextYears == true) {
            points = points + 4;
        }
        return points;
    }
}

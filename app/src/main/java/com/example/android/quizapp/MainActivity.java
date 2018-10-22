package com.example.android.quizapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    int result = 0;
    TextView scoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText enterEditText = (EditText) findViewById(R.id.enter_your_name_please);//get the id for the enter_ your_name edit text
        Button welcomeButton = (Button) findViewById(R.id.welcome_button);//get the id for the welcome button
        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (enterEditText.getText().toString() != null)//check whether the entered text is not null
                {
                    Toast.makeText(getApplicationContext(), "Welcome, " + enterEditText.getText().toString(), Toast.LENGTH_LONG).show();//display the text that you entered in edit text
                }
            }
        });//toast message
    }
    //Click event for the checkboxes:
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.ch_literature:
                if (checked)
                break;
            case R.id.ch_music:
                if (checked)
                break;
            case R.id.ch_movie:
                if (checked)
                break;
            case R.id.ch_auden:
                if (checked)
                break;
            case R.id.ch_williams:
                if (checked)
                break;
            case R.id.ch_szirtes:
                if (checked)
                    break;
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the radio button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yes_radio_button:
                if (checked)
                break;
            case R.id.no_radio_button:
                if (checked)
                break;}
    }
    //score and show the result:
    public void display(View view) {
        CheckBox literature = (CheckBox) findViewById(R.id.ch_literature);
        CheckBox music = (CheckBox) findViewById(R.id.ch_music);
        CheckBox movie = (CheckBox) findViewById(R.id.ch_movie);
        CheckBox auden = (CheckBox) findViewById(R.id.ch_auden);
        CheckBox williams = (CheckBox) findViewById(R.id.ch_williams);
        CheckBox szirtes = (CheckBox) findViewById(R.id.ch_szirtes);
        EditText first = (EditText) findViewById(R.id.first_answer);
        EditText third = (EditText) findViewById(R.id.third_answer);
        EditText sixth = (EditText) findViewById(R.id.sixth_answer);
        String firstAnswer = first.getText().toString();
        String thirdAnswer = third.getText().toString();
        String sixthAnswer = sixth.getText().toString();
        String q1Response = "Girl With A Pearl Earring";
        String q3Response = "Alfred Hitchcock";
        String q6Response = "Andy Warhol";
        RadioButton yes = (RadioButton) findViewById(R.id.yes_radio_button);
        RadioButton no = (RadioButton) findViewById(R.id.no_radio_button);
        //if a CheckBox with the right answer is clicked: 1 point is added
        if (literature.isChecked() && ! music.isChecked() && movie.isChecked()) {
            result = result + 2;
        }
        if (auden.isChecked() && williams.isChecked() && ! szirtes.isChecked()) {
            result = result + 2;
        }
        //if the right answer is typed in the EditText: 1 point is added for every right answer:
        if (firstAnswer.equalsIgnoreCase(q1Response)) {
            result = result + 1;
        }
        if (thirdAnswer.equalsIgnoreCase(q3Response)) {
            result = result + 1;
        }
        if (sixthAnswer.equalsIgnoreCase(q6Response)) {
            result = result + 1;
        }
        //if the no RadioButton is checked, 1 point is added
        if (yes.isChecked()) {
            result = result + 1;
        }
        if (no.isChecked()) {
            result = result;
        }
            displayscore(result);
        }
    //total score is displayed, also in toast form
    public void displayscore(int result) {
        scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(result));
        String toastMessage = "Your result is: " + String.valueOf(result) + " out of 8 points!";
        if (result == 8) {
            Toast.makeText(this, "Congratulation, your score is 8. You have won 2 tickets to Albertina Museum", Toast.LENGTH_SHORT).show();
        } else if (result < 8) {
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        } else ;
        //the button is no more enabled, after once clicked, only after we reset the app
        final Button sbt = findViewById(R.id.submit);
        sbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sbt.setEnabled(false);
            }
        });
    }
    //this method resets the app
    public void resetApp(View view) {
        Intent MainActivity = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        MainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(MainActivity);
    }
}
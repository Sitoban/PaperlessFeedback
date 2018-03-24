package com.example.a1018651.obhs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1018651.obhs.beans.FeedbackBean;

import java.util.ArrayList;
import java.util.Arrays;


public class FeedbackFormActivity extends AppCompatActivity {

//    ListView feedbackQuestionListView ;
    final static int numberOfQuestions = 5;
    View[] questionLayoutArray;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        LinearLayout questionListLayout = (LinearLayout)findViewById(R.id.questionListLayout);

        String[] feedBackQuestionStrings = new String[] { "Cleaning of Toilets(Including toilet floor, commode pan, wall panels, shelf, mirror, wash basin, Disinfection and provision of deodorant etc.",
                "Cleaning  of Passenger Compartment (Including cleaning of passenger aisle, Vestibule areas, Doorway area and Doorway wash basin, spraying of air freshner and cleaning of dustbin)",
                "Collection of garbage from the coach compartments and clearance of dustbins.",
                "Spraying of Mosquito/Cockroach/Fly Repellent and Providing Glue Board whenever required or on demand by passengers.",
                "Behaviour/Response of Janitors/Supervisor (Including hygiene & cleanliness of Janitor/Supervisor)"
        };

        questionLayoutArray = new View[numberOfQuestions];
        for(int i=0; i<numberOfQuestions; i++) {
            questionLayoutArray[i] = getLayoutInflater().inflate(R.layout.feed_back_question_item, null);
            TextView textField = (TextView)questionLayoutArray[i].findViewById(R.id.feedBackQuestion);
            textField.setText(feedBackQuestionStrings[i]);
            questionListLayout.addView(questionLayoutArray[i]);
        }

        Button feedbackSubmitButton = findViewById(R.id.feedBackSubmitButton);
        feedbackSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float feedbackPoint = 0;
                // Code here executes on main thread after user presses button
                for(int i=0; i<numberOfQuestions; i++) {
                    View questionItem = questionLayoutArray[i];

                    RadioGroup radioGroup = (RadioGroup)questionItem.findViewById(R.id.radioRatings);
                    int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(selectedRadioButtonId);
                    String buttonText = radioButton.getText().toString();

                    switch (buttonText) {
                        case "Excellent":
                            feedbackPoint += 1;
                            break;
                        case "Very Good":
                            feedbackPoint += .9;
                            break;
                        case "Good":
                            feedbackPoint += .8;
                            break;
                        case "Average":
                            feedbackPoint += .5;
                            break;
                        case "Poor":
                            feedbackPoint += .2;
                            break;
                    }
                }

                float psi = (feedbackPoint/5) * 100;
                Toast.makeText(FeedbackFormActivity.this,
                        "PSI: " + Float.toString(psi) + "%", Toast.LENGTH_LONG).show();
                FeedbackBean feedBack = FeedbackBean.getInstance();
                feedBack.addFeedBack(psi);

                finish();
            }
        });


//        setContentView(R.layout.feed_back_question_item);
        //populating the listview
        // Get ListView object from xml
//        feedbackQuestionListView = (ListView) findViewById(R.id.feedBackQuestionList);
//        String[] feedBackQuestionStrings = new String[] { "Cleaning of Toilets(Including toilet floor, commode pan, wall panels, shelf, mirror, wash basin, Disinfection and provision of deodorant etc.",
//                "Cleaning  of Passenger Compartment (Including cleaning of passenger aisle, Vestibule areas, Doorway area and Doorway wash basin, spraying of air freshner and cleaning of dustbin)",
//                "Collection of garbage from the coach compartments and clearance of dustbins.",
//                "Spraying of Mosquito/Cockroach/Fly Repellent and Providing Glue Board whenever required or on demand by passengers.",
//                "Behaviour/Response of Janitors/Supervisor (Including hygiene & cleanliness of Janitor/Supervisor)"
//        };
//        ArrayList<String> feedBackQuestionArray = new ArrayList<String>();
//        feedBackQuestionArray.addAll( Arrays.asList(feedBackQuestionStrings) );
//        // Create ArrayAdapter using the planet list.
//        ArrayAdapter<String> feedBackQuestionsAdapter = new ArrayAdapter<String>(this, R.layout.feed_back_question_item, feedBackQuestionArray);
//        feedbackQuestionListView.setAdapter(feedBackQuestionsAdapter);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }

}

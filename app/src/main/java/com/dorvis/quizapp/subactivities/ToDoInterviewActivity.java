package com.dorvis.quizapp.subactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dorvis.quizapp.R;
import com.dorvis.quizapp.interview.ExperienceActivity;
import com.dorvis.quizapp.interview.FresherActivity;

public class ToDoInterviewActivity extends AppCompatActivity {

    ImageView iv_FAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_interview);
        iv_FAQ = (ImageView) findViewById(R.id.faq_back_arrow);
        iv_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button fresher_bt = (Button)findViewById(R.id.fresher_button);
        Button experience_bt =(Button)findViewById(R.id.experience_button);
        Button technical_bt = (Button)findViewById(R.id.technical_button);

        fresher_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), FresherActivity.class);
                startActivity(intent);
            }
        });

        experience_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ExperienceActivity.class);
                startActivity(intent);
            }
        });
        technical_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Comming soon..",Toast.LENGTH_SHORT).show();


            }
        });
    }
}

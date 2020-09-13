package com.dorvis.quizapp.subactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dorvis.quizapp.AndroidActivity;
import com.dorvis.quizapp.CProgramActivity;
import com.dorvis.quizapp.JavaActivity;
import com.dorvis.quizapp.PythonActivity;
import com.dorvis.quizapp.R;

public class DailyQuizActivity extends AppCompatActivity {
    ImageView iv_FAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quiz);
        iv_FAQ = (ImageView) findViewById(R.id.faq_back_arrow);
        iv_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView img_android = (ImageView)findViewById(R.id.img_android);
        img_android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AndroidActivity.class);
                startActivity(intent);
            }
        });
        //Call pythonActivity quiz test
        ImageView image_python = (ImageView)findViewById(R.id.img_python);
        image_python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PythonActivity.class);
                startActivity(intent);
            }
        });
        //Call JavaActivity quiz test
        ImageView img_java = (ImageView)findViewById(R.id.img_java);
        img_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JavaActivity.class);
                startActivity(intent);
            }
        });
        //Call CprogramActivity quiz test
        ImageView img_cprogram = (ImageView)findViewById(R.id.img_cprogram);
        img_cprogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CProgramActivity.class);
                startActivity(intent);
            }
        });

    }
}

package com.dorvis.quizapp.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class JavaResultActivity extends AppCompatActivity {
    public TextView textViewHighscoreJ;
    ImageView back_imageViewJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_result);

        textViewHighscoreJ=(TextView)findViewById(R.id.textview_resultJ);

        back_imageViewJ = (ImageView) findViewById(R.id.faq_back_arrowJ);
        back_imageViewJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // getting result by bundle
        //get text view
        Bundle bundle = getIntent().getExtras();
        String test = bundle.getString("test");
        textViewHighscoreJ.setText(test);
    }
}
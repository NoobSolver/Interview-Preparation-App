package com.dorvis.quizapp.result;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class AndroidResultActivity extends AppCompatActivity  {


  public TextView textViewHighscoreA;

    ImageView back_imageViewA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textViewHighscoreA=(TextView)findViewById(R.id.textview_resultA);

       back_imageViewA = (ImageView)findViewById(R.id.faq_back_arrowA);
       back_imageViewA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               
               finish();
           }
       });

        //get text view
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null) {
            String test = bundle.getString("test");
            textViewHighscoreA.setText(test);
        }




    }





}
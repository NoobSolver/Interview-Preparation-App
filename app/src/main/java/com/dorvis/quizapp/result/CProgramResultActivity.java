package com.dorvis.quizapp.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class CProgramResultActivity extends AppCompatActivity {
    public TextView textViewHighscoreC;
    ImageView back_imageViewC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cprogram_result);
        textViewHighscoreC=(TextView)findViewById(R.id.textview_resultC);
        back_imageViewC = (ImageView)findViewById(R.id.faq_back_arrowC) ;
        back_imageViewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
      // getting result by bundle
        //get text view
        Bundle bundle = getIntent().getExtras();
        String test = bundle.getString("test");
        textViewHighscoreC.setText(test);

        }



}






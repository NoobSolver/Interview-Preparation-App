package com.dorvis.quizapp.result;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class PythonResultActivity extends AppCompatActivity {
     public TextView textViewHighscoreP;
     ImageView imageView_backP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_result);
        textViewHighscoreP=(TextView)findViewById(R.id.textview_resultP);

        imageView_backP = (ImageView) findViewById(R.id.faq_back_arrowP);
        imageView_backP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        // getting result by bundle
        //get text view
        Bundle bundle = getIntent().getExtras();
        String test = bundle.getString("test");
        textViewHighscoreP.setText(test);

    }


}



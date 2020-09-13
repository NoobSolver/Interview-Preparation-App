package com.dorvis.quizapp.subactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dorvis.quizapp.R;

public class ToDoNotificationActivity extends AppCompatActivity {
    private ImageView notfiy_imageview;
    private ImageView iv_FAQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_notification);
        notfiy_imageview = (ImageView)findViewById(R.id.notify_imageview);
        iv_FAQ =(ImageView)findViewById(R.id.faq_back_arrow);

        iv_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

package com.dorvis.quizapp.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dorvis.quizapp.R;

public class AboutUsActivity extends AppCompatActivity {
    private Button btnFollowMe;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mToolbar = (Toolbar)findViewById(R.id.about_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("About Me");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button bt_webview = (Button)findViewById(R.id.bt_weview);


       btnFollowMe =(Button)findViewById(R.id.btnfollow_me);
        btnFollowMe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/Sainathhiwale"));
                startActivity(intent);

            }

        });

        bt_webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutUsActivity.this,AndroidHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}

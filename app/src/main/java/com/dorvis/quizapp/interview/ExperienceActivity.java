package com.dorvis.quizapp.interview;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dorvis.quizapp.R;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class ExperienceActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView iv_FAQ;

    ExpandableRelativeLayout expandableRelativeLayout_1,expandableRelativeLayout_2,expandableRelativeLayout_3,
            expandableRelativeLayout_4,expandableRelativeLayout_5,expandableRelativeLayout_6,
            expandableRelativeLayout_7,expandableRelativeLayout_8,expandableRelativeLayout_9,
            expandableRelativeLayout_10,expandableRelativeLayout_11, expandableRelativeLayout_12,
            expandableRelativeLayout_13, expandableRelativeLayout_14;


    Button btn_Qns_1,btn_Qns_2,btn_Qns_3,btn_Qns_4,btn_Qns_5,btn_Qns_6,
            btn_Qns_7,btn_Qns_8,btn_Qns_9,btn_Qns_10,btn_Qns_11, btn_Qns_12,btn_Qns_13,btn_Qns_14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        iv_FAQ = (ImageView) findViewById(R.id.faq_back_arrow);
        iv_FAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        expandableRelativeLayout_1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout_1);
        expandableRelativeLayout_2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableRelativeLayout_3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableRelativeLayout_4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableRelativeLayout_5 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout5);
        expandableRelativeLayout_6 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout6);
        expandableRelativeLayout_7 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout7);
        expandableRelativeLayout_8 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout8);
        expandableRelativeLayout_9 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout9);
        expandableRelativeLayout_10 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout10);
        expandableRelativeLayout_11 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout11);
        expandableRelativeLayout_12 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout12);
        expandableRelativeLayout_13 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout13);
        expandableRelativeLayout_14 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout14);

        btn_Qns_1 = (Button) findViewById(R.id.expandableButton1);
        btn_Qns_2 = (Button) findViewById(R.id.expandableButton2);
        btn_Qns_3 = (Button) findViewById(R.id.expandableButton3);
        btn_Qns_4 = (Button) findViewById(R.id.expandableButton4);
        btn_Qns_5 = (Button) findViewById(R.id.expandableButton5);
        btn_Qns_6 = (Button) findViewById(R.id.expandableButton6);
        btn_Qns_7 = (Button) findViewById(R.id.expandableButton7);
        btn_Qns_8 = (Button) findViewById(R.id.expandableButton8);
        btn_Qns_9 = (Button) findViewById(R.id.expandableButton9);
        btn_Qns_10 = (Button) findViewById(R.id.expandableButton10);
        btn_Qns_11= (Button) findViewById(R.id.expandableButton11);
        btn_Qns_12= (Button) findViewById(R.id.expandableButton12);
        btn_Qns_13= (Button) findViewById(R.id.expandableButton13);
        btn_Qns_14= (Button) findViewById(R.id.expandableButton14);

        btn_Qns_1.setOnClickListener(this);
        btn_Qns_2.setOnClickListener(this);
        btn_Qns_3.setOnClickListener(this);
        btn_Qns_4.setOnClickListener(this);
        btn_Qns_5.setOnClickListener(this);
        btn_Qns_6.setOnClickListener(this);
        btn_Qns_7.setOnClickListener(this);
        btn_Qns_8.setOnClickListener(this);
        btn_Qns_9.setOnClickListener(this);
        btn_Qns_10.setOnClickListener(this);
        btn_Qns_11.setOnClickListener(this);
        btn_Qns_12.setOnClickListener(this);
        btn_Qns_13.setOnClickListener(this);
        btn_Qns_14.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.expandableButton1:
                expandableRelativeLayout_1.toggle();
                break;
            case R.id.expandableButton2:
                expandableRelativeLayout_2.toggle();
                break;
            case R.id.expandableButton3:
                expandableRelativeLayout_3.toggle();
                break;
            case R.id.expandableButton4:
                expandableRelativeLayout_4.toggle();
                break;
            case R.id.expandableButton5:
                expandableRelativeLayout_5.toggle();
                break;
            case R.id.expandableButton6:
                expandableRelativeLayout_6.toggle();
                break;
            case R.id.expandableButton7:
                expandableRelativeLayout_7.toggle();
                break;
            case R.id.expandableButton8:
                expandableRelativeLayout_8.toggle();
                break;
            case R.id.expandableButton9:
                expandableRelativeLayout_9.toggle();
                break;
            case R.id.expandableButton10:
                expandableRelativeLayout_10.toggle();
                break;
            case R.id.expandableButton11:
                expandableRelativeLayout_11.toggle();
                break;
            case R.id.expandableButton12:
                expandableRelativeLayout_12.toggle();
                break;
            case R.id.expandableButton13:
                expandableRelativeLayout_13.toggle();
                break;
            case R.id.expandableButton14:
                expandableRelativeLayout_14.toggle();
                break;
        }
    }
}
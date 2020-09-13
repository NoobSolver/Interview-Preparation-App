package com.dorvis.quizapp;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dorvis.quizapp.result.JavaResultActivity;
import com.dorvis.quizapp.model.Question2;
import com.dorvis.quizapp.sql.AndyDatabaseHelper;

import java.util.Collections;
import java.util.List;

public class JavaActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    public TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;

    private List<Question2> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question2 currentQuestion;

    private int score;
    private boolean answered;

    private ColorStateList textColorDefaultRb;




    private ImageView backarrw_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        textViewQuestion = (TextView)findViewById(R.id.text_view_question);
        textViewScore = (TextView) findViewById(R.id.text_view_score);
        textViewQuestionCount = (TextView)(TextView)findViewById(R.id.text_view_question_count);
        textViewCountDown = (TextView)findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1J);
        rb2 = findViewById(R.id.radio_button2J);
        rb3 = findViewById(R.id.radio_button3J);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        backarrw_img = (ImageView) findViewById(R.id.faq_back_java);
        backarrw_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        AndyDatabaseHelper  dbHelper = new AndyDatabaseHelper(this);
        questionList = dbHelper.getAllQuestionj();
        questionCountTotal = questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(JavaActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getJavaQUESTION());
            rb1.setText(currentQuestion.getjOPTA());
            rb2.setText(currentQuestion.getjOPTB());
            rb3.setText(currentQuestion.getjOPTC());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");
        } else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getjANSWER()) {
            score++;
            textViewScore.setText("Score: " + score);
        }

        showSolution();
    }

    private void showSolution() {


        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");


        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

    private void finishQuiz() {
        Intent intent = new Intent(JavaActivity.this,JavaResultActivity.class);
        String data = textViewScore.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("test",data);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}
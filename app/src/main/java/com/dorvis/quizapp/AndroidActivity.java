package com.dorvis.quizapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dorvis.quizapp.result.AndroidResultActivity;
import com.dorvis.quizapp.model.Question;
import com.dorvis.quizapp.sql.AndyDatabaseHelper;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class AndroidActivity extends AppCompatActivity  {

    private static final long COUNTDOWN_IN_MILLIS = 60000;
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmNext;
    private List<Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private int score;
    private boolean answered;

    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private ImageView backarr_img;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        textViewQuestion = (TextView)findViewById(R.id.text_view_question);
        textViewScore =(TextView)findViewById(R.id.text_view_score);
        textViewQuestionCount =(TextView) findViewById(R.id.text_view_question_count);
        textViewCountDown = (TextView)findViewById(R.id.text_view_countdown);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1A);
        rb2 = findViewById(R.id.radio_button2A);
        rb3 = findViewById(R.id.radio_button3A);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        textColorDefaultRb = rb1.getTextColors();
        textColorDefaultCd = textViewCountDown.getTextColors();
        backarr_img = (ImageView) findViewById(R.id.faq_back_android);
        backarr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // call sqlite helper class
        AndyDatabaseHelper  dbHelper = new AndyDatabaseHelper(this);

        //call model class private List<Question> questionList
        questionList = dbHelper.getAllQuestions(); // get all question using cursor and query
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
                        Toast.makeText(AndroidActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
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

            textViewQuestion.setText(currentQuestion.getQUESTION());
            rb1.setText(currentQuestion.getOPTA());
            rb2.setText(currentQuestion.getOPTB());
            rb3.setText(currentQuestion.getOPTC());

            questionCounter++;
            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else {
            finishQuiz();
        }
    }
    public void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
              timeLeftInMillis =0;
              updateCountDownText();
              checkAnswer();
            }
        }.start();

    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis<10000){
            textViewCountDown.setTextColor(Color.RED);

        }else {
            textViewCountDown.setTextColor(textColorDefaultCd);
        }

    }
    private void checkAnswer() {
        answered = true;
        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getANSWER()) {
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

        Intent intent = new Intent(AndroidActivity.this,AndroidResultActivity.class);
        String data = textViewScore.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("test",data);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}
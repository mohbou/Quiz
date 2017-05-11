package com.quizappexam.app.testingcenter.presentation.features.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.quizappexam.app.testingcenter.R;
import com.quizappexam.app.testingcenter.presentation.features.playQuiz.QuizActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

   @OnClick(R.id.button_new_test)
    public void onClickButtonNewTest() {
        Intent intent = new Intent(MainActivity.this,QuizActivity.class);
        startActivity(intent);
    }
}

package com.quizappexam.app.testingcenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class QuizActivity extends AppCompatActivity implements QuizActivityView {

    private QuizActivityPresenter mQuizActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mQuizActivityPresenter = new QuizActivityPresenter(this, null);


    }



    @Override
    public void displayQuestion(List<Question> questionList) {

    }

    @Override
    public void displayNoQuestions() {

    }
}

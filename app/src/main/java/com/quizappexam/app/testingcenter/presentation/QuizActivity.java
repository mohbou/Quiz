package com.quizappexam.app.testingcenter.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quizappexam.app.testingcenter.R;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public class QuizActivity extends AppCompatActivity implements QuizActivityView {

    private QuizActivityPresenter mQuizActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mQuizActivityPresenter = new QuizActivityPresenter(this, null);
        mQuizActivityPresenter.loadQuestions();


    }



    @Override
    public void displayQuestion(List<Question> questionList) {

    }

    @Override
    public void displayNoQuestions() {

    }
}

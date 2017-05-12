package com.quizappexam.app.testingcenter.data.database;

import android.content.Context;

import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.ArrayList;
import java.util.List;


//just a stub for now

public class DatabaseImpl implements Database {

    private static Database mDatabase;

    private DatabaseImpl() {

    }

    public static Database getInstance(Context context) {
        if(mDatabase ==null)
            mDatabase = new DatabaseImpl();
        return mDatabase;
    }
    @Override
    public List<Question> getQuestions() {

        List<Question> questions= new ArrayList<>();
        for (int j = 0; j < 20; j++) {

            Question q1 = new Question();
            List<Answer> answers = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                Answer a1 = new Answer();
                a1.setStatement("This is the " + i + " fake answer for now for Q "+j);
                answers.add(a1);
            }
            q1.setAnswers(answers);
            q1.setStatement("This is the " + j + " fake question for now");

            questions.add(q1);
        }
        return questions;
    }
}

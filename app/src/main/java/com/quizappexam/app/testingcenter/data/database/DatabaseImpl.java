package com.quizappexam.app.testingcenter.data.database;

import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//just a stub for now

public class DatabaseImpl implements Database {
    @Override
    public List<Question> getQuestions() {
        Question q1 = new Question();
       List<Answer> answers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Answer a1 =  new Answer();
            a1.setStatement("This is the "+i+" fake answer for now");
            answers.add(a1);
        }
        q1.setAnswers(answers);

        return Arrays.asList(q1);
    }
}

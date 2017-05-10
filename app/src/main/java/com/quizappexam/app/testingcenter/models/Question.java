package com.quizappexam.app.testingcenter.models;

import java.util.List;

public class Question {
   private List<Answer> mAnswers;

    public List<Answer> getAnswers() {
        return mAnswers;
    }

    public void setAnswers(List<Answer> answers) {
        mAnswers = answers;
    }
}

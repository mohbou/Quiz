package com.quizappexam.app.testingcenter.models;

import java.util.List;

public class Question {
   private List<Answer> mAnswers;
    private String statement;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<Answer> getAnswers() {
        return mAnswers;
    }

    public void setAnswers(List<Answer> answers) {
        mAnswers = answers;
    }
}

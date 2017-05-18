package com.quizappexam.app.testingcenter.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "answer")
public class Answer {

    @DatabaseField(id=true)
    private int answerId;
    @DatabaseField
    private String statement;
    @DatabaseField
    private boolean correct;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "questionid")
    private Question question;

    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

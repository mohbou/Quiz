package com.quizappexam.app.testingcenter.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "answer")
public class Answer {

    @DatabaseField(generatedId = true)
    private int answerId;

    @DatabaseField
    private String statement;

    @DatabaseField
    private boolean correct;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "questionid")
    private Question question;

    private boolean selected;

    public Answer() {
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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

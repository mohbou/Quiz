package com.quizappexam.app.testingcenter.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.List;

@DatabaseTable(tableName = "question")
public class Question {
    @DatabaseField(id = true)
    private int questionId;
    @DatabaseField
    private List<Answer> mAnswers;
    @DatabaseField
    private String statement;

    @ForeignCollectionField
    private ForeignCollection<Answer> mAnswerCollection;

    public Question() {
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<Answer> getAnswers() {
        if(mAnswers==null) {
            mAnswers =new ArrayList<>(mAnswerCollection);
        }
        return mAnswers;
    }

    public void setAnswers(List<Answer> answers) {
        mAnswers = answers;
    }

    public ForeignCollection<Answer> getAnswerCollection() {
        return mAnswerCollection;
    }

    public void setAnswerCollection(ForeignCollection<Answer> answerCollection) {
        mAnswerCollection = answerCollection;
    }
}

package com.quizappexam.app.testingcenter.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "question")
public class Question {

    @DatabaseField(generatedId = true)
    private int questionId;

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


    public ForeignCollection<Answer> getAnswerCollection() {
        return mAnswerCollection;
    }

    public void setAnswerCollection(ForeignCollection<Answer> answerCollection) {
        mAnswerCollection = answerCollection;
    }
}

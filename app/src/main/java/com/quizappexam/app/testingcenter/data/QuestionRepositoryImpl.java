package com.quizappexam.app.testingcenter.data;

import android.content.Context;

import com.quizappexam.app.testingcenter.data.database.Database;
import com.quizappexam.app.testingcenter.data.database.DatabaseImpl;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public class QuestionRepositoryImpl implements QuestionsRepository {

    Database database;

    public QuestionRepositoryImpl(Context context) {
        database = DatabaseImpl.getInstance(context);
    }

    @Override
    public List<Question> getQuestions() {
        return database.getQuestions();
    }
}

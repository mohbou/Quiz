package com.quizappexam.app.testingcenter.data;

import com.quizappexam.app.testingcenter.data.database.Database;
import com.quizappexam.app.testingcenter.data.database.DatabaseImpl;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public class QuestionRepositoryImpl implements QuestionsRepository {

    Database database;

    public QuestionRepositoryImpl() {
        database = new DatabaseImpl();
    }

    @Override
    public List<Question> getQuestions() {
        return database.getQuestions();
    }
}

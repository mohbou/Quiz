package com.quizappexam.app.testingcenter.data.database;

import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public interface Database {
    public List<Question> getQuestions();
}

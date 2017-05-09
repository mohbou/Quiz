package com.quizappexam.app.testingcenter.data;

import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public interface  QuestionsRepository {
    public List<Question> getQuestions();
}

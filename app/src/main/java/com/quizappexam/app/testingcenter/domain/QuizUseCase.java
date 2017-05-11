package com.quizappexam.app.testingcenter.domain;

import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public interface QuizUseCase {

    public List<Question> getQuestions();
    public Question getQuestion(int index);
}

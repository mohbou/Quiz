package com.quizappexam.app.testingcenter.presentation;


import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

public interface QuizActivityView {
    public void displayQuestion(List<Question> questionList);
    public void displayNoQuestions();
}

package com.quizappexam.app.testingcenter;


import java.util.List;

public interface QuizActivityView {
    public void displayQuestion(List<Question> questionList);
    public void displayNoQuestions();
}

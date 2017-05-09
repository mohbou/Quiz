package com.quizappexam.app.testingcenter.presentation;

import com.quizappexam.app.testingcenter.domain.QuizUseCase;
import com.quizappexam.app.testingcenter.models.Question;


import java.util.List;

public class QuizActivityPresenter {
    private QuizActivityView mView;
    private QuizUseCase mQuizUseCase;

    public QuizActivityPresenter(QuizActivityView view, QuizUseCase quizUseCase) {
        mView = view;
        this.mQuizUseCase = quizUseCase;
    }

    public void loadQuestions() {
        List<Question> questions = mQuizUseCase.getQuestions();

        if (!questions.isEmpty())
            mView.displayQuestion(questions);
        else
            mView.displayNoQuestions();
    }
}

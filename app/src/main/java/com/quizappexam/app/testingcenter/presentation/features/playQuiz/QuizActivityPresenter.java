package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import com.quizappexam.app.testingcenter.domain.QuizUseCase;
import com.quizappexam.app.testingcenter.models.Question;


import java.util.List;

public class QuizActivityPresenter {
    private QuizActivityView mView;
    private QuizUseCase mQuizUseCase;
    private List<Question> mQuestions;

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    private int currentQuestionIndex;

    public QuizActivityPresenter(QuizActivityView view, QuizUseCase quizUseCase) {
        mView = view;
        this.mQuizUseCase = quizUseCase;
    }

    public void loadQuestions() {
        mQuestions = mQuizUseCase.getQuestions();

        if (!mQuestions.isEmpty())
            mView.displayQuestion(mQuestions);
        else
            mView.displayNoQuestions();
    }

    public void loadQuestion() {

       mView.displayNextQuestion(mQuestions.get(++currentQuestionIndex));
    }
}

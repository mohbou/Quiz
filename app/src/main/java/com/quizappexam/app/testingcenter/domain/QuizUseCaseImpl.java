package com.quizappexam.app.testingcenter.domain;

import com.quizappexam.app.testingcenter.data.QuestionRepositoryImpl;
import com.quizappexam.app.testingcenter.data.QuestionsRepository;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizUseCaseImpl implements QuizUseCase {

    private QuestionsRepository mQuestionsRepository;

    public QuizUseCaseImpl() {
        mQuestionsRepository = new QuestionRepositoryImpl();
    }

    @Override
    public List<Question> getQuestions() {
        return mQuestionsRepository.getQuestions();
    }
}

package com.quizappexam.app.testingcenter.domain;

import com.quizappexam.app.testingcenter.data.QuestionRepositoryImpl;
import com.quizappexam.app.testingcenter.data.QuestionsRepository;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizUseCaseImpl implements QuizUseCase {

    private QuestionsRepository mQuestionsRepository;
    private List<Question> mQuestionList= new ArrayList<>();

    public QuizUseCaseImpl() {
        mQuestionsRepository = new QuestionRepositoryImpl();
    }

    @Override
    public List<Question> getQuestions() {

        if(mQuestionList.isEmpty()) {
            mQuestionList=mQuestionsRepository.getQuestions();
        }
        return mQuestionList;
    }

    @Override
    public Question getQuestion(int index) {
        return  getQuestions().get(index);
    }
}

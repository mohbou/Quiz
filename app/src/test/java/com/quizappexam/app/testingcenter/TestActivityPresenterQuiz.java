package com.quizappexam.app.testingcenter;


import com.quizappexam.app.testingcenter.domain.QuizUseCase;
import com.quizappexam.app.testingcenter.models.Question;
import com.quizappexam.app.testingcenter.presentation.features.playQuiz.QuizActivityPresenter;
import com.quizappexam.app.testingcenter.presentation.features.playQuiz.QuizActivityView;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TestActivityPresenterQuiz {

    @Test
    public void shouldPassAllQuestions() {


        //given
        QuizActivityView view = new MockView();
        QuizUseCase quizUseCase =  new MockTestUseCase(true);
        QuizActivityPresenter presenter = new QuizActivityPresenter(view, quizUseCase);

        //when
        presenter.loadQuestions();

        // then
        assertEquals(true,((MockView)view).passedQuestions);

    }

    @Test
    public void shouldPassNoQuestions() {

        //given
        QuizActivityView view = new MockView();
        QuizUseCase quizUseCase =  new MockTestUseCase(false);
        QuizActivityPresenter presenter =  new QuizActivityPresenter(view, quizUseCase);

        //when
        presenter.loadQuestions();

        //then
        assertEquals(true,((MockView)view).noQuestions);


    }

    private class MockView implements QuizActivityView {
        private boolean passedQuestions;
        private  boolean noQuestions;

        @Override
        public void displayQuestion(List<Question> questionList) {
            if (questionList.size()==3) passedQuestions =true;
        }

        @Override
        public void displayNoQuestions() {
            noQuestions = true;
        }

        @Override
        public void displayNextQuestion(Question question) {

        }
    }


    private class MockTestUseCase implements QuizUseCase {
         private   boolean passBooks;

        public MockTestUseCase(boolean passBooks) {
            this.passBooks = passBooks;
        }

        @Override
        public List<Question> getQuestions() {
            if(passBooks)
            return Arrays.asList(new Question(),new Question(),new Question());
            else
            return Collections.emptyList();
        }

        @Override
        public Question getQuestion(int index) {
            return null;
        }
    }



}
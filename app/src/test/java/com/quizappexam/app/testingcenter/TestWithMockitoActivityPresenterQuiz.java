package com.quizappexam.app.testingcenter;


import com.quizappexam.app.testingcenter.domain.QuizUseCase;
import com.quizappexam.app.testingcenter.models.Question;
import com.quizappexam.app.testingcenter.presentation.features.playQuiz.QuizActivityPresenter;
import com.quizappexam.app.testingcenter.presentation.features.playQuiz.QuizActivityView;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestWithMockitoActivityPresenterQuiz {



    @Mock
    QuizUseCase quizUseCase;

    @Mock
    QuizActivityView view;

    private static final List<Question> EMPTY_LIST =Collections.emptyList();
    private final List<Question> mQuestionList = Arrays.asList(new Question(), new Question(), new Question());

    private QuizActivityPresenter presenter;


    @Before
    public void setUp() throws Exception {
        presenter = new QuizActivityPresenter(view, quizUseCase);
    }

    @Test
    public void shouldPassAllQuestions() {

        //given
        when(quizUseCase.getQuestions()).thenReturn(mQuestionList);

        //when
        presenter.loadQuestions();

        // then
        verify(view).displayQuestion(mQuestionList);

    }

    @Test
    public void shouldPassNoQuestions() {

        //given

        when(quizUseCase.getQuestions()).thenReturn(EMPTY_LIST);


        //when
        presenter.loadQuestions();

        //then
        verify(view).displayNoQuestions();
    }

    @Test
    public void shouldPassQuestionWhenUserRequestNextQuestion() {

    Question value = new Question();
    when(quizUseCase.getQuestion(anyInt())).thenReturn(value);

       presenter.loadQuestion();

        verify(view).displayNextQuestion(value);
    }


}
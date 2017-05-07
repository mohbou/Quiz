package com.quizappexam.app.testingcenter;


import org.junit.Before;
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

    private static final List<Question> EMPTY_LIST =Collections.emptyList();
    @Mock
    QuizUseCase quizUseCase;

    @Mock
    QuizActivityView view;
    private final List<Question> MANY_BOOKS= Arrays.asList(new Question(), new Question(), new Question());
    private QuizActivityPresenter presenter;


    @Before
    public void setUp() throws Exception {
        presenter = new QuizActivityPresenter(view, quizUseCase);
    }

    @Test
    public void shouldPassAllQuestions() {

        //given
        when(quizUseCase.getQuestions()).thenReturn(MANY_BOOKS);

        //when
        presenter.loadQuestions();

        // then
        verify(view).displayQuestion(MANY_BOOKS);

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


}
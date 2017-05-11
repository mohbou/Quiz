package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.quizappexam.app.testingcenter.R;
import com.quizappexam.app.testingcenter.domain.QuizUseCaseImpl;
import com.quizappexam.app.testingcenter.models.Question;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizActivity extends AppCompatActivity implements QuizActivityView {

    private QuizActivityPresenter mQuizActivityPresenter;
    private List<Question> mQuestionList;
    private AnswerAdapter answerAdapter;

    @BindView(R.id.recyclerViewAnswersID)
    RecyclerView answerRecyclerView;

    @BindView(R.id.questionStatement)
    TextView questionStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        mQuizActivityPresenter = new QuizActivityPresenter(this, new QuizUseCaseImpl());
        mQuizActivityPresenter.loadQuestions();

    }

    @Override
    public void displayQuestion(List<Question> questionList) {
        this.mQuestionList = questionList;
        answerRecyclerView.setLayoutManager(new LinearLayoutManager(QuizActivity.this));
        questionStatement.setText(mQuestionList.get(0).getStatement());
        answerAdapter = new AnswerAdapter(mQuestionList.get(0).getAnswers());
        answerRecyclerView.setAdapter(answerAdapter);

    }

    @Override
    public void displayNoQuestions() {

    }

    @Override
    public void displayNextQuestion(Question question) {
        questionStatement.setText(question.getStatement());
        answerAdapter.updateQuestion(question.getAnswers());

    }

    @OnClick(R.id.nextQuestionBtn)
    public void onClickNextQuestion() {
        mQuizActivityPresenter.loadQuestion();
    }

}
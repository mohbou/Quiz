package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.quizappexam.app.testingcenter.R;

import com.quizappexam.app.testingcenter.domain.QuizUseCaseImpl;
import com.quizappexam.app.testingcenter.models.Answer;
import com.quizappexam.app.testingcenter.models.Question;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity implements QuizActivityView {

    private QuizActivityPresenter mQuizActivityPresenter;
    private List<Question> mQuestionList;
    private AnswerAdapter anwerAdapter;

    @BindView(R.id.recyclerViewAnswersID)
    RecyclerView answerRecyclerView;


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
        anwerAdapter = new AnswerAdapter(mQuestionList.get(0).getAnswers());
        answerRecyclerView.setAdapter(anwerAdapter);

    }

    @Override
    public void displayNoQuestions() {

    }

    @Override
    public void displayNextQuestion(Question question) {

    }

    class AnswerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Answer answer;

        @BindView(R.id.checkBoxAnswerId)
        CheckBox checkBoxAnswer;

        @BindView(R.id.answerStatementId)
        TextView answerStatement;


        public AnswerHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_answer, parent, false));
            ButterKnife.bind(this, itemView);
            answerStatement.setOnClickListener(this);


        }

        public void bind(Answer answer) {
            this.answer = answer;
            checkBoxAnswer.setChecked(false);
            answerStatement.setText(answer.getStatement());

        }

        @Override
        public void onClick(View view) {
            checkBoxAnswer.setChecked(!checkBoxAnswer.isChecked());
        }
    }

    class AnswerAdapter extends RecyclerView.Adapter<AnswerHolder> {

        private List<Answer> answers;

        public AnswerAdapter(List<Answer> answers) {
            this.answers = answers;
        }

        @Override
        public AnswerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(QuizActivity.this);
            return new AnswerHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(AnswerHolder holder, int position) {
            Answer answer = answers.get(position);
            holder.bind(answer);
        }

        @Override
        public int getItemCount() {
            return answers.size();
        }
    }

}
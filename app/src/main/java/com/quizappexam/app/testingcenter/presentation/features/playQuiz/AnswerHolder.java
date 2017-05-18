package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.quizappexam.app.testingcenter.R;
import com.quizappexam.app.testingcenter.models.Answer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnswerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Answer answer;


    @BindView(R.id.checkBoxAnswerId)
    CheckBox checkBoxAnswer;

    @BindView(R.id.answerStatementId)
    TextView answerStatement;


    public AnswerHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.list_item_answer, parent, false));
        ButterKnife.bind(this, itemView);
        answerStatement.setOnClickListener(this);
        checkBoxAnswer.setOnClickListener(this);


    }

    public void bind(Answer answer) {
        this.answer = answer;
        checkBoxAnswer.setChecked(false);
        answerStatement.setText(answer.getStatement());

    }

    @Override
    public void onClick(View view) {
        if (view.equals(answerStatement)) {
            checkBoxAnswer.setChecked(!checkBoxAnswer.isChecked());
        }
    }

    public Answer getAnswer() {
        return answer;
    }
}

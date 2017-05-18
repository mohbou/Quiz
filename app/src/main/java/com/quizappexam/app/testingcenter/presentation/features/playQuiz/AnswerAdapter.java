package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.quizappexam.app.testingcenter.models.Answer;

import java.util.List;

public class  AnswerAdapter extends RecyclerView.Adapter<AnswerHolder> {

    private List<Answer> answers;

    public AnswerAdapter(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public AnswerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new AnswerHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(final AnswerHolder holder, int position) {
        final Answer answer = answers.get(position);
        holder.bind(answer);

        holder.checkBoxAnswer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                answers.get(holder.getAdapterPosition()).setSelected(isChecked);

            }
        });


    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public void updateQuestion(List<Answer> answers) {
        this.answers =answers;
        notifyDataSetChanged();

    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
package com.quizappexam.app.testingcenter.presentation.features.playQuiz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

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
    public void onBindViewHolder(AnswerHolder holder, int position) {
        Answer answer = answers.get(position);
        holder.bind(answer);
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }
}
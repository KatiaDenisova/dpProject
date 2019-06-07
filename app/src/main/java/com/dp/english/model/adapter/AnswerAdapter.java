package com.dp.english.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.dp.english.R;
import com.dp.english.model.Answer;
import com.dp.english.model.Lesson;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>{
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    private List<Answer> answers;
    private OnItemClickListener mOnItemClickListener;

    public AnswerAdapter(List<Answer> answers, OnItemClickListener mOnItemClickListener) {
        this.answers = answers;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForAnswerList = R.layout.answer_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForAnswerList, viewGroup, false);

        AnswerViewHolder answerViewHolder = new AnswerViewHolder(view);
        return answerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder answerViewHolder,final int i) {
        answerViewHolder.bind(answers.get(i));
        answerViewHolder.answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    class AnswerViewHolder extends RecyclerView.ViewHolder{
        CheckBox answerC;
        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            answerC = itemView.findViewById(R.id.checkBox);
        }

        void bind(Answer answer){
            answerC.setText(String.format("%s", answer.getTheAnswer()));
        }
    }
}

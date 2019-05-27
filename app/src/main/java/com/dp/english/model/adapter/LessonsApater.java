package com.dp.english.model.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dp.english.R;
import com.dp.english.model.Lesson;

import java.util.List;

public class LessonsApater extends RecyclerView.Adapter<LessonsApater.LessonViewHolder>{
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    private List<Lesson> lessonList;
    private OnItemClickListener mOnItemClickListener;

//    public LessonsApater(List<Lesson> lessonList) {
//        this.lessonList = lessonList;
//    }

    public LessonsApater(List<Lesson> lessonList, OnItemClickListener mOnItemClickListener) {
        this.lessonList = lessonList;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForLessonList = R.layout.lesson_list_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForLessonList, viewGroup, false);

        LessonViewHolder lessonViewHolder = new LessonViewHolder(view);
        return lessonViewHolder;
    }
     public Lesson getItem(int position){
        return lessonList.get(position);
     }
    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder lessonViewHolder, final int i) {
        lessonViewHolder.bind(lessonList.get(i));
        lessonViewHolder.bt_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    class LessonViewHolder extends RecyclerView.ViewHolder{
        Button bt_lesson;
        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            bt_lesson = itemView.findViewById(R.id.bt_strat_lesson);
        }

        void bind(Lesson lesson){
            bt_lesson.setText(String.format("%s", lesson.getNameLesson()));
        }
    }
}

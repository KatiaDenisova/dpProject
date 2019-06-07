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
import com.dp.english.model.Test;

import java.util.List;

public class TestsAdapter extends RecyclerView.Adapter<TestsAdapter.TestViewHolder>{
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    private List<Test> testList;
    private OnItemClickListener mOnItemClickListener;

    public TestsAdapter(List<Test> testList, OnItemClickListener mOnItemClickListener) {
        this.testList = testList;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForTestList = R.layout.test_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForTestList, viewGroup, false);

        TestViewHolder testViewHolder = new TestViewHolder(view);
        return testViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder testViewHolder,final int i) {
        testViewHolder.bind(testList.get(i));
        testViewHolder.testB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,i);
            }
        });
    }
    public Test getItem(int position){
        return testList.get(position);
    }
    @Override
    public int getItemCount() {
        return testList.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder{
        Button testB;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            testB = itemView.findViewById(R.id.bt_strat_test);
        }

        void bind(Test test){
            testB.setText(String.format("%s", test.getNameTest()));
        }
    }
}

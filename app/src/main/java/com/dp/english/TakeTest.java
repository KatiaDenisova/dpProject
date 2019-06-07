package com.dp.english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.dp.english.model.MyDatabase;
import com.dp.english.model.Test;
import com.dp.english.model.TestDao;
import com.dp.english.model.adapter.AnswerAdapter;

public class TakeTest extends AppCompatActivity {
private RecyclerView answerlist;
private AnswerAdapter adapter;
private TextView testName;
private Test test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = (int) getIntent().getSerializableExtra("test");
        test = getLesson(id);
        setContentView(R.layout.activity_take_test);
        testName = findViewById(R.id.tv_testName);
        testName.setText(test.getNameTest());
    }

    private Test getLesson(int id) {
        MyDatabase db = App.getInstance().getUserDatabase();
        TestDao testDao = db.getTestDao();
        Test test = testDao.getTest(id);
        return test;
    }
}

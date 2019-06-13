package com.dp.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dp.english.model.Answer;
import com.dp.english.model.AnswerDao;
import com.dp.english.model.MyDatabase;
import com.dp.english.model.Question;
import com.dp.english.model.QuestionDao;
import com.dp.english.model.Test;
import com.dp.english.model.TestDao;
import com.dp.english.model.adapter.TestsAdapter;

import java.util.List;

public class TestChoose extends AppCompatActivity {
private RecyclerView testList;
private TestsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_choose);

        testList = findViewById(R.id.rv_test_list);
        MyDatabase db = App.getInstance().getUserDatabase();
    insertData();
    showTests();
    }

    private void insertData(){

        MyDatabase db = App.getInstance().getUserDatabase();
        TestDao testDao = db.getTestDao();
        QuestionDao questionDao = db.getQuestionDao();
        AnswerDao answerDao = db.getAnswerDao();
        if(testDao.getTests().isEmpty()){
            Test test = new Test();
            test.setId(2);
            test.setNameTest("Present Simple");
            testDao.insert(test);
            Question question = new Question(1,"Mark__cakes",test.getId());
            questionDao.insert(question);
            Answer answer = new Answer();
            answer.setId(1);
            answer.setQuestionId(question.getId());
            answer.setTheAnswer("don't love");
            answer.setStatus(false);
            answerDao.insert(answer);

            Answer answer1 = new Answer();
            answer1.setId(2);
            answer1.setQuestionId(question.getId());
            answer1.setTheAnswer("doesn't love");
            answer1.setStatus(true);
            answerDao.insert(answer1);

            Question question1 = new Question(2,"Mark__cakes1",test.getId());
            questionDao.insert(question1);
            Answer answerQ1 = new Answer();
            answerQ1.setId(3);
            answerQ1.setQuestionId(question1.getId());
            answerQ1.setTheAnswer("don't love2");
            answerQ1.setStatus(false);
            answerDao.insert(answerQ1);

            Answer answer1Q1 = new Answer();
            answer1Q1.setId(4);
            answer1Q1.setQuestionId(question1.getId());
            answer1Q1.setTheAnswer("doesn't love2");
            answer1Q1.setStatus(true);
            answerDao.insert(answer1Q1);

        }
    }
    private List<Test> getTests() {
        MyDatabase db = App.getInstance().getUserDatabase();
        TestDao testDao = db.getTestDao();
        List<Test> list = testDao.getTests();
        return list;
    }

    private void showTests(){
        testList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TestsAdapter(getTests(), new TestsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Test item = adapter.getItem(position);
                if (item!=null){
                    Intent i = new Intent(TestChoose.this, TakeTestActivity.class);
                    i.putExtra("test",  item.getId());
                    startActivity(i);
                    finish();
                }

            }
        });
        testList.setAdapter(adapter);
    }
}

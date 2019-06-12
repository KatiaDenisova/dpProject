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
            Question question = new Question(1,"Mark *** cakes",test.getId());
            questionDao.insert(question);
            Answer answer = new Answer();
            answer.setId(1);
            answer.setQuestionId(question.getId());
            answer.setTheAnswer("don't love");
            answerDao.insert(answer);

            Answer answer1 = new Answer();
            answer.setId(2);
            answer.setQuestionId(question.getId());
            answer.setTheAnswer("doesn't love");
            answerDao.insert(answer1);


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
                }

            }
        });
        testList.setAdapter(adapter);
    }
}

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
            Question question = new Question(1,"Mark ... cakes",test.getId());
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

            Answer answer1False = new Answer();
            answer1False.setId(6);
            answer1False.setQuestionId(question.getId());
            answer1False.setTheAnswer("love");
            answer1False.setStatus(false);
            answerDao.insert(answer1False);

            Question question1 = new Question(2,"A pianist ... the piano.",test.getId());
            questionDao.insert(question1);
            Answer answerQ1 = new Answer();
            answerQ1.setId(3);
            answerQ1.setQuestionId(question1.getId());
            answerQ1.setTheAnswer("don't play");
            answerQ1.setStatus(false);
            answerDao.insert(answerQ1);

            Answer answer1Q1 = new Answer();
            answer1Q1.setId(4);
            answer1Q1.setQuestionId(question1.getId());
            answer1Q1.setTheAnswer("play");
            answer1Q1.setStatus(false);
            answerDao.insert(answer1Q1);

            Answer answerTrue = new Answer();
            answerTrue.setId(5);
            answerTrue.setQuestionId(question1.getId());
            answerTrue.setTheAnswer("plays");
            answerTrue.setStatus(true);
            answerDao.insert(answerTrue);

            Question question3 = new Question(3,"Mary and Sue ... to the cinema.",test.getId());
            questionDao.insert(question3);

            Answer answerTrue1 = new Answer();
            answerTrue1.setId(7);
            answerTrue1.setQuestionId(question3.getId());
            answerTrue1.setTheAnswer("goes");
            answerTrue1.setStatus(false);
            answerDao.insert(answerTrue1);

            Answer answerTrue2 = new Answer();
            answerTrue2.setId(8);
            answerTrue2.setQuestionId(question3.getId());
            answerTrue2.setTheAnswer("doesn't go");
            answerTrue2.setStatus(false);
            answerDao.insert(answerTrue2);

            Answer answerTrue3 = new Answer();
            answerTrue3.setId(9);
            answerTrue3.setQuestionId(question3.getId());
            answerTrue3.setTheAnswer("don't go");
            answerTrue3.setStatus(true);
            answerDao.insert(answerTrue3);


            Question question4 = new Question(4,"... she learn Russian?",test.getId());
            questionDao.insert(question4);
            Answer answerTrue4 = new Answer();
            answerTrue4.setId(10);
            answerTrue4.setQuestionId(question4.getId());
            answerTrue4.setTheAnswer("Does");
            answerTrue4.setStatus(true);
            answerDao.insert(answerTrue4);

            Answer answerFalse4 = new Answer();
            answerFalse4.setId(11);
            answerFalse4.setQuestionId(question4.getId());
            answerFalse4.setTheAnswer("Do");
            answerFalse4.setStatus(false);
            answerDao.insert(answerFalse4);

            Answer answerFalse41 = new Answer();
            answerFalse41.setId(12);
            answerFalse41.setQuestionId(question4.getId());
            answerFalse41.setTheAnswer("Is");
            answerFalse41.setStatus(false);
            answerDao.insert(answerFalse41);

            Answer answerFalse42 = new Answer();
            answerFalse42.setId(13);
            answerFalse42.setQuestionId(question4.getId());
            answerFalse42.setTheAnswer("Are");
            answerFalse42.setStatus(false);
            answerDao.insert(answerFalse42);

            Answer answerFalse43 = new Answer();
            answerFalse43.setId(14);
            answerFalse43.setQuestionId(question4.getId());
            answerFalse43.setTheAnswer("**");
            answerFalse43.setStatus(false);
            answerDao.insert(answerFalse43);

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

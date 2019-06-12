package com.dp.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dp.english.model.Answer;
import com.dp.english.model.AnswerDao;
import com.dp.english.model.MyDatabase;
import com.dp.english.model.Question;
import com.dp.english.model.QuestionDao;
import com.dp.english.model.Test;
import com.dp.english.model.TestDao;
import com.dp.english.model.adapter.AnswerAdapter;
import com.dp.english.presenter.taketest.QuestionPojo;
import com.dp.english.presenter.taketest.TakeTestPresenter;
import com.dp.english.presenter.taketest.TestPojo;

import java.util.ArrayList;
import java.util.List;

public class TakeTestActivity extends AppCompatActivity {
    private RecyclerView answerlist;
    private AnswerAdapter  adapter;
    private TextView testName;
    private Test test;
    private RecyclerView recyclerView;

    private TextView nameQuestion;
    private Button nextBtn;

    private TakeTestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test);

        int id = (int) getIntent().getSerializableExtra("test");
        presenter = new TakeTestPresenter(getTest(id));


        nameQuestion = findViewById(R.id.tv_name_question);
        nextBtn = findViewById(R.id.btn_next);
        recyclerView = findViewById(R.id.rv_answers);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initNextQuestion();
            }
        });

        test = getLesson(id);

        testName = findViewById(R.id.tv_testName);
        testName.setText(test.getNameTest());

        initNextQuestion();
    }

    private void initNextQuestion() {
        QuestionPojo questionPojo = presenter.nextQuestion();
        if(questionPojo == null) {
            endTest();
        } else {
            showQuestion(questionPojo);
        }
    }

    private void showQuestion(QuestionPojo questionPojo) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnswerAdapter(questionPojo.getAnswers(), new AnswerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        nameQuestion.setText(questionPojo.getNameQuestion());
        adapter.setData(questionPojo.getAnswers());
    }

    private void endTest() {
        Intent i = new Intent(TakeTestActivity.this, TestChoose.class);
        startActivity(i);
    }

    private Test getLesson(int id) {
        MyDatabase db = App.getInstance().getUserDatabase();
        TestDao testDao = db.getTestDao();
        Test test = testDao.getTest(id);
        return test;
    }

    private TestPojo getTest(int id) {
        Test test = getLesson(id);
        return new TestPojo(test.getNameTest(), getQuestions(test.getId()));
    }

    private List<QuestionPojo> getQuestions(int testId) {
        MyDatabase db = App.getInstance().getUserDatabase();
        QuestionDao questionDao = db.getQuestionDao();
        List<Question> questions = questionDao.getQuestionByIdTest(testId);
        ArrayList<QuestionPojo> questionPojos = new ArrayList<>();

        for(Question question: questions) {
            questionPojos.add(getQuestion(question));
        }
            return questionPojos;
    }

    private QuestionPojo getQuestion(Question question) {
        MyDatabase db = App.getInstance().getUserDatabase();
        AnswerDao answerDao = db.getAnswerDao();
        List<Answer> answers = answerDao.getAnswersByIdQuestion(question.getId());

        // TODO вытяни ответы

        return new QuestionPojo(question.getTheQustion(), answers);
    }

}

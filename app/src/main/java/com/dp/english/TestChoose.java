package com.dp.english;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dp.english.model.MyDatabase;
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
//    insertData();
    showTests();
    }

    private void insertData(){
        MyDatabase db = App.getInstance().getUserDatabase();
        TestDao testDao = db.getTestDao();
        Test test = new Test();
        test.setId(2);
        test.setNameTest("-ка");
        testDao.insert(test);
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

            }
        });
        testList.setAdapter(adapter);
    }
}

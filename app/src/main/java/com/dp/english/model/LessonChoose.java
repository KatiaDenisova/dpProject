package com.dp.english.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dp.english.App;
import com.dp.english.R;
import com.dp.english.model.adapter.LessonsApater;

import java.util.List;

public class LessonChoose extends AppCompatActivity {
private RecyclerView lessonList;
private LessonsApater apater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_choose);

        lessonList = findViewById(R.id.rv_lesson_list);

        showLessons();
    }
    private void insertData(){
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lesson.setNameFile("ten_Rules.png");
        lesson.setNameLesson("10 основных правил");
        lesson.setLevel(Level.EASY);
        lessonDao.insert(lesson);
    }

    private List<Lesson> getLessons(){
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        List<Lesson> list = lessonDao.getLessons();
        return list;
    }
    private void showLessons(){
        lessonList.setLayoutManager(new LinearLayoutManager(this));
        apater = new LessonsApater(getLessons());
        lessonList.setAdapter(apater);
    }
}

package com.dp.english.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dp.english.App;
import com.dp.english.R;
import com.dp.english.model.adapter.LessonsApater;
import com.dp.english.presenter.MainActivity;
import com.dp.english.presenter.UserHello;

import java.io.Serializable;
import java.util.List;

public class LessonChoose extends AppCompatActivity {
    private RecyclerView lessonList;
    private LessonsApater apater;
    private Button takeLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_choose);

        lessonList = findViewById(R.id.rv_lesson_list);
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
//        lessonDao.deleteList(lessonDao.getLessons());
//     insertData();
        showLessons();
    }

    private void insertData() {
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lesson.setNameFile("ten_Rules.pdf");
        lesson.setNameLesson("10 основных правил");
        lesson.setLevel(Level.EASY);
        lessonDao.insert(lesson);
        Lesson lesson1 = new Lesson();
        lesson1.setId(2);
        lesson1.setNameFile("present_continuous.pdf");
        lesson1.setNameLesson("Present Continuous");
        lesson1.setLevel(Level.EASY);
        lessonDao.insert(lesson1);

    }
    private void delete(){
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        lessonDao.delete(lessonDao.getLessonById(1));
    }

    private List<Lesson> getLessons() {
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        List<Lesson> list = lessonDao.getLessons();
        return list;
    }

    private Lesson getLesson(int id) {
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        Lesson lesson = lessonDao.getLessonById(id);
        return lesson;
    }

    private void showLessons() {
        lessonList.setLayoutManager(new LinearLayoutManager(this));
        apater = new LessonsApater(getLessons(), new LessonsApater.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Lesson item = apater.getItem(position);

                if (item != null) {
                    Intent i = new Intent(LessonChoose.this, TakeLesson.class);
                    i.putExtra("lesson",  item.getId());
                    startActivity(i);

                }
                else Toast.makeText(LessonChoose.this, "No lessons", Toast.LENGTH_SHORT).show();
            }
        });
        lessonList.setAdapter(apater);
    }
}

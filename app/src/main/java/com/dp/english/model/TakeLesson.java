package com.dp.english.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dp.english.App;
import com.dp.english.R;
import com.github.barteksc.pdfviewer.PDFView;

public class TakeLesson extends AppCompatActivity {
    private Lesson lesson;
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_lesson);
        int id = (int) getIntent().getSerializableExtra("lesson");
        lesson = getLesson(id);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(lesson.getNameFile())
                .load();
    }

    private Lesson getLesson(int id) {
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        Lesson lesson = lessonDao.getLessonById(id);
        return lesson;
    }
}

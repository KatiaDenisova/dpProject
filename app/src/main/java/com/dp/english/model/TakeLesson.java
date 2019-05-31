package com.dp.english.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dp.english.App;
import com.dp.english.R;
import com.dp.english.presenter.MainActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class TakeLesson extends AppCompatActivity {
    private Lesson lesson;
    PDFView pdfView;
    private Button understand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_lesson);
        int id = (int) getIntent().getSerializableExtra("lesson");
        lesson = getLesson(id);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset(lesson.getNameFile())
                .load();

        understand = findViewById(R.id.bt_understand);
        understand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TakeLesson.this, LessonChoose.class );
                startActivity(i);

            }
        });
    }

    private Lesson getLesson(int id) {
        MyDatabase db = App.getInstance().getUserDatabase();
        LessonDao lessonDao = db.getLessonDao();
        Lesson lesson = lessonDao.getLessonById(id);
        return lesson;
    }
}

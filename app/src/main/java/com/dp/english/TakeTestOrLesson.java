package com.dp.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dp.english.model.LessonChoose;

public class TakeTestOrLesson extends AppCompatActivity {
    private ImageView test;
    private ImageView learnig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_test_or_lesson);

        test = findViewById(R.id.iv_take_test);
        learnig = findViewById(R.id.iv_learning);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TakeTestOrLesson.this, TestChoose.class));
            }
        });
        learnig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TakeTestOrLesson.this, LessonChoose.class));
            }
        });

    }


}

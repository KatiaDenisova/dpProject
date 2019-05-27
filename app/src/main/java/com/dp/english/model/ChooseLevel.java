package com.dp.english.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dp.english.R;

public class ChooseLevel extends AppCompatActivity {
    Button takeLesson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);

        takeLesson = findViewById(R.id.bt_easy);
        takeLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseLevel.this, LessonChoose.class));
                finish();
            }
        });
    }
}

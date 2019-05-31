package com.dp.english.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dp.english.R;

public class ChooseLevel extends AppCompatActivity {
    Button takeLesson;
    TextView name;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_level);
        name = findViewById(R.id.tv_nameUser);
        user = (User) getIntent().getSerializableExtra("User");
        if(user!=null) {
            name.setText(user.getName());
        }
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

package com.dp.english.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dp.english.R;
import com.dp.english.model.ChooseLevel;
import com.dp.english.model.User;

public class UserHello extends AppCompatActivity {
    private TextView tvNameUser;
    private User user;
    private Button btChoose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_hello);
        user = (User) getIntent().getSerializableExtra("User");
        tvNameUser = findViewById(R.id.nameUserHello);

        if(user!=null) {
            tvNameUser.setText(user.getName());
        }
        btChoose = findViewById(R.id.btChooseLevel);
        btChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserHello.this, ChooseLevel.class));
                finish();
            }
        });
    }
}

package com.dp.english;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dp.english.model.User;
import com.dp.english.model.UserDao;
import com.dp.english.model.UserDatabase;

public class MainActivity extends AppCompatActivity {
    private Button btSignIn;
    private Button btSignUp;
    private EditText edtName;
    private EditText edtPassword;
    private EditText edtEmail;
    private UserDatabase database;

    private UserDao userDao;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        btSignIn = findViewById(R.id.bt_signIn);
        btSignUp = findViewById(R.id.bt_signUp);

        edtName = findViewById(R.id.tv_name);
        edtPassword = findViewById(R.id.tv_password);
        edtEmail = findViewById(R.id.et_email);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!emptyValidation()){
                    User user = userDao.getUser(edtEmail.getText().toString(), edtPassword.getText().toString());
                    if(user==null){
                        User user1 = new User(edtName.getText().toString(),
                                edtEmail.getText().toString(), edtPassword.getText().toString());
                        userDao.insert(user1);
                    }
                }
                }
        });


    }

    private boolean emptyValidation() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) || TextUtils.isEmpty(edtPassword.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}

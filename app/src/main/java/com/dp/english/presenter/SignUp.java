package com.dp.english.presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dp.english.App;
import com.dp.english.R;
import com.dp.english.model.MyDatabase;
import com.dp.english.model.User;
import com.dp.english.model.UserDao;

public class SignUp extends AppCompatActivity {
    private EditText edtName;
    private EditText edtEmail;
    private EditText edtPassword;

    private Button btCancel;
    private Button btRegister;

    private UserDao userDao;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        edtName = findViewById(R.id.et_name);
        edtEmail = findViewById(R.id.et_email);
        edtPassword = findViewById(R.id.tv_password);

        btCancel = findViewById(R.id.bt_Cancel);
        btRegister = findViewById(R.id.bt_signUp);

        MyDatabase userDatabase = App.getInstance().getUserDatabase();
        userDao = userDatabase.getUserDao();

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
                finish();
            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User(edtName.getText().toString(), edtEmail.getText().toString(),edtPassword.getText().toString());
                            userDao.insert(user);
                            progressDialog.dismiss();
                            Intent i = new Intent(SignUp.this,UserHello.class );
                            i.putExtra("User",user);
                            startActivity(i);
                            finish();
                        }
                    },1000);
                } else {
                    Toast.makeText(SignUp.this, "Empty fields",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(edtEmail.getText().toString()) ||
                TextUtils.isEmpty(edtPassword.getText().toString()) ||
                TextUtils.isEmpty(edtName.getText().toString())
        ) {
            return true;
        } else {
            return false;
        }
    }
}

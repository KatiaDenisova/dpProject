package com.dp.english.presenter;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
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

public class MainActivity extends AppCompatActivity {
    private Button btSignIn;
    private Button btSignUp;
    private EditText edtPassword;
    private EditText edtEmail;


    private UserDao userDao;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        MyDatabase userDatabase = App.getInstance().getUserDatabase();
        userDao = userDatabase.getUserDao();

        btSignIn = findViewById(R.id.bt_signIn);
        btSignUp = findViewById(R.id.btRegister);


        edtPassword = findViewById(R.id.tv_password);
        edtEmail = findViewById(R.id.et_email);

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emptyValidation()) {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(edtEmail.getText().toString(),edtPassword.getText().toString());
                            if(user!=null) {
                                Intent i = new Intent(MainActivity.this,UserHello.class );
                                i.putExtra("User",user);
                                startActivity(i);
                                finish();
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    },1000);
                }
                else {
                    Toast.makeText(MainActivity.this,"Empty fields", Toast.LENGTH_SHORT).show();
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

package com.dp.english.presenter;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.dp.english.App;
import com.dp.english.R;
import com.dp.english.model.ChooseLevel;
import com.dp.english.model.MyDatabase;
import com.dp.english.model.User;
import com.dp.english.model.UserDao;

public class MainActivity extends AppCompatActivity {
    private Button btSignIn;
    private Button btSignUp;
    private EditText edtPassword;
    private EditText edtEmail;
    private ImageView showPass;
    private ImageView passwordIcon;
    private boolean needToHidePassword = true;

    private UserDao userDao;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
        showPass = findViewById(R.id.fl_show_pass);
        passwordIcon = findViewById(R.id.fl_pass_ic);

        edtPassword = findViewById(R.id.tv_password);
        edtEmail = findViewById(R.id.et_email);

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    showPass.setVisibility(View.VISIBLE);
                } else {
                    showPass.setVisibility(View.GONE);
                }
            }
        });

        showPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                needToHidePassword = !needToHidePassword;
                edtPassword.setInputType(needToHidePassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                edtPassword.setSelection(edtPassword.getText().length());
                showPass.setImageResource(!needToHidePassword ? R.drawable.ic_eye : R.drawable.ic_eye_off);
            }
        });

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
                                Intent i = new Intent(MainActivity.this, ChooseLevel.class );
                                i.putExtra("User",user);
                                startActivity(i);

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

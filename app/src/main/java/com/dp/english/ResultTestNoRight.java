package com.dp.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultTestNoRight extends AppCompatActivity {
private Button back;
private TextView tv_percent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test_no_right);
        int percent = (int) getIntent().getSerializableExtra("percent");

        tv_percent = findViewById(R.id.textView4);
        tv_percent.setText(percent+"%");
         back= findViewById(R.id.backToTestList1);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(ResultTestNoRight.this, TestChoose.class );
                 startActivity(i);
                 finish();
             }
         });
    }
}

package com.dp.english;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultTestNoRight extends AppCompatActivity {
private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_test_no_right);
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

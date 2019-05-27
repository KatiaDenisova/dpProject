package com.dp.english.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dp.english.R;
import com.github.barteksc.pdfviewer.PDFView;

public class TakeLesson extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_lesson);

        pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("ten_Rules.pdf")
                .load();


    }
}

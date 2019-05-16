package com.dp.english.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
@ForeignKey(entity = Test.class, parentColumns = "id",childColumns = "test_id")
public class Question {
    @PrimaryKey
    private int id;
    
    public Question(int id, String theQustion, int testId) {
        this.id = id;
        this.theQustion = theQustion;
        this.testId = testId;
    }

    private String theQustion;

    @ColumnInfo(name = "test_id")
    private int testId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheQustion() {
        return theQustion;
    }

    public void setTheQustion(String theQustion) {
        this.theQustion = theQustion;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
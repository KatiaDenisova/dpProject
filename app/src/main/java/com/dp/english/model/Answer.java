package com.dp.english.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity
@ForeignKey(entity = Question.class, parentColumns = "id", childColumns = "question_id")
public class Answer {
    @PrimaryKey
    private int id;

    private String theAnswer;

    @ColumnInfo(name = "question_id")
    private int questionId;
    

    public Answer(int id, String theAnswer, int questionId) {
        this.id = id;
        this.theAnswer = theAnswer;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheAnswer() {
        return theAnswer;
    }

    public void setTheAnswer(String theAnswer) {
        this.theAnswer = theAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}

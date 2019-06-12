package com.dp.english.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface AnswerDao {
    @Query("Select * from Answer where id= :id")
    Answer getAnswer(int id);

    @Query("Select * from Answer where id= :idQuestion")
    List<Answer> getAnswersByIdQuestion(int idQuestion);

    @Insert
    void insert(Answer answer);

    @Update
    void update(Answer answer);

    @Delete
    void delete(Answer answer);
}

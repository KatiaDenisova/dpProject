package com.dp.english.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("Select * from Question")
    List<Question> getQuestions();

    @Query("Select * from Question where id = :id")
    Question getQuestion(int id);
    @Query("select * from Question where test_id = :idTest")
    List<Question> getQuestionByIdTest(int idTest);

    @Insert
    void insert(Question question);

    @Insert
    void insertList(List<Question> questions);

    @Delete
    void delete(Question Question);

    @Delete
    void deleteList(List<Question> list);

    @Update
    void update(Question question);

    @Update
    void update(List<Question> list);
}


package com.dp.english.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LessonDao {


    @Query("Select * from Lesson")
    List<Lesson> getLessons();

    @Insert
    void insert(Lesson lesson);

    @Insert
    void insertList(List<Lesson> lessons);

    @Delete
    void delete(Lesson lesson);

    @Update
    void update(Lesson lesson);

    @Update
    void updateList(List<Lesson> lessons);
}

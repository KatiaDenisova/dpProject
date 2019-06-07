package com.dp.english.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TestDao {
    @Query("Select * from Test")
    List<Test> getTests();

    @Query("Select * from Test where nameTest = :name")
    Test getTest(String name);

    @Insert
    void insert(Test test);

    @Insert
    void insertList(List<Test> tests);

    @Delete
    void delete(Test test);

    @Delete
    void deleteList(List<Test> list);

    @Update
    void update(Test test);

    @Update
    void update(List<Test> list);
}

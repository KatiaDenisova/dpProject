package com.dp.english.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class , Answer.class}, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract AnswerDao getAnswerDao();
}

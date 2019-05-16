package com.dp.english.model;

import android.arch.persistence.room.RoomDatabase;

public abstract class Database extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract AnswerDao getAnswerDao();
}

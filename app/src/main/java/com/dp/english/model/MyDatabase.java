package com.dp.english.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.dp.english.model.convert.ConvertLevel;

@TypeConverters(ConvertLevel.class)
@Database(entities = {User.class , Answer.class, Lesson.class, Test.class, Question.class}, version = 2, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract LessonDao getLessonDao();
    public abstract AnswerDao getAnswerDao();
    public abstract TestDao getTestDao();
    public abstract QuestionDao getQuestionDao();

}

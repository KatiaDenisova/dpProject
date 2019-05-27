package com.dp.english.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.dp.english.model.convert.ConvertLevel;

@TypeConverters(ConvertLevel.class)
@Entity

public class Lesson {
    @PrimaryKey
    private int id;
    private String nameLesson;
    private String nameFile;



    public Level level;

    public Lesson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    @Ignore
    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", nameLesson='" + nameLesson + '\'' +
                ", nameFile='" + nameFile + '\'' +
                '}';
    }
}

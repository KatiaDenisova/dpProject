package com.dp.english.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.dp.english.model.convert.ConvertLevel;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@TypeConverters(ConvertLevel.class)
@Entity
@Root
public class Lesson {
    @PrimaryKey
    @Element
    private int id;
    @Element
    private String nameLesson;
    @Element
    private String nameFile;
    @Element
    public Level level;

    public void setLevel(Level level) {
        this.level = level;
    }

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

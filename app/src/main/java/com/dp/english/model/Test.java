package com.dp.english.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Test {
    @PrimaryKey
    private int id;
    private String nameTest;


}
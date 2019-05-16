package com.dp.english;

import android.app.Application;
import android.arch.persistence.room.Room;


import com.dp.english.model.MyDatabase;

public class App extends Application {
    public static App instance;

    private MyDatabase userDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        userDatabase = Room.databaseBuilder(this, MyDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public MyDatabase getUserDatabase() {
        return userDatabase;
    }
}
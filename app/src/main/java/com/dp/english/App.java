package com.dp.english;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.dp.english.model.Database;

public class App extends Application {
    public static App instance;

    private Database userDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        userDatabase = Room.databaseBuilder(this, Database.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public Database getUserDatabase() {
        return userDatabase;
    }
}
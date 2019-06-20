package com.dp.english.model.convert;

import android.arch.persistence.room.TypeConverter;

import com.dp.english.model.Level;

public class ConvertLevel {

    @TypeConverter
    public String fromLevel(Level level) {
        return level.name();
    }

    @TypeConverter
    public Level fromString(String stLevel) {
        for(Level ds : Level.values()){
            if(ds.name() == stLevel){
                return ds;
            }
        }
        return null;
    }
}


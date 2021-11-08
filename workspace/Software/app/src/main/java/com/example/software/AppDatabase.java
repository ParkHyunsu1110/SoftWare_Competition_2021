package com.example.software;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {GraphInfo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract GraphInfoDAO graphInfoDAO();
}

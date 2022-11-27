package com.example.breye.Data.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.breye.Data.Lettre;

@Database(entities = {Lettre.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LettreDAO lettreDAO();

}

package com.example.breye.Data.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.breye.Data.Lettre;

import java.util.List;

@Dao
public interface LettreDAO {
    @Query("SELECT * FROM lettre")
    List<Lettre> getAll();

    @Insert
    void insert(Lettre lettre);

    @Insert
    long[] insertAll(Lettre... lettres);

    @Delete
    void delete(Lettre lettre);

    @Update
    void update(Lettre lettre);
}

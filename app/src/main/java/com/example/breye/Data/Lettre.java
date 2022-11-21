package com.example.breye.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.lang.reflect.Array;

@Entity
public class Lettre implements Serializable {
    //Attributs
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "lettre")
    private char lettre;
    @ColumnInfo(name = "lettreBraille")
    private long lettreBraille;

    //Setteurs

    public void setId(int id) {
        this.id = id;
    }

    public void setLettre(char lettre) {
        this.lettre = lettre;
    }

    public void setLettreBraille(long lettreBraille) {
        this.lettreBraille = lettreBraille;
    }

    //Getteurs

    public int getId() {
        return id;
    }

    public char getLettre() {
        return lettre;
    }

    public long getLettreBraille() {
        return lettreBraille;
    }
}

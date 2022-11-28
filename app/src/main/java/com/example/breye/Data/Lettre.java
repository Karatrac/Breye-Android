package com.example.breye.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Lettre implements Serializable {
    //Attributs
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "lettre")
    private String lettre;
    @ColumnInfo(name = "l1")
    private boolean l1;
    @ColumnInfo(name = "l2")
    private boolean l2;
    @ColumnInfo(name = "l3")
    private boolean l3;
    @ColumnInfo(name = "l4")
    private boolean l4;
    @ColumnInfo(name = "l5")
    private boolean l5;
    @ColumnInfo(name = "l6")
    private boolean l6;

    //Setteurs

    public void setId(int id) {
        this.id = id;
    }

    public void setLettre(String lettre) {
        this.lettre = lettre;
    }

    public void setL1(boolean l1) {
        this.l1 = l1;
    }

    public void setL2(boolean l2) {
        this.l2 = l2;
    }

    public void setL3(boolean l3) {
        this.l3 = l3;
    }

    public void setL4(boolean l4) {
        this.l4 = l4;
    }

    public void setL5(boolean l5) {
        this.l5 = l5;
    }

    public void setL6(boolean l6) {
        this.l6 = l6;
    }

    //Getteurs

    public int getId() {
        return id;
    }

    public String getLettre() {
        return lettre;
    }

    public boolean isL1() {
        return l1;
    }

    public boolean isL2() {
        return l2;
    }

    public boolean isL3() {
        return l3;
    }

    public boolean isL4() {
        return l4;
    }

    public boolean isL5() {
        return l5;
    }

    public boolean isL6() {
        return l6;
    }
}

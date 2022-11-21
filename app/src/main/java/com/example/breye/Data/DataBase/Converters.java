package com.example.breye.Data.DataBase;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Classe qui permet la conversion des type de donnée de la classe Eleve
 * -> en format JSON/String pour la BD
 */
public class Converters implements Serializable {
    @TypeConverter
    public static ArrayList<String> toArrayList(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


}

package com.example.breye.Data.DataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


public class DatabaseClient {

    // Instance unique permettant de faire le lien avec la base de données
    private static DatabaseClient instance;

    // Objet représentant la base de données dans l'application
    private AppDatabase appDatabase;

    // Constructeur
    private DatabaseClient(final Context context) {

        // Créer l'objet représentant la base de données de votre application
        // à l'aide du "Room database builder"
        // Ajout de la méthode addCallback permettant de populate (remplir) la base de données à sa création
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "Breye").addCallback(roomDatabaseCallback).build();  }

    // Méthode statique
    // Retourne l'instance de l'objet DatabaseClient
    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    // Retourne l'objet représentant la base de données de votre application
    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // Objet permettant de populate (remplir) la base de données à sa création
    RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {

        // Called when the database is created for the first time.
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('A',1,0,0,0,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('B',1,0,1,0,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('C',1,1,0,0,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('D',1,1,0,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('E',1,0,0,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('F',1,1,1,0,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('G',1,1,1,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('H',1,0,1,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('I',0,1,0,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('J',0,1,1,1,0,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('K',1,0,0,0,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('L',1,0,1,0,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('M',1,1,0,0,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('N',1,1,0,1,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('O',1,0,0,1,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('P',1,1,1,0,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('Q',1,1,1,1,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('R',1,0,1,1,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('S',0,1,1,0,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('T',0,1,1,1,1,0)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('U',1,0,0,0,1,1)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('V',1,0,1,0,1,1)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('W',0,1,1,1,0,1)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('X',1,1,0,0,1,1)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('Y',1,1,0,1,1,1)");
            db.execSQL("INSERT INTO lettre (lettre, l1, l2, l3, l4,l5,l6) VALUES('Z',1,0,0,1,1,1)");
        }
    };
}

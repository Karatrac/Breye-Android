package com.example.breye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.breye.Data.DataBase.DatabaseClient;
import com.example.breye.Data.Lettre;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    //Attributs
    ImageButton buttonplay,buttonlist,buttonsettings,buttonupload,buttontuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Initialisation de la base de données
        mDb = DatabaseClient.getInstance(getApplicationContext());
        getLettres();


        //Récupération des boutons
         buttonplay = findViewById(R.id.play);
         buttonlist = findViewById(R.id.list);
         buttonsettings = findViewById(R.id.settings);
         buttonupload = findViewById(R.id.upload);
         buttontuto = findViewById(R.id.tuto);


        //Event listener
        buttonplay.setOnClickListener(v -> goToPlay());

        buttonlist.setOnClickListener(v -> goToList());

        buttonsettings.setOnClickListener(v -> goToSettings());

        buttonupload.setOnClickListener(v -> goToUpload());

        buttontuto.setOnClickListener(v -> goToTuto());

    }

    //Création des intents
    public void goToSettings() {
        Intent settings = new Intent(this, SettingsActivity.class);
        startActivity(settings);
    }

    public void goToPlay() {
        Intent play = new Intent(this, PlayActivity.class);
        startActivity(play);
    }

    public void goToList() {
        Intent list = new Intent(this, ListActivity.class);
        startActivity(list);
    }

    public void goToUpload() {
        Intent upload = new Intent(this, UploadActivity.class);
        startActivity(upload);
    }

    public void goToTuto() {
        Intent tuto = new Intent(this, TutoActivity.class);
        startActivity(tuto);
    }

    //Récupération des lettres
    private void getLettres() {

        // Classe asynchrone permettant de récupérer des comptes
        class GetLettres extends AsyncTask<Void, Void, List<Lettre>> {

            @Override
            protected List<Lettre> doInBackground(Void... voids) {
                return mDb.getAppDatabase().lettreDAO().getAll();
            }

            @Override
            protected void onPostExecute(final List<Lettre> lettresdb) {
                super.onPostExecute(lettresdb);

                System.out.println(lettresdb.size());
            }
        }

        // Création d'un objet de type GetEleves et execution de la demande asynchrone
        GetLettres gu = new GetLettres();
        gu.execute();

    }

}

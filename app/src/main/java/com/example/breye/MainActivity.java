package com.example.breye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    //Attributs
    ImageButton buttonplay,buttonlist,buttonsettings,buttonupload,buttontuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Récupération des boutons
         buttonplay = findViewById(R.id.play);
         buttonlist = findViewById(R.id.list);
         buttonsettings = findViewById(R.id.settings);
         buttonupload = findViewById(R.id.upload);
         buttontuto = findViewById(R.id.tuto);


        //Event listener
        buttonplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPlay();
            }
        });

        buttonlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToList();
            }
        });

        buttonsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });


        buttonupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUpload();
            }
        });

        buttontuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTuto();
            }
        });

    }

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

}

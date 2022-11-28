package com.example.breye;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.breye.Data.DataBase.DatabaseClient;
import com.example.breye.Data.Lettre;

import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    // Attributs
    ConstraintLayout constraintLayout;
    Button b1, b2, b3, b4, b5, b6;
    private final static int[] STATE_PRESSED = {
        android.R.attr.state_pressed,
        android.R.attr.state_focused
            | android.R.attr.state_enabled};
    private static int[] defaultStates;
    private DatabaseClient mDb;
    private Lettre l;
    TextView tv;
    private List<Lettre> LettreDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        constraintLayout = findViewById(R.id.constraintLayoutPlay);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);

        tv = findViewById(R.id.textLettre);

        constraintLayout.setOnClickListener(v -> RandomLettre());

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        getLettres();


    }


    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.d("Test", Boolean.toString(pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())));
        Toast.makeText(this, "MOVE " + pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()), Toast.LENGTH_SHORT).show();

        if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()) && l.isL1()) {
            vibrate();
        } else if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()) && l.isL1()) {
            vibrate();
        } else if (pointInside(x, y, b2.getLeft(), b2.getRight(), b2.getTop(), b2.getBottom()) && l.isL2()) {
            vibrate();
        } else if (pointInside(x, y, b3.getLeft(), b3.getRight(), b3.getTop(), b3.getBottom()) && l.isL3()) {
            vibrate();
        } else if (pointInside(x, y, b4.getLeft(), b4.getRight(), b4.getTop(), b4.getBottom()) && l.isL4()) {
            vibrate();
        } else if (pointInside(x, y, b5.getLeft(), b5.getRight(), b5.getTop(), b5.getBottom()) && l.isL5()) {
            vibrate();
        } else if (pointInside(x, y, b6.getLeft(), b6.getRight(), b6.getTop(), b6.getBottom()) && l.isL6()) {
            vibrate();
        }

        return true;
    }

    static boolean pointInside(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }

    public void vibrate() {
        // Get instance of Vibrator from current Context
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        long[] pattern = {0, 1000};

        vibrator.vibrate(pattern, -1);
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

                LettreDb = lettresdb;
                System.out.println(LettreDb.size());

                RandomLettre();
            }
        }

        // Création d'un objet de type GetEleves et execution de la demande asynchrone
        GetLettres gu = new GetLettres();
        gu.execute();
    }

    public void initialisationVue() {
        if (l != null) {
            Log.d("Test Lettre", l.getLettre());
            tv.setText(String.valueOf(l.getLettre()));
            if (l.isL1()) {
                b1.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b1.setBackgroundResource(R.drawable.round_button_stroke);
            }

            if (l.isL2()) {
                b2.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b2.setBackgroundResource(R.drawable.round_button_stroke);
            }

            if (l.isL3()) {
                b3.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b3.setBackgroundResource(R.drawable.round_button_stroke);
            }

            if (l.isL4()) {
                b4.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b4.setBackgroundResource(R.drawable.round_button_stroke);
            }

            if (l.isL5()) {
                b5.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b5.setBackgroundResource(R.drawable.round_button_stroke);
            }

            if (l.isL6()) {
                b6.setBackgroundResource(R.drawable.round_button_play);
            } else {
                b6.setBackgroundResource(R.drawable.round_button_stroke);
            }
        }
    }

    public void RandomLettre() {
        Log.d("Test Lettre Apres", l.getLettre());
        Random r = new Random();
        int n = r.nextInt(26);

        l = LettreDb.get(n);
        initialisationVue();
    }

}

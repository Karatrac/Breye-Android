package com.example.breye;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

import com.example.breye.Data.DataBase.DatabaseClient;
import com.example.breye.Data.Lettre;

import java.util.List;

public class PlayActivity extends AppCompatActivity {

    // Attributs
    ConstraintLayout constraintLayout;
    Button b1, b2, b3, b4, b5, b6;
    private DatabaseClient mDb;
    private Lettre l;
    TextView tv;
    private List<Lettre> LettreDb;
    private Boolean bb1, bb2, bb3, bb4, bb5, bb6, nextLettre;
    private int indexL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        // Récupération constraintLayout (tout l'écran)
        constraintLayout = findViewById(R.id.constraintLayoutPlay);

        // Récupération des boutons
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);

        tv = findViewById(R.id.textLettre);
        tv.setVisibility(View.INVISIBLE);

        // Non cliqué
        bb1 = false;
        bb2 = false;
        bb3 = false;
        bb4 = false;
        bb5 = false;
        bb6 = false;


        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Initialisation variable
        indexL = 2;
        nextLettre =false;

        getLettres();
    }


    public boolean dispatchTouchEvent(MotionEvent event) {

        // Click tous les boutons
        if(bb1 && bb2 && bb3 && bb4 && bb5 && bb6){
            tv.setVisibility(View.VISIBLE);
            nextLettre =true;
        }

        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE: {
                // Récupération des coordonnées du point touché
                int x = (int) event.getX();
                int y = (int) event.getY();

                // Si le point est cliqué est remplis
                if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()) && l.isL1()) {
                    vibrate();
                    bb1 = true;
                } else if (pointInside(x, y, b2.getLeft(), b2.getRight(), b2.getTop(), b2.getBottom()) && l.isL2()) {
                    vibrate();
                    bb2 = true;
                } else if (pointInside(x, y, b3.getLeft(), b3.getRight(), b3.getTop(), b3.getBottom()) && l.isL3()) {
                    vibrate();
                    bb3 = true;
                } else if (pointInside(x, y, b4.getLeft(), b4.getRight(), b4.getTop(), b4.getBottom()) && l.isL4()) {
                    vibrate();
                    bb4 = true;
                } else if (pointInside(x, y, b5.getLeft(), b5.getRight(), b5.getTop(), b5.getBottom()) && l.isL5()) {
                    vibrate();
                    bb5 = true;
                } else if (pointInside(x, y, b6.getLeft(), b6.getRight(), b6.getTop(), b6.getBottom()) && l.isL6()) {
                    vibrate();
                    bb6 = true;
                } else if (pointInside(x, y, tv.getLeft(), tv.getRight(), tv.getTop(), tv.getBottom()) && nextLettre) {
                    RandomLettre();
                }

                // Si le point est cliqué mais pas remplis
                if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()) && !l.isL1()) {
                    bb1 = true;
                } else if (pointInside(x, y, b2.getLeft(), b2.getRight(), b2.getTop(), b2.getBottom()) && !l.isL2()) {
                    bb2 = true;
                } else if (pointInside(x, y, b3.getLeft(), b3.getRight(), b3.getTop(), b3.getBottom()) && !l.isL3()) {
                    bb3 = true;
                } else if (pointInside(x, y, b4.getLeft(), b4.getRight(), b4.getTop(), b4.getBottom()) && !l.isL4()) {
                    bb4 = true;
                } else if (pointInside(x, y, b5.getLeft(), b5.getRight(), b5.getTop(), b5.getBottom()) && !l.isL5()) {
                    bb5 = true;
                } else if (pointInside(x, y, b6.getLeft(), b6.getRight(), b6.getTop(), b6.getBottom()) && !l.isL6()) {
                    bb6 = true;
                }

                // One touch button
              /*  if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()) && l.isL1() && !bb1) {
                    Log.d("Test 1", l.getLettre());
                    vibrate();
                    bb1 = true;
                } else if (pointInside(x, y, b2.getLeft(), b2.getRight(), b2.getTop(), b2.getBottom()) && l.isL2() && !bb2) {
                    Log.d("Test 2", l.getLettre());
                    vibrate();
                    bb2 = true;
                } else if (pointInside(x, y, b3.getLeft(), b3.getRight(), b3.getTop(), b3.getBottom()) && l.isL3() && !bb3) {
                    Log.d("Test 3", l.getLettre());
                    vibrate();
                    bb3 = true;
                } else if (pointInside(x, y, b4.getLeft(), b4.getRight(), b4.getTop(), b4.getBottom()) && l.isL4() && !bb4) {
                    Log.d("Test 4", l.getLettre());
                    vibrate();
                    bb4 = true;
                } else if (pointInside(x, y, b5.getLeft(), b5.getRight(), b5.getTop(), b5.getBottom()) && l.isL5() && !bb5) {
                    Log.d("Test 5", l.getLettre());
                    vibrate();
                    bb5 = true;
                } else if (pointInside(x, y, b6.getLeft(), b6.getRight(), b6.getTop(), b6.getBottom()) && l.isL6() && !bb6) {
                    Log.d("Test 6", l.getLettre());
                    vibrate();
                    bb6 = true;
                } else if (pointInside(x, y, tv.getLeft(), tv.getRight(), tv.getTop(), tv.getBottom())) {
                    RandomLettre();
                }*/

            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
        }


        return true;
    }

    // Fonction pour voir si le point est dans un obet de la vue
    static boolean pointInside(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }

    // Vibration du téléphone
    public void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //long[] pattern = {0, 500};
        long[] pattern = {0, 70};

        vibrator.vibrate(pattern, -1);
    }

    //Récupération des lettres
    private void getLettres() {

        // Classe asynchrone permettant de récupérer des comptes
        //TODO mise à jour possible de la tâche asynchrone car deprecated
         class GetLettres extends AsyncTask<Void, Void, List<Lettre>> {

            @Override
            protected List<Lettre> doInBackground(Void... voids) {
                return mDb.getAppDatabase().lettreDAO().getAll();
            }

            @Override
            protected void onPostExecute(final List<Lettre> lettresdb) {
                super.onPostExecute(lettresdb);

                LettreDb = lettresdb;
                // OnClick ne marche pas car on modifie le touchEvent en dispatch
                //tv.setOnClickListener(v -> RandomLettre());
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

        bb1 = false;
        bb2 = false;
        bb3 = false;
        bb4 = false;
        bb5 = false;
        bb6 = false;

        tv.setVisibility(View.INVISIBLE);
    }

    public void RandomLettre() {

        // Affichage aléatoire des lettres
       /* Random r = new Random();
        int n = r.nextInt(26);*/

        nextLettre=false;
        indexABC();
        l = LettreDb.get(indexL);

        initialisationVue();
    }


    // Restreindre l'affichage aux lettres ABC pour le test
    public void indexABC() {
        if (indexL < 2) {
            indexL++;
        } else {
            indexL = 0;
        }
    }

}

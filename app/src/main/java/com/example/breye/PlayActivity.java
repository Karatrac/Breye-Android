package com.example.breye;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.Toast;

import com.example.breye.Data.DataBase.DatabaseClient;
import com.example.breye.Data.Lettre;

import java.util.List;

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

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

    }


    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.d("Test", Boolean.toString(pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())));
        Toast.makeText(this, "MOVE " + pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()), Toast.LENGTH_SHORT).show();

        if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b2.getLeft(), b2.getRight(), b2.getTop(), b2.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b3.getLeft(), b3.getRight(), b3.getTop(), b3.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b4.getLeft(), b4.getRight(), b4.getTop(), b4.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b5.getLeft(), b5.getRight(), b5.getTop(), b5.getBottom())) {
            vibrate();
        } else if (pointInside(x, y, b6.getLeft(), b6.getRight(), b6.getTop(), b6.getBottom())) {
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

                System.out.println(lettresdb.size());
                
            }
        }

        // Création d'un objet de type GetEleves et execution de la demande asynchrone
        GetLettres gu = new GetLettres();
        gu.execute();

    }

}

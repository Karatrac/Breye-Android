package com.example.breye;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {

    // Attributs
    ConstraintLayout constraintLayout;
    Button b1;
    private final static int[] STATE_PRESSED = {
        android.R.attr.state_pressed,
        android.R.attr.state_focused
            | android.R.attr.state_enabled};
    private static int defaultStates[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayoutPlay);

        b1 = findViewById(R.id.button1);

    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        Log.d("Test", Boolean.toString(pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())));
        Toast.makeText(this, "MOVE " + pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom()), Toast.LENGTH_SHORT).show();

        if (!pointInside(x, y, b1.getLeft(), b1.getRight(), b1.getTop(), b1.getBottom())) {
            b1.getBackground().setState(defaultStates);
        } else {
            b1.getBackground().setState(STATE_PRESSED);
            // Get instance of Vibrator from current Context
            Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            long[] pattern = {0, 1000};

            vibrator.vibrate(pattern, -1);
        }

        return true;


    }

    static boolean pointInside(int x, int y, int x1, int x2, int y1, int y2) {
        return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
    }
}

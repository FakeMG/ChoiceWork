package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.WaitingBoardModel;

import java.util.Locale;

public class WaitingBoardActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;

    private ImageView waitingBoardIv;

    private TextView textViewCountDown;
    private Button buttonStartPause;
    private Button buttonReset;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;

    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_board);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        waitingBoardIv = findViewById(R.id.waiting_img_activity);
        WaitingBoardModel waitingBoardModel = (WaitingBoardModel) bundle.get("waiting_board");
        waitingBoardIv.setImageResource(waitingBoardModel.getResourceImage());

        textViewCountDown = findViewById(R.id.text_view_countdown);
        buttonStartPause = findViewById(R.id.button_start_pause);
        buttonReset = findViewById(R.id.button_reset);

        buttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning) {
                    pauseTimer();
                }
                else {
                    startTimer();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                buttonStartPause.setText("Start");
                buttonStartPause.setVisibility(View.INVISIBLE);
                buttonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        timerRunning = true;
        buttonStartPause.setText("Pause");
        buttonReset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        textViewCountDown.setText(timeLeft);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        buttonStartPause.setText("Start");
        buttonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        buttonStartPause.setVisibility(View.VISIBLE);
        buttonReset.setVisibility(View.INVISIBLE);
    }

}
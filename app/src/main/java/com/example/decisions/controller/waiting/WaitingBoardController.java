package com.example.decisions.controller.waiting;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.decisions.R;
import com.example.decisions.view.activity.WaitingBoardActivity;

import java.util.Locale;

public class WaitingBoardController {

    private WaitingBoardActivity waitingBoardActivity;

    private EditText editTimerInput;
    private TextView editTimer;

    private TextView textViewCountDown;
    private Button buttonStartPause;
    private Button buttonReset;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;

    private long startTimeInMillis = 600000;
    private long timeLeftInMillis = startTimeInMillis;

    public WaitingBoardController(WaitingBoardActivity waitingBoardActivity) {
        this.waitingBoardActivity = waitingBoardActivity;
    }


    public void runTimer() {
        editTimerInput = waitingBoardActivity.findViewById(R.id.edit_timer_input);
        editTimer = waitingBoardActivity.findViewById(R.id.edit_timer);

        textViewCountDown = waitingBoardActivity.findViewById(R.id.text_view_countdown);
        buttonStartPause = waitingBoardActivity.findViewById(R.id.button_start_pause);
        buttonReset = waitingBoardActivity.findViewById(R.id.button_reset);

        editTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTimer.getText().toString().equals("Edit timer")) {
                    editTimerInput.setVisibility(View.VISIBLE);
                    editTimer.setText("Save timer");
                }
                else {
                    String input = editTimerInput.getText().toString();
                    if (input.length() == 0) {
                        Toast.makeText(waitingBoardActivity, "Field can't be empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    long millisInput = Long.parseLong(input) * 60000;
                    if (millisInput == 0) {
                        Toast.makeText(waitingBoardActivity, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    setTime(millisInput);
                    editTimerInput.setText("");
                    editTimer.setText("Edit timer");
                    //closeKeyboard();
                }
            }
        });

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

    /*private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }*/

    private void setTime(long millis) {
        startTimeInMillis = millis;
        resetTimer();
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
        resetEditTimer();
        editTimer.setEnabled(false);
        editTimer.setTextColor(waitingBoardActivity.getResources().getColor(R.color.gray_disabled));
        buttonStartPause.setText("Pause");
        buttonReset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((timeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeft;
        if (hours > 0) {
            timeLeft = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds);
        }
        else {
            timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        }
        textViewCountDown.setText(timeLeft);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        editTimer.setEnabled(true);
        editTimer.setTextColor(waitingBoardActivity.getResources().getColor(R.color.black));
        buttonStartPause.setText("Start");
        buttonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMillis = startTimeInMillis;
        resetEditTimer();
        updateCountDownText();
        buttonStartPause.setVisibility(View.VISIBLE);
        buttonReset.setVisibility(View.INVISIBLE);
    }

    private void resetEditTimer() {
        editTimerInput.setVisibility(View.INVISIBLE);
        editTimer.setText("Edit timer");
        editTimer.setEnabled(true);
        editTimer.setTextColor(waitingBoardActivity.getResources().getColor(R.color.black));
    }
}

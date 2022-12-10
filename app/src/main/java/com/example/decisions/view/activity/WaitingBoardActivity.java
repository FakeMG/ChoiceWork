package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.decisions.R;
import com.example.decisions.controller.waiting.WaitingBoardController;
import com.example.decisions.model.WaitingBoardModel;

public class WaitingBoardActivity extends AppCompatActivity {

    private ImageView waitingBoardIv;



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

        WaitingBoardController waitingBoardController = new WaitingBoardController(this);

        waitingBoardController.runTimer();
    }



}
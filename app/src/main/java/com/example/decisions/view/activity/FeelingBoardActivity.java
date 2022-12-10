package com.example.decisions.view.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.decisions.R;
import com.example.decisions.controller.feeling.FeelingBoardController;
import com.example.decisions.model.FeelingBoardModel;

public class FeelingBoardActivity extends AppCompatActivity {

    private ImageView waitingBoardIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeling_board);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        waitingBoardIv = findViewById(R.id.feeling_img_activity);
        FeelingBoardModel feelingBoardModel = (FeelingBoardModel) bundle.get("feeling_board");
        waitingBoardIv.setImageResource(feelingBoardModel.getResourceImage());

        FeelingBoardController feelingBoardController = new FeelingBoardController(this);

    }



}
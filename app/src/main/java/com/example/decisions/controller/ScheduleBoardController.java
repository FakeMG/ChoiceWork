package com.example.decisions.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleBoardModel;

public class ScheduleBoardController {
    private View view;
    private Bundle bundle;

    public ScheduleBoardController(View view, Bundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }

    public void setData() {
        if (bundle != null) {
            TextView scheduleBoardTv = view.findViewById(R.id.schedule_name_activity);
            ImageView scheduleBoardIv = view.findViewById(R.id.schedule_img_activity);
            ScheduleBoardModel scheduleBoardModel = (ScheduleBoardModel) bundle.get("schedule_board");
            if (scheduleBoardModel != null) {
                scheduleBoardTv.setText(scheduleBoardModel.getName());
                scheduleBoardIv.setImageResource(scheduleBoardModel.getResourceImage());
            }
        }
    }
}

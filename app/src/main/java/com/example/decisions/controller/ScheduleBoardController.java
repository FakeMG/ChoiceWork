package com.example.decisions.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleActionModel;
import com.example.decisions.model.ScheduleBoardModel;

import java.util.ArrayList;

public class ScheduleBoardController {
    private View view;
    private Bundle bundle;
    private Context context;
    private ArrayList<ScheduleActionModel> listActionSchedule;

    public ScheduleBoardController(View view, Bundle bundle) {
        this.view = view;
        this.bundle = bundle;
    }

    public ScheduleBoardController(Context context) {
        this.context = context;
    }

    public void dataInitialize() {
        listActionSchedule = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            listActionSchedule.add(new ScheduleActionModel("Schedule action " + i, R.drawable.learning_01, R.drawable.ic_baseline_double_arrow_right, R.drawable.work_out_01));
        }
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

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ScheduleActionModel> getListActionSchedule() {
        return listActionSchedule;
    }

    public void setListActionSchedule(ArrayList<ScheduleActionModel> listActionSchedule) {
        this.listActionSchedule = listActionSchedule;
    }
}

package com.example.decisions.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleItemModel;
import com.example.decisions.view.activity.ScheduleActivity;

import java.util.ArrayList;

public class ScheduleController {
    private Context context;
    private ArrayList<ScheduleItemModel> listSchedule;

    public ScheduleController(Context context) {
        this.context = context;
        this.listSchedule = new ArrayList<>();
        dataInitialize();
    }

    public void onClickGoToActivity(ScheduleItemModel scheduleItemModel) {
        Intent intent = new Intent(context, ScheduleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("schedule_item", scheduleItemModel);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private ArrayList<ScheduleItemModel> dataInitialize() {
        for (int i = 1; i <= 13; i++) {
            listSchedule.add(new ScheduleItemModel("Schedule " + i, R.drawable.ic_launcher_background));
        }

        return listSchedule;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ScheduleItemModel> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(ArrayList<ScheduleItemModel> listSchedule) {
        this.listSchedule = listSchedule;
    }
}

package com.example.decisions.controller;

import android.content.Context;
import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleBoardModel;

import java.util.ArrayList;

public class ScheduleFragmentController {
    private Context context;
    private ArrayList<ScheduleBoardModel> listSchedule;
    private Bundle bundleScheduleItem;

    public ScheduleFragmentController(Context context) {
        this.context = context;
        this.listSchedule = new ArrayList<>();
        this.bundleScheduleItem = new Bundle();
        dataInitialize();
    }

    public void onClickGoToBoard(ScheduleBoardModel scheduleBoardModel) {
        bundleScheduleItem.putSerializable("schedule_board", scheduleBoardModel);
    }

    private ArrayList<ScheduleBoardModel> dataInitialize() {
        for (int i = 1; i <= 13; i++) {
            listSchedule.add(new ScheduleBoardModel("Schedule " + i, R.drawable.ic_launcher_background));
        }

        return listSchedule;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ScheduleBoardModel> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(ArrayList<ScheduleBoardModel> listSchedule) {
        this.listSchedule = listSchedule;
    }

    public Bundle getBundleScheduleItem() {
        return bundleScheduleItem;
    }

    public void setBundleScheduleItem(Bundle bundleScheduleItem) {
        this.bundleScheduleItem = bundleScheduleItem;
    }
}

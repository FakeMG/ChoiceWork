package com.example.decisions.controller;

import android.content.Context;

import com.example.decisions.R;
import com.example.decisions.model.WaitingBoardModel;
import com.example.decisions.model.schedule.ScheduleBoardModel;

import java.util.ArrayList;

public class WaitingFragmentController {
    private Context context;
    private ArrayList<WaitingBoardModel> listWaiting;

    public WaitingFragmentController(Context context) {
        this.context = context;
        this.listWaiting = new ArrayList<>();
        dataInitialize();
    }

    private ArrayList<WaitingBoardModel> dataInitialize() {
        for (int i = 1; i <= 13; i++) {
            listWaiting.add(new WaitingBoardModel("Waiting " + i, R.drawable.work_out_01));
        }
        return listWaiting;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<WaitingBoardModel> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(ArrayList<WaitingBoardModel> listWaiting) {
        this.listWaiting = listWaiting;
    }
}

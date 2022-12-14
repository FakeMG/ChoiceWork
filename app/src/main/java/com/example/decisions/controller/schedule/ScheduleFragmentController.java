package com.example.decisions.controller.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.model.schedule.ScheduleBoardModel;
import com.example.decisions.view.activity.ScheduleBoardActivity;

import java.util.ArrayList;

public class ScheduleFragmentController {
    private Context context;
    private ArrayList<ScheduleBoardModel> listSchedule;

    public ScheduleFragmentController(Context context) {
        this.context = context;
        this.listSchedule = new ArrayList<>();
        dataInitialize();
    }

    public void onClickGoToBoard(ScheduleBoardModel scheduleBoardModel) {
        Bundle bundleScheduleBoard = new Bundle();
        bundleScheduleBoard.putSerializable("schedule_board", scheduleBoardModel);
        Intent intent = new Intent(getContext(), ScheduleBoardActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("schedule_board", scheduleBoardModel);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private ArrayList<ScheduleBoardModel> dataInitialize() {

        listSchedule.add(new ScheduleBoardModel("At day", R.drawable.day_time_01));
        listSchedule.add(new ScheduleBoardModel("Study", R.drawable.monday_01));
        listSchedule.add(new ScheduleBoardModel("At night", R.drawable.night_time_01));
        listSchedule.add(new ScheduleBoardModel("Activities", R.drawable.sunday_01));

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
}

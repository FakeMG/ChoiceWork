package com.example.decisions.controller.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.schedule.ScheduleActionModel;
import com.example.decisions.model.schedule.ScheduleBoardModel;
import com.example.decisions.view.activity.ChooseImageActivity;
import com.example.decisions.view.activity.ScheduleBoardActivity;
import com.example.decisions.view.fragment.schedule.ScheduleBoardFragment;

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
        listActionSchedule.add(new ScheduleActionModel("Working", R.drawable.working_out_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
        listActionSchedule.add(new ScheduleActionModel("Eating", R.drawable.eating_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
        listActionSchedule.add(new ScheduleActionModel("Singing", R.drawable.singing_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
        listActionSchedule.add(new ScheduleActionModel("Brushing", R.drawable.brushing_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
        listActionSchedule.add(new ScheduleActionModel("Sleeping", R.drawable.sleeping_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
    }

    public void setHeaderData() {
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

    public void setOnClickEditTitle(TextView nameScheduleActivity, EditText editNameScheduleActivity, ImageView editNameScheduleActivityMode) {
        editNameScheduleActivityMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editNameScheduleActivity.getVisibility() == View.INVISIBLE) {
                    editNameScheduleActivity.setText(nameScheduleActivity.getText());
                    nameScheduleActivity.setVisibility(View.INVISIBLE);
                    editNameScheduleActivity.setVisibility(View.VISIBLE);

                    editNameScheduleActivityMode.setImageResource(R.drawable.ic_baseline_done_24);

                }
                else {
                    nameScheduleActivity.setText(editNameScheduleActivity.getText());
                    nameScheduleActivity.setVisibility(View.VISIBLE);
                    editNameScheduleActivity.setVisibility(View.INVISIBLE);

                    editNameScheduleActivityMode.setImageResource(R.drawable.ic_baseline_edit_24);
                }
            }
        });
    }

    public void setOnClickAddScheduleActivity(ImageView addScheduleActivity, ScheduleBoardFragment scheduleBoardFragment) {
        addScheduleActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddScheduleActivity(scheduleBoardFragment);
            }
        });
    }

    private void AddScheduleActivity(ScheduleBoardFragment scheduleBoardFragment) {
        Context context = scheduleBoardFragment.getContext();
        Intent intent = new Intent(context, ChooseImageActivity.class);
        context.startActivity(intent);
//        int pos = scheduleBoardFragment.scheduleBoardAdapter.getListScheduleAction().size();
//        scheduleBoardFragment.scheduleBoardAdapter.getListScheduleAction().add(new ScheduleActionModel("Schedule action " + pos, R.drawable.learning_01, R.drawable.ic_baseline_double_arrow_32, R.drawable.check_01));
//        scheduleBoardFragment.scheduleBoardAdapter.notifyDataSetChanged();
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

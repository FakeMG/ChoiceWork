package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleItemModel;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        ScheduleItemModel scheduleItemModel = (ScheduleItemModel) bundle.get("schedule_item");

        ImageView schedule_iv = findViewById(R.id.schedule_iv);
        schedule_iv.setImageResource(scheduleItemModel.getResourceImage());
    }
}
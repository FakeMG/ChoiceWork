package com.example.decisions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        ScheduleItem scheduleItem = (ScheduleItem) bundle.get("schedule_item");

        ImageView schedule_iv = findViewById(R.id.schedule_iv);
        schedule_iv.setImageResource(scheduleItem.getResourceImage());
    }
}
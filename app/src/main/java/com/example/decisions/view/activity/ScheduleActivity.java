package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleBoardModel;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        ScheduleBoardModel scheduleBoardModel = (ScheduleBoardModel) bundle.get("schedule_item");

        TextView sche_name_activity = findViewById(R.id.sche_name_activity);
        ImageView sche_img_activity = findViewById(R.id.sche_img_activity);
        sche_name_activity.setText(scheduleBoardModel.getName());
        sche_img_activity.setImageResource(scheduleBoardModel.getResourceImage());
    }
}
package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.controller.ScheduleBoardController;
import com.example.decisions.controller.system.IReplaceFragment;
import com.example.decisions.view.fragment.schedule.ScheduleBoardFragment;

public class ScheduleBoardActivity extends AppCompatActivity implements IReplaceFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_board);

        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            return;
        }

        ScheduleBoardController scheduleBoardController = new ScheduleBoardController(findViewById(R.id.name_schedule_board), bundle);
        scheduleBoardController.setHeaderData();

        ScheduleBoardFragment scheduleBoardFragment = new ScheduleBoardFragment();
        scheduleBoardFragment.setArguments(bundle);

        TextView nameScheduleActivity = findViewById(R.id.schedule_name_activity);
        EditText editNameScheduleActivity = findViewById(R.id.schedule_edit_name_activity);
        ImageView editNameScheduleActivityMode = findViewById(R.id.edit_schedule_name_activity);
        ImageView addScheduleActivity = findViewById(R.id.add_schedule_item);

        scheduleBoardController.setOnClickEditTitle(nameScheduleActivity, editNameScheduleActivity, editNameScheduleActivityMode);
        scheduleBoardController.setOnClickAddScheduleActivity(addScheduleActivity, scheduleBoardFragment);

        replaceFragment(R.id.schedule_board_fragment_container_view, scheduleBoardFragment);
    }

    @Override
    public void replaceFragment(int fragmentId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
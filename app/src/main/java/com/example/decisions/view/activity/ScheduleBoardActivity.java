package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.decisions.R;
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

        ScheduleBoardFragment scheduleBoardFragment = new ScheduleBoardFragment();
        scheduleBoardFragment.setArguments(bundle);

        replaceFragment(R.id.fragment_schedule_board, scheduleBoardFragment);
    }

    @Override
    public void replaceFragment(int fragmentId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
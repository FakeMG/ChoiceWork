package com.example.decisions.view.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.decisions.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addBtn;
    private Dialog addTaskDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // link bottom navigation and fragments
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if (navDestination.getId() == R.id.schedule) {
                    getSupportActionBar().setTitle("Schedule");
                }
                if (navDestination.getId() == R.id.waiting) {
                    getSupportActionBar().setTitle("Waiting");
                }
                if (navDestination.getId() == R.id.feeling) {
                    getSupportActionBar().setTitle("Feeling");
                }
                if (navDestination.getId() == R.id.library) {
                    getSupportActionBar().setTitle("Library");
                }
            }
        });

        addTaskDialog = new Dialog(this);

        addBtn = findViewById(R.id.floatingActionButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTaskDialog.setContentView(R.layout.activity_add_task);

                Button cancelBtn = addTaskDialog.findViewById(R.id.btn_cancel_task);
                Button saveBtn = addTaskDialog.findViewById(R.id.btn_save_task);
                cancelBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addTaskDialog.dismiss();
                    }
                });
                addTaskDialog.show();
            }
        });
    }
}
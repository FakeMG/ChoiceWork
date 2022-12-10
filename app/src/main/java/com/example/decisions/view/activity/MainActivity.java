package com.example.decisions.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.decisions.ImageSaver;
import com.example.decisions.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton addBtn;
    private Dialog addTaskDialog;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService writeExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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
                Intent moveToAddActivity = new Intent(getBaseContext(), AddTaskActivity.class);
                startActivity(moveToAddActivity);
//                addTaskDialog.setContentView(R.layout.activity_add_task);
//
//                ImageView imgView = addTaskDialog.findViewById(R.id.imageView);
//                Button cancelBtn = addTaskDialog.findViewById(R.id.btn_cancel_task);
//                Button saveBtn = addTaskDialog.findViewById(R.id.btn_save_task);
//
//                cancelBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        addTaskDialog.dismiss();
//                    }
//                });
//
//                imgView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent test = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        registerForActivityResult(
//                                new ActivityResultContracts.StartActivityForResult(),
//                                new ActivityResultCallback<ActivityResult>() {
//                                    @Override
//                                    public void onActivityResult(ActivityResult result) {
//                                        if (result.getResultCode() == Activity.RESULT_OK) {
//                                            Intent data = result.getData();
//                                            Uri imgUri = data.getData();
//                                            imgView.setImageURI(imgUri);
//
//                                            writeExecutor.execute(() -> {
//                                                try {
//                                                    ImageSaver.saveFromUri(getBaseContext(), imgUri);
//                                                } catch (FileNotFoundException e) {
//                                                    e.printStackTrace();
//                                                }
//                                            });
//                                        }
//                                    }
//                                }).launch(test);
//                    }
//                });
//
//                addTaskDialog.show();
            }

        });
    }
}
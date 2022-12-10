package com.example.decisions.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.decisions.ImageSaver;
import com.example.decisions.R;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddTaskActivity extends AppCompatActivity {

    private Button uploadImgBtn;
    private ImageView imgView;
    private TextView textView;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService writeExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        uploadImgBtn = findViewById(R.id.btn_save_task);
        imgView = findViewById(R.id.imageView);
        textView = findViewById(R.id.et_task_title);

        uploadImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent test = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                uploadImgResultLauncher.launch(test);
            }
        });
    }

    ActivityResultLauncher<Intent> uploadImgResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Uri imgUri = data.getData();
                        imgView.setImageURI(imgUri);

                        writeExecutor.execute(() -> {
                            try {
                                ImageSaver.saveFromUri(getBaseContext(), imgUri);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            });
}
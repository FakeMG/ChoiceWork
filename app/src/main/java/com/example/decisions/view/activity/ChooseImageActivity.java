package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.controller.ChooseImageController;
import com.example.decisions.controller.system.IReplaceFragment;
import com.example.decisions.view.fragment.ChooseImageFragment;

public class ChooseImageActivity extends AppCompatActivity implements IReplaceFragment {

    private ImageView chosenImage;
    private TextView chosenImageName;
    private ImageView saveChosenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);

        chosenImage = findViewById(R.id.chosen_image);
        chosenImageName = findViewById(R.id.chosen_image_name);
        saveChosenImage = findViewById(R.id.save_chosen_img);

        ChooseImageController chooseImageController = new ChooseImageController(this);
        chooseImageController.setOnClickSaveChosenImg(saveChosenImage, chosenImage, chosenImageName);

        replaceFragment(R.id.choose_image_fragment_container_view, new ChooseImageFragment(chosenImage, chosenImageName , saveChosenImage));
    }

    @Override
    public void replaceFragment(int fragmentId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
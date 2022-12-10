package com.example.decisions.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.controller.system.IReplaceFragment;
import com.example.decisions.view.fragment.ChooseImageFragment;

public class ChooseImageActivity extends AppCompatActivity implements IReplaceFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);

        replaceFragment(R.id.choose_image_fragment_container_view, new ChooseImageFragment());

    }

    @Override
    public void replaceFragment(int fragmentId, Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
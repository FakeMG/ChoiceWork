package com.example.decisions.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.controller.ChooseImageController;
import com.example.decisions.controller.system.IChooseImage;
import com.example.decisions.model.ChooseImageModel;
import com.example.decisions.view.activity.ChooseImageActivity;
import com.example.decisions.view.adapter.ChooseImageAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private RecyclerView rcv_choose_image;
    private ChooseImageController chooseImageController;
    private ChooseImageAdapter chooseImageAdapter;

    private ImageView chosenImage;
    private TextView chosenImageName;
    private ImageView saveChosenImage;

    public ChooseImageFragment() {
        // Required empty public constructor
    }

    public ChooseImageFragment(ImageView chosenImage, TextView chosenImageName, ImageView saveChosenImage) {
        this.chosenImage = chosenImage;
        this.chosenImageName = chosenImageName;
        this.saveChosenImage = saveChosenImage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chooseImageController = new ChooseImageController(getContext());
        chooseImageController.dataInitialize();
        ArrayList<ChooseImageModel> listImage = chooseImageController.getListImage();

        rcv_choose_image = view.findViewById(R.id.rcv_choose_image);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_choose_image.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcv_choose_image.getContext(), linearLayoutManager.getOrientation());
        rcv_choose_image.addItemDecoration(dividerItemDecoration);

        chooseImageAdapter = new ChooseImageAdapter(getContext(), listImage, new IChooseImage() {
            @Override
            public void onChooseImage(ChooseImageModel chooseImageModel) {
                chooseImageController.onChooseImage(chooseImageModel, chosenImage, chosenImageName, saveChosenImage);
            }
        });
        rcv_choose_image.setAdapter(chooseImageAdapter);
        chooseImageAdapter.notifyDataSetChanged();
    }
}
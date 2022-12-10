package com.example.decisions.controller;

import android.content.Context;

import com.example.decisions.R;
import com.example.decisions.model.ChooseImageModel;

import java.util.ArrayList;

public class ChooseImageController {
    private Context context;
    private ArrayList<ChooseImageModel> listImage;

    public ChooseImageController(Context context) {
        this.context = context;
    }

    public void dataInitialize() {
        listImage = new ArrayList<>();
        listImage.add(new ChooseImageModel("brushing", R.drawable.brushing_01));
        listImage.add(new ChooseImageModel("day time", R.drawable.day_time_01));
        listImage.add(new ChooseImageModel("eating", R.drawable.eating_01));
        listImage.add(new ChooseImageModel("going to school", R.drawable.going_to_school_01));
        listImage.add(new ChooseImageModel("monday", R.drawable.monday_01));
        listImage.add(new ChooseImageModel("night time", R.drawable.night_time_01));
        listImage.add(new ChooseImageModel("singing", R.drawable.singing_01));
        listImage.add(new ChooseImageModel("sleeping", R.drawable.sleeping_01));
        listImage.add(new ChooseImageModel("sun", R.drawable.sun_01));
        listImage.add(new ChooseImageModel("sunday", R.drawable.sunday_01));
        listImage.add(new ChooseImageModel("waking up", R.drawable.waking_up_01));
        listImage.add(new ChooseImageModel("working out", R.drawable.working_out_01));
    }

    public void setListImage(ArrayList<ChooseImageModel> listImage) {
        this.listImage = listImage;
    }

    public ArrayList<ChooseImageModel> getListImage() {
        return listImage;
    }
}

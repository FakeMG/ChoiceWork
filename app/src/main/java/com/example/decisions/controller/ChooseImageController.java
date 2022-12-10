package com.example.decisions.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.ChooseImageModel;
import com.example.decisions.view.activity.ScheduleBoardActivity;

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

    public void onChooseImage(ChooseImageModel chooseImageModel, ImageView chosenImage, TextView chosenImageName, ImageView saveChosenImage) {
        chosenImage.setImageResource(chooseImageModel.getResourceImage());
        chosenImage.setTag(Integer.toString(chooseImageModel.getResourceImage()));
        chosenImageName.setText(chooseImageModel.getName());
        saveChosenImage.setImageResource(R.drawable.ic_baseline_save_24_black);
        saveChosenImage.setClickable(true);
    }

    public void setOnClickSaveChosenImg(ImageView saveChosenImage, ImageView chosenImage, TextView chosenImageName) {
        saveChosenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ScheduleBoardActivity.class);
                Bundle bundle = new Bundle();
                ChooseImageModel chooseImageModel = new ChooseImageModel(chosenImageName.getText().toString(), Integer.parseInt(chosenImage.getTag().toString()));
                bundle.putSerializable("chosen_image", chooseImageModel);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }
}

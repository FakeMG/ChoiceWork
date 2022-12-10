package com.example.decisions.controller.feeling;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.model.FeelingBoardModel;
import com.example.decisions.view.activity.FeelingBoardActivity;

import java.util.ArrayList;

public class FeelingFragmentController {
    private Context context;
    private ArrayList<FeelingBoardModel> listFeeling;

    public FeelingFragmentController(Context context) {
        this.context = context;
        this.listFeeling = new ArrayList<>();
        dataInitialize();
    }

    public void onClickGoToBoard(FeelingBoardModel feelingBoardModel) {
        Bundle bundleFeelingBoard = new Bundle();
        bundleFeelingBoard.putSerializable("feeling_board", feelingBoardModel);

        Intent intent = new Intent(getContext(), FeelingBoardActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("feeling_board", feelingBoardModel);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private ArrayList<FeelingBoardModel> dataInitialize() {
        for (int i = 1; i <= 13; i++) {
            listFeeling.add(new FeelingBoardModel("Feeling " + i, R.drawable.sleeping_01));
        }
        return listFeeling;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<FeelingBoardModel> getListFeeling() {
        return listFeeling;
    }

    public void setListFeeling(ArrayList<FeelingBoardModel> listFeeling) {
        this.listFeeling = listFeeling;
    }
}

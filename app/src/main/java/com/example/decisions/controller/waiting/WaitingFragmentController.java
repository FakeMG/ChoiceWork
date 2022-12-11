package com.example.decisions.controller.waiting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.decisions.R;
import com.example.decisions.model.WaitingBoardModel;
import com.example.decisions.view.activity.WaitingBoardActivity;

import java.util.ArrayList;

public class WaitingFragmentController {
    private Context context;
    private ArrayList<WaitingBoardModel> listWaiting;

    public WaitingFragmentController(Context context) {
        this.context = context;
        this.listWaiting = new ArrayList<>();
        dataInitialize();
    }

    public void onClickGoToBoard(WaitingBoardModel waitingBoardModel) {
        Bundle bundleWaitingBoard = new Bundle();
        bundleWaitingBoard.putSerializable("waiting_board", waitingBoardModel);
        Intent intent = new Intent(getContext(), WaitingBoardActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("waiting_board", waitingBoardModel);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private ArrayList<WaitingBoardModel> dataInitialize() {
        listWaiting.add(new WaitingBoardModel("Eating", R.drawable.eating_01));
        listWaiting.add(new WaitingBoardModel("Singing", R.drawable.singing_01));

        return listWaiting;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<WaitingBoardModel> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(ArrayList<WaitingBoardModel> listWaiting) {
        this.listWaiting = listWaiting;
    }
}

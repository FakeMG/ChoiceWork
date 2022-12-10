package com.example.decisions.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.controller.feeling.FeelingFragmentController;
import com.example.decisions.controller.system.IClickFeelingBoard;
import com.example.decisions.model.FeelingBoardModel;
import com.example.decisions.view.adapter.FeelingFragmentAdapter;

import java.util.ArrayList;

public class FeelingFragment extends Fragment {

    private RecyclerView rcv_feeling;
    private FeelingFragmentController feelingFragmentController;

    public FeelingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feeling, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        feelingFragmentController = new FeelingFragmentController(getContext());
        ArrayList<FeelingBoardModel> listFeeling = feelingFragmentController.getListFeeling();

        rcv_feeling = view.findViewById(R.id.rcv_feeling);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcv_feeling.setLayoutManager(gridLayoutManager);
        rcv_feeling.setHasFixedSize(true);

        FeelingFragmentAdapter feelingFragmentAdapter = new FeelingFragmentAdapter(getContext(), listFeeling, new IClickFeelingBoard() {
            @Override
            public void onClickFeelingBoard(FeelingBoardModel feelingBoardModel) {
                feelingFragmentController.onClickGoToBoard(feelingBoardModel);
            }
        });

        feelingFragmentAdapter.setHasStableIds(true);
        rcv_feeling.setAdapter(feelingFragmentAdapter);
        feelingFragmentAdapter.notifyDataSetChanged();
    }
}
package com.example.decisions.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.decisions.R;
import com.example.decisions.controller.WaitingFragmentController;
import com.example.decisions.controller.system.IClickWaitingBoard;
import com.example.decisions.model.WaitingBoardModel;
import com.example.decisions.view.adapter.WaitingFragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WaitingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WaitingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rcv_waiting;
    private WaitingFragmentController waitingFragmentController;

    public WaitingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Waiting.
     */
    // TODO: Rename and change types and number of parameters
    public static WaitingFragment newInstance(String param1, String param2) {
        WaitingFragment fragment = new WaitingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_waiting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        waitingFragmentController = new WaitingFragmentController(getContext());
        ArrayList<WaitingBoardModel> listWaiting = waitingFragmentController.getListWaiting();

        rcv_waiting = view.findViewById(R.id.rcv_waiting);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcv_waiting.setLayoutManager(gridLayoutManager);
        rcv_waiting.setHasFixedSize(true);

        WaitingFragmentAdapter waitingFragmentAdapter = new WaitingFragmentAdapter(getContext(), listWaiting, new IClickWaitingBoard() {
            @Override
            public void onClickWaitingBoard(WaitingBoardModel waitingBoardModel) {
                waitingFragmentController.onClickGoToBoard(waitingBoardModel);
            }
        });

        waitingFragmentAdapter.setHasStableIds(true);
        rcv_waiting.setAdapter(waitingFragmentAdapter);
        waitingFragmentAdapter.notifyDataSetChanged();
    }
}
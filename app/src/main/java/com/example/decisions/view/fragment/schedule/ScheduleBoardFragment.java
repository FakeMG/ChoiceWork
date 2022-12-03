package com.example.decisions.view.fragment.schedule;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.decisions.R;
import com.example.decisions.controller.ScheduleBoardController;
import com.example.decisions.model.ScheduleActionModel;
import com.example.decisions.view.adapter.ScheduleBoardAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScheduleBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleBoardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView rcv_schedule_action;
    private ScheduleBoardController scheduleBoardController;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    public ScheduleBoardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleBoardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleBoardFragment newInstance(String param1, String param2) {
        ScheduleBoardFragment fragment = new ScheduleBoardFragment();
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
        view = inflater.inflate(R.layout.fragment_schedule_board, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scheduleBoardController = new ScheduleBoardController(getContext());

        scheduleBoardController.dataInitialize();
        ArrayList<ScheduleActionModel> listActionSchedule = scheduleBoardController.getListActionSchedule();

        rcv_schedule_action = view.findViewById(R.id.rcv_schedule_action);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_schedule_action.setLayoutManager(linearLayoutManager);

        ScheduleBoardAdapter scheduleBoardAdapter = new ScheduleBoardAdapter(getContext(), listActionSchedule);
        rcv_schedule_action.setAdapter(scheduleBoardAdapter);
        scheduleBoardAdapter.notifyDataSetChanged();

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder scheduleActionDragged, @NonNull RecyclerView.ViewHolder target) {
                int positionDragged = scheduleActionDragged.getAdapterPosition();
                int positionTarget = target.getAdapterPosition();

                Collections.swap(scheduleBoardController.getListActionSchedule(), positionDragged, positionTarget);
                scheduleBoardAdapter.notifyItemMoved(positionDragged, positionTarget);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        itemTouchHelper.attachToRecyclerView(rcv_schedule_action);
    }
}
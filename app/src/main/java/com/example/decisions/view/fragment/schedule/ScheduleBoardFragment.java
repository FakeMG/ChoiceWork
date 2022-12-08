package com.example.decisions.view.fragment.schedule;

import android.graphics.Canvas;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.controller.ScheduleBoardController;
import com.example.decisions.model.ScheduleActionModel;
import com.example.decisions.model.ScheduleBoardModel;
import com.example.decisions.view.activity.MainActivity;
import com.example.decisions.view.adapter.ScheduleBoardAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

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
    public ScheduleBoardAdapter scheduleBoardAdapter;

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

        // init controller
        scheduleBoardController = new ScheduleBoardController(getContext());

        // create fake data
        scheduleBoardController.dataInitialize();
        ArrayList<ScheduleActionModel> listActionSchedule = scheduleBoardController.getListActionSchedule();

        // get RecyclerView
        rcv_schedule_action = view.findViewById(R.id.rcv_schedule_action);

        // set up linear layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv_schedule_action.setLayoutManager(linearLayoutManager);

        scheduleBoardAdapter = new ScheduleBoardAdapter(getContext(), listActionSchedule);
        rcv_schedule_action.setAdapter(scheduleBoardAdapter);
        scheduleBoardAdapter.notifyDataSetChanged();

        final ScheduleActionModel[] deletedItem = {null};

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT) {
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
                int positionItem = viewHolder.getAdapterPosition();
                deletedItem[0] = listActionSchedule.get(positionItem);
                listActionSchedule.remove(positionItem);
                scheduleBoardAdapter.notifyItemRemoved(positionItem);
                Snackbar.make(rcv_schedule_action, deletedItem[0].getName(), Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                listActionSchedule.add(positionItem, deletedItem[0]);
                                scheduleBoardAdapter.notifyItemInserted(positionItem);
                            }
                        }).show();
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                        .addSwipeLeftBackgroundColor(ContextCompat.getColor(getContext(), R.color.red))
                        .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete)
                        .create()
                        .decorate();
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        });
        itemTouchHelper.attachToRecyclerView(rcv_schedule_action);
    }
}
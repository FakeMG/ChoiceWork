package com.example.decisions;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.decisions.system.IClickScheduleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Schedule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Schedule extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<ScheduleItem> list_schedule;
    private RecyclerView rcv_schedule;

    public Schedule() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Schedule.
     */
    // TODO: Rename and change types and number of parameters
    public static Schedule newInstance(String param1, String param2) {
        Schedule fragment = new Schedule();
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
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        rcv_schedule = view.findViewById(R.id.rcv_schedule);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rcv_schedule.setLayoutManager(gridLayoutManager);
        rcv_schedule.setHasFixedSize(true);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(getContext(), list_schedule, new IClickScheduleItem() {
            @Override
            public void onClickScheduleItem(ScheduleItem scheduleItem) {
                onClickGoToDetail(scheduleItem);
            }
        });
        scheduleAdapter.setHasStableIds(true);
        rcv_schedule.setAdapter(scheduleAdapter);
        scheduleAdapter.notifyDataSetChanged();
    }

    private void onClickGoToDetail(ScheduleItem scheduleItem) {
        Intent intent = new Intent(getContext(), ScheduleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("schedule_item", scheduleItem);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }

    private void dataInitialize() {
        list_schedule = new ArrayList<>();
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));

        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));

        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));

        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));

        list_schedule.add(new ScheduleItem(R.drawable.ic_launcher_background));
    }
}
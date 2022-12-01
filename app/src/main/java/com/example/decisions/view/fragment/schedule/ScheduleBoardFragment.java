package com.example.decisions.view.fragment.schedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleBoardModel;

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

    private TextView scheduleBoardTv;
    private ImageView scheduleBoardIv;

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
        scheduleBoardTv = view.findViewById(R.id.schedule_name_activity);
        scheduleBoardIv = view.findViewById(R.id.schedule_img_activity);

        Bundle bundle = getArguments();

        if (bundle != null) {
            ScheduleBoardModel scheduleBoardModel = (ScheduleBoardModel) bundle.get("schedule_board");
            if (scheduleBoardModel != null) {
                scheduleBoardTv.setText(scheduleBoardModel.getName());
                scheduleBoardIv.setImageResource(scheduleBoardModel.getResourceImage());
            }
        }

        return view;
    }
}
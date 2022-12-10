package com.example.decisions.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.view.adapter.LibraryAdapter;
import com.example.decisions.viewModel.LibraryFragmentViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LibraryFragment extends Fragment {

    private FloatingActionButton addBtn;
    private LibraryFragmentViewModel viewModel;
    private RecyclerView rcv_library;

    public LibraryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcv_library = view.findViewById(R.id.rcv_library);
        LibraryAdapter adapter = new LibraryAdapter();
        rcv_library.setAdapter(adapter);
        rcv_library.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(LibraryFragmentViewModel.class);
        viewModel.getAllTasks().observe(getViewLifecycleOwner(), tasks -> {
            adapter.setData(tasks);
        });

//        addBtn = view.findViewById(R.id.floatingActionButton);
//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent moveToAddActivity = new Intent(getActivity(), AddTaskActivity.class);
//                startActivity(moveToAddActivity);
//            }
//        });
    }
}
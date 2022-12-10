package com.example.decisions.view.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.database.Task;

import java.util.Collections;
import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    private List<Task> taskArrayList = Collections.emptyList(); ;

    @NonNull
    @Override
    public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library, parent, false);
        return new LibraryAdapter.LibraryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        holder.taskTitle.setText(taskArrayList.get(position).name);
        holder.taskImg.setImageURI(Uri.parse(taskArrayList.get(position).picturePath));
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class LibraryViewHolder extends RecyclerView.ViewHolder {

        private TextView taskTitle;
        private ImageView taskImg;

        public LibraryViewHolder(@NonNull View itemView) {
            super(itemView);

            taskImg = itemView.findViewById(R.id.iv_item_lib);
            taskTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public void setData(List<Task> list) {
        taskArrayList = list;
        notifyDataSetChanged();
    }
}

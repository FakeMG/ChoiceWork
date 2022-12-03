package com.example.decisions.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleActionModel;

import java.util.ArrayList;

public class ScheduleBoardAdapter extends RecyclerView.Adapter<ScheduleBoardAdapter.ScheduleBoardHolder> {

    private Context context;
    private ArrayList<ScheduleActionModel> listScheduleAction;

    public ScheduleBoardAdapter(Context context, ArrayList<ScheduleActionModel> listScheduleAction) {
        this.context = context;
        this.listScheduleAction = listScheduleAction;
    }

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public ScheduleBoardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_action_schedule, parent, false);
        return new ScheduleBoardHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ScheduleBoardHolder holder, int position) {
        ScheduleActionModel scheduleActionModel = listScheduleAction.get(position);
        if (scheduleActionModel == null) {
            return;
        }
        holder.imgScheduleAction.setImageResource(scheduleActionModel.getResourceImage());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (listScheduleAction != null) {
            return listScheduleAction.size();
        }
        return 0;
    }

    public class ScheduleBoardHolder extends RecyclerView.ViewHolder {
        private ImageView imgScheduleAction;

        public ScheduleBoardHolder(@NonNull View itemView) {
            super(itemView);

            imgScheduleAction = itemView.findViewById(R.id.img_schedule_action);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ScheduleActionModel> getListScheduleAction() {
        return listScheduleAction;
    }

    public void setListScheduleAction(ArrayList<ScheduleActionModel> listScheduleAction) {
        this.listScheduleAction = listScheduleAction;
    }
}

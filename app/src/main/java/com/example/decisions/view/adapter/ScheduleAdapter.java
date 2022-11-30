package com.example.decisions.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.model.ScheduleItemModel;
import com.example.decisions.controller.system.IClickScheduleItem;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private Context context;
    private ArrayList<ScheduleItemModel> listSchedule;
    private IClickScheduleItem iClickScheduleItem;

    public ScheduleAdapter(Context context, ArrayList<ScheduleItemModel> listSchedule, IClickScheduleItem iClickScheduleItem) {
        this.context = context;
        this.listSchedule = listSchedule;
        this.iClickScheduleItem = iClickScheduleItem;
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
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
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
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        ScheduleItemModel scheduleItemModel = listSchedule.get(position);
        if (scheduleItemModel == null) {
            return;
        }
        holder.imgSchedule.setImageResource(scheduleItemModel.getResourceImage());

        // handle onClick event
        holder.cardViewSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickScheduleItem.onClickScheduleItem(scheduleItemModel);
            }
        });
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (listSchedule != null) {
            return listSchedule.size();
        }
        return 0;
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewSchedule;
        private ImageView imgSchedule;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewSchedule = itemView.findViewById(R.id.card_schedule);
            imgSchedule = itemView.findViewById(R.id.img_schedule);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ScheduleItemModel> getListSchedule() {
        return listSchedule;
    }

    public void setListSchedule(ArrayList<ScheduleItemModel> listSchedule) {
        this.listSchedule = listSchedule;
    }
}

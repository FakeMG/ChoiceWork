package com.example.decisions.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.controller.system.IClickWaitingBoard;
import com.example.decisions.model.WaitingBoardModel;

import java.util.ArrayList;

public class WaitingFragmentAdapter extends RecyclerView.Adapter<WaitingFragmentAdapter.WaitingViewHolder> {

    private Context context;
    private ArrayList<WaitingBoardModel> listWaiting;
    private IClickWaitingBoard iClickWaitingBoard;

    public WaitingFragmentAdapter(Context context, ArrayList<WaitingBoardModel> listWaiting, IClickWaitingBoard iClickWaitingBoard) {
        this.context = context;
        this.listWaiting = listWaiting;
        this.iClickWaitingBoard = iClickWaitingBoard;
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
    public WaitingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_waiting, parent, false);
        return new WaitingViewHolder(view);
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
    public void onBindViewHolder(@NonNull WaitingViewHolder holder, int position) {
        WaitingBoardModel waitingBoardModel = listWaiting.get(position);
        if (waitingBoardModel == null) {
            return;
        }
        holder.nameWaiting.setText(waitingBoardModel.getName());
        holder.imgWaiting.setImageResource(waitingBoardModel.getResourceImage());

        // handle onClick event
        holder.cardViewWaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickWaitingBoard.onClickWaitingBoard(waitingBoardModel);
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
        if (listWaiting != null) {
            return listWaiting.size();
        }
        return 0;
    }

    public class WaitingViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewWaiting;
        private TextView nameWaiting;
        private ImageView imgWaiting;

        public WaitingViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewWaiting = itemView.findViewById(R.id.card_waiting);
            nameWaiting = itemView.findViewById(R.id.name_waiting);
            imgWaiting = itemView.findViewById(R.id.img_waiting);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<WaitingBoardModel> getListWaiting() {
        return listWaiting;
    }

    public void setListWaiting(ArrayList<WaitingBoardModel> listWaiting) {
        this.listWaiting = listWaiting;
    }
}

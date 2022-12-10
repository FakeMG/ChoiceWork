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
import com.example.decisions.controller.system.IClickFeelingBoard;
import com.example.decisions.model.FeelingBoardModel;

import java.util.ArrayList;

public class FeelingFragmentAdapter extends RecyclerView.Adapter<FeelingFragmentAdapter.FeelingViewHolder> {

    private Context context;
    private ArrayList<FeelingBoardModel> listFeeling;
    private IClickFeelingBoard iClickFeelingBoard;

    public FeelingFragmentAdapter(Context context, ArrayList<FeelingBoardModel> listFeeling, IClickFeelingBoard iClickFeelingBoard) {
        this.context = context;
        this.listFeeling = listFeeling;
        this.iClickFeelingBoard = iClickFeelingBoard;
    }
    @NonNull
    @Override
    public FeelingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feeling, parent, false);
        return new FeelingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeelingViewHolder holder, int position) {
        FeelingBoardModel feelingBoardModel = listFeeling.get(position);
        if (feelingBoardModel == null) {
            return;
        }
        holder.nameFeeling.setText(feelingBoardModel.getName());
        holder.imgFeeling.setImageResource(feelingBoardModel.getResourceImage());

        // handle onClick event
        holder.cardViewFeeling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickFeelingBoard.onClickFeelingBoard(feelingBoardModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listFeeling != null) {
            return listFeeling.size();
        }
        return 0;
    }

    public class FeelingViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewFeeling;
        private TextView nameFeeling;
        private ImageView imgFeeling;

        public FeelingViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewFeeling = itemView.findViewById(R.id.card_feeling);
            nameFeeling = itemView.findViewById(R.id.name_feeling);
            imgFeeling = itemView.findViewById(R.id.img_feeling);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<FeelingBoardModel> getListFeeling() {
        return listFeeling;
    }

    public void setListFeeling(ArrayList<FeelingBoardModel> listFeeling) {
        this.listFeeling = listFeeling;
    }
}

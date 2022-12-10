package com.example.decisions.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.controller.system.IChooseImage;
import com.example.decisions.model.ChooseImageModel;

import java.util.ArrayList;

public class ChooseImageAdapter extends RecyclerView.Adapter<ChooseImageAdapter.ChooseImageHolder> {

    private Context context;
    private ArrayList<ChooseImageModel> listImage;
    private IChooseImage iChooseImage;

    public ChooseImageAdapter(Context context, ArrayList<ChooseImageModel> listImage, IChooseImage iChooseImage) {
        this.context = context;
        this.listImage = listImage;
        this.iChooseImage = iChooseImage;
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
    public ChooseImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);

        return new ChooseImageHolder(view);
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
    public void onBindViewHolder(@NonNull ChooseImageHolder holder, int position) {
        ChooseImageModel chooseImageModel = listImage.get(position);

        holder.imageDescription.setImageResource(chooseImageModel.getResourceImage());
        holder.imageDescription.setTag(chooseImageModel.getName());
        holder.textDescription.setText(chooseImageModel.getName());

        holder.imageDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iChooseImage.onChooseImage(chooseImageModel);
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
        if (listImage != null) {
            return listImage.size();
        }
        return 0;
    }

    public class ChooseImageHolder extends RecyclerView.ViewHolder {
        private TextView textDescription;
        private ImageView imageDescription;
        public ChooseImageHolder(@NonNull View itemView) {
            super(itemView);

            textDescription = itemView.findViewById(R.id.text_description);
            imageDescription = itemView.findViewById(R.id.image_description);
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ChooseImageModel> getListImage() {
        return listImage;
    }

    public void setListImage(ArrayList<ChooseImageModel> listImage) {
        this.listImage = listImage;
    }
}

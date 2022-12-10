package com.example.decisions.view.adapter.schedule;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decisions.R;
import com.example.decisions.model.schedule.ScheduleActionModel;

import java.util.ArrayList;

public class ScheduleBoardAdapter extends RecyclerView.Adapter<ScheduleBoardAdapter.ScheduleBoardHolder> implements View.OnDragListener, View.OnLongClickListener {

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

        ImageView imgScheduleAction = view.findViewById(R.id.img_schedule_action);
        ImageView imgScheduleActionCompleted = view.findViewById(R.id.img_schedule_action_completed);

        imgScheduleAction.setOnLongClickListener(this);
        imgScheduleAction.setOnDragListener(this);

        imgScheduleActionCompleted.setOnDragListener(this);

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
        int resourceImage = scheduleActionModel.getResourceImage();
        holder.imgScheduleAction.setTag(Integer.toString(resourceImage));
        holder.imgScheduleAction.setImageResource(resourceImage);

        holder.doubleArrowRight.setImageResource(scheduleActionModel.getDoubleArrowRightImage());

        int resourceImageCompleted = scheduleActionModel.getResourceImageCompleted();
        holder.imgScheduleActionCompleted.setTag(Integer.toString(resourceImageCompleted));
        holder.imgScheduleActionCompleted.setImageResource(resourceImageCompleted);
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

    /**
     * Sets a long click listener for the ImageScheduleActionView
     * @param view View
     * @return
     */
    @Override
    public boolean onLongClick(View view) {
        ClipData.Item itemSchedule = new ClipData.Item((CharSequence) view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This creates a new ClipDescription object within the
        // ClipData and sets its MIME type to "text/plain".
        ClipData dragData = new ClipData((CharSequence) view.getTag(), new String[] { ClipDescription.MIMETYPE_TEXT_PLAIN }, itemSchedule);
        // Instantiate the drag shadow builder.
        View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(view);

        // Start the drag.
        view.startDrag(dragData, dragShadow, view, 0);

        // Hide the view
        ((ImageView) view).setImageResource(R.drawable.done_01);

        // Invalidates the view to force a redraw.
        view.invalidate();

        // Indicate that the long-click was handled.
        return true;
    }


    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int action = dragEvent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data.
                if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // Returns true to indicate that the View can accept the dragged data.
                    return true;

                }
                // Returns false to indicate that, during the current drag and drop operation,
                // this View will not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:

                // Applies a green tint to the View.
                ((ImageView)view).setColorFilter(Color.GRAY);

                // Invalidates the view to force a redraw in the new tint.
                view.invalidate();

                // Returns true; the value is ignored.
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:

                // Ignore the event.
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                // Resets the color tint to blue.
                ((ImageView)view).clearColorFilter();

                // Invalidates the view to force a redraw in the new tint.
                view.invalidate();

                // Returns true; the value is ignored.
                return true;

            case DragEvent.ACTION_DROP:

                // Gets the item containing the dragged data.
                ClipData.Item itemSchedule = dragEvent.getClipData().getItemAt(0);

                // Gets the text data from the item.
                CharSequence dragData = itemSchedule.getText();

                // Displays a message containing the dragged data.
                Toast.makeText(this.getContext(), "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                // Turns off any color tints.
                ((ImageView)view).clearColorFilter();

                // Invalidates the view to force a redraw.
                view.invalidate();

                ((ImageView) view).setTag(dragData);
                ((ImageView) view).setImageResource(Integer.parseInt(dragData.toString()));

                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:

                // Turns off any color tinting.
                ((ImageView)view).clearColorFilter();

                // Invalidates the view to force a redraw.
                view.invalidate();

                // Does a getResult(), and displays what happened.
                if (dragEvent.getResult()) {
                    Toast.makeText(this.getContext(), "The drop was handled.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this.getContext(), "The drop didn't work.", Toast.LENGTH_LONG).show();
                }

                // Returns true; the value is ignored.
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example","Unknown action type received by View.OnDragListener.");
                break;
        }
        return false;
    }

    public class ScheduleBoardHolder extends RecyclerView.ViewHolder {
        private ImageView imgScheduleAction;
        private ImageView doubleArrowRight;
        private ImageView imgScheduleActionCompleted;

        public ScheduleBoardHolder(@NonNull View itemView) {
            super(itemView);

            imgScheduleAction = itemView.findViewById(R.id.img_schedule_action);
            doubleArrowRight = itemView.findViewById(R.id.double_arrow_right);
            imgScheduleActionCompleted = itemView.findViewById(R.id.img_schedule_action_completed);
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

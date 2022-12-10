package com.example.decisions.view.decorator;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarginItemDecorator extends RecyclerView.ItemDecoration {

    private int spaceHeight;

    public MarginItemDecorator(int spaceHeight) {
        this.spaceHeight = spaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = spaceHeight;
        }

        outRect.left =  spaceHeight;
        outRect.right = spaceHeight;
        outRect.bottom = spaceHeight;
    }
}

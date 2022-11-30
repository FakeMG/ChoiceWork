package com.example.decisions;

import java.io.Serializable;

public class ScheduleItem implements Serializable {

    private int resourceImage;

    public ScheduleItem(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }
}
